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

}