package me.mdjoo0810.shortable.url.application;

import me.mdjoo0810.shortable.url.domain.entity.URLInfo;
import me.mdjoo0810.shortable.url.domain.entity.URLInfoFixture;
import me.mdjoo0810.shortable.url.domain.usecase.URLs;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class URLFacadeTest {

    @Test
    void facade_test() {
        URLs mock = mock(URLs.class);
        when(mock.makeShorten(anyString(), anyString())).thenReturn(URLInfoFixture.get());
        URLFacade urlFacade = new URLFacade(mock);

        URLInfo urlInfo = urlFacade.makeShortenURL("test", "test");
        assertNotNull(urlInfo.getShortenKey());
        assertNotNull(urlInfo.getOriginalURL());
    }

    @Test
    void get_url_info() {
        URLs mock = mock(URLs.class);
        when(mock.getURLInfo(anyString())).thenReturn(URLInfoFixture.get());
        URLFacade urlFacade = new URLFacade(mock);

        String testtest = urlFacade.getOriginalURL("testtest");
        assertEquals(URLInfoFixture.get().getOriginalURL(), testtest);
    }

}