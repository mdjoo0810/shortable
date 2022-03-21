package me.mdjoo0810.shortable.url.domain.usecase;

import me.mdjoo0810.shortable.member.domain.entity.MemberFixture;
import me.mdjoo0810.shortable.member.domain.entity.MemberReader;
import me.mdjoo0810.shortable.url.domain.entity.*;
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
    URLReader mockReader = mock(URLReader.class);
    MemberReader mockMemberReader = mock(MemberReader.class);

    @Test
    void make_shorten_url() {
        when(mockMemberReader.findByEmail(MemberFixture.get().getEmail())).thenReturn(Optional.of(MemberFixture.get()));
        URLManager urlManager = new URLManager(stringUtils, keyManager, mockStore, mockReader, mockMemberReader);
        URLInfo urlInfo = urlManager.makeShorten(MemberFixture.get().getEmail(), "https://google.com");

        assertEquals("https://google.com", urlInfo.getOriginalURL());
        assertNotNull(urlInfo.getShortenKey());
    }

    @Test
    void make_shorten_url_failed_no_member() {
        when(mockMemberReader.findByEmail(MemberFixture.get().getEmail())).thenReturn(Optional.of(MemberFixture.get()));
        URLManager urlManager = new URLManager(stringUtils, keyManager, mockStore, mockReader, mockMemberReader);

        assertThrows(IllegalArgumentException.class, () -> {
            urlManager.makeShorten("no", "https://google.com");
        });
    }

    @Test
    void get_url_info() {
        URLManager urlManager = new URLManager(stringUtils, keyManager, mockStore, mockReader, mockMemberReader);
        when(mockReader.getByCodeLike(anyString())).thenReturn(Optional.of(URLFixture.get("testtest")));
        URLInfo test = urlManager.getURLInfo("testtest");
        assertEquals(URLFixture.get("testtest").getOriginalURL(), test.getOriginalURL());
    }

    @Test
    void get_url_throw_no_url() {
        URLManager urlManager = new URLManager(stringUtils, keyManager, mockStore, mockReader, mockMemberReader);
        when(mockReader.getByCodeLike("testtest")).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class, () -> urlManager.getURLInfo("testtest"));
    }

}