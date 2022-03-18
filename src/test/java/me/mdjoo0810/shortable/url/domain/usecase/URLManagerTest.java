package me.mdjoo0810.shortable.url.domain.usecase;

import me.mdjoo0810.shortable.member.domain.entity.MemberFixture;
import me.mdjoo0810.shortable.member.domain.entity.MemberReader;
import me.mdjoo0810.shortable.url.domain.entity.URL;
import me.mdjoo0810.shortable.url.domain.entity.URLFixture;
import me.mdjoo0810.shortable.url.domain.entity.URLInfo;
import me.mdjoo0810.shortable.url.domain.entity.URLStore;
import me.mdjoo0810.shortable.utils.KeyManager;
import me.mdjoo0810.shortable.utils.StringUtils;
import me.mdjoo0810.shortable.utils.impl.KeyManagerImpl;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class URLManagerTest {
    StringUtils stringUtils = new StringUtils();
    KeyManager keyManager = new KeyManagerImpl();
    URLStore mockStore = mock(URLStore.class);
    MemberReader mockMemberReader = mock(MemberReader.class);

    @Test
    void make_shorten_url() {
        when(mockMemberReader.findByEmail(MemberFixture.get().getEmail())).thenReturn(Optional.of(MemberFixture.get()));
        URLManager urlManager = new URLManager(stringUtils, keyManager, mockStore, mockMemberReader);
        URLInfo urlInfo = urlManager.makeShorten(MemberFixture.get().getEmail(), "https://google.com");

        assertEquals("https://google.com", urlInfo.getOriginalURL());
        assertNotNull(urlInfo.getShortenKey());
    }

    @Test
    void make_shorten_url_failed_no_member() {
        when(mockMemberReader.findByEmail(MemberFixture.get().getEmail())).thenReturn(Optional.of(MemberFixture.get()));
        URLManager urlManager = new URLManager(stringUtils, keyManager, mockStore, mockMemberReader);

        assertThrows(IllegalArgumentException.class, () -> {
            urlManager.makeShorten("no", "https://google.com");
        });
    }

}