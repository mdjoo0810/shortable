package me.mdjoo0810.shortable.url.web;

import me.mdjoo0810.shortable.common.enums.CookieKey;
import me.mdjoo0810.shortable.url.application.URLFacade;
import me.mdjoo0810.shortable.url.domain.entity.URLInfoFixture;
import me.mdjoo0810.shortable.url.web.dto.ShortenURLRequestDTO;
import me.mdjoo0810.shortable.url.web.dto.ShortenURLRequestDTOFixture;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.Cookie;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UrlControllerTest {

    @Test
    void make_shorten_url() {
        MockHttpServletRequest request = new MockHttpServletRequest();

        Cookie cookie = new Cookie(CookieKey.LOGIN_USER.getValue(), "TEST");
        request.setCookies(cookie);
        URLFacade mock = mock(URLFacade.class);
        when(mock.makeShortenURL(anyString(), anyString())).thenReturn(URLInfoFixture.get());
        UrlController controller = new UrlController(mock);
        ShortenURLRequestDTO dto = ShortenURLRequestDTOFixture.get();
        RedirectAttributes redirectAttributes = new RedirectAttributesModelMap();
        String redirect = controller.makeShortenUrl(dto, redirectAttributes, request);
        assertEquals("redirect:/", redirect);
    }

    @Test
    void make_shorten_url_no_cookie() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        URLFacade mock = mock(URLFacade.class);
        when(mock.makeShortenURL(anyString(), anyString())).thenReturn(URLInfoFixture.get());
        UrlController controller = new UrlController(mock);
        ShortenURLRequestDTO dto = ShortenURLRequestDTOFixture.get();
        RedirectAttributes redirectAttributes = new RedirectAttributesModelMap();

        assertThrows(IllegalArgumentException.class, () -> {
            controller.makeShortenUrl(dto, redirectAttributes, request);
        });
    }

}