package me.mdjoo0810.shortable.url.infrastructure;

import me.mdjoo0810.shortable.url.domain.entity.URL;
import me.mdjoo0810.shortable.url.domain.entity.URLFixture;
import me.mdjoo0810.shortable.utils.KeyManager;
import me.mdjoo0810.shortable.utils.StringUtils;
import me.mdjoo0810.shortable.utils.impl.KeyManagerImpl;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class URLReaderImplTest {

    URLJpaRepository mockRepository = mock(URLJpaRepository.class);

    @Test
    void get_url_like_code() {
        URLReaderImpl reader = new URLReaderImpl(mockRepository);
        String testURL = "https://google.com";
        KeyManager keyManager = new KeyManagerImpl();
        String hash = keyManager.generate(testURL);
        String shortKey = getShortKey(keyManager, hash);
        when(mockRepository.findByHashLike(anyString())).thenReturn(Optional.of(URLFixture.get(hash)));

        Optional<URL> byCodeLike = reader.getByCodeLike(shortKey);
        assertTrue(byCodeLike.isPresent());
        assertEquals(hash, byCodeLike.get().getHash());
    }

    private String getShortKey(KeyManager keyManager, String hash) {
        StringUtils stringUtils = new StringUtils();
        String encodedStr = stringUtils.encodeUrlBase64(hash);
        return keyManager.convertShortKey(encodedStr);
    }

}