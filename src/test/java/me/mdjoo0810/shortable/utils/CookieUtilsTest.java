package me.mdjoo0810.shortable.utils;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.Cookie;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CookieUtilsTest {

    @Test
    void no_constructor() {
        CookieUtils cookieUtils = new CookieUtils();
        assertNotNull(cookieUtils);
    }

    @Test
    void get_cookie_present() {
        MockHttpServletRequest mockRequest = new MockHttpServletRequest();

        Cookie tmpCookie = new Cookie("test", "test");
        mockRequest.setCookies(tmpCookie);

        Optional<Cookie> cookie = CookieUtils.getCookie(mockRequest, "test");
        assertTrue(cookie.isPresent());
    }

    @Test
    void get_cookies_null() {
        MockHttpServletRequest mockRequest = new MockHttpServletRequest();
        Optional<Cookie> cookie = CookieUtils.getCookie(mockRequest, "test_cookie");
        assertTrue(cookie.isEmpty());
    }

    @Test
    void get_cookie_empty() {
        MockHttpServletRequest mockRequest = new MockHttpServletRequest();

        Cookie tmpCookie = new Cookie("test", "test");
        mockRequest.setCookies(tmpCookie);

        Optional<Cookie> cookie = CookieUtils.getCookie(mockRequest, "test_cookie");
        assertTrue(cookie.isEmpty());
    }

    @Test
    void add_cookie() {
        MockHttpServletResponse mockResponse = new MockHttpServletResponse();
        CookieUtils.addCookie(mockResponse, "test", "test", 3600);

        assertNotNull(mockResponse.getCookie("test"));
    }

    @Test
    void delete_cookie() {
        MockHttpServletRequest mockRequest = new MockHttpServletRequest();
        Cookie tmpCookie1 = new Cookie("test1", "test");
        Cookie tmpCookie2 = new Cookie("test", "test");
        mockRequest.setCookies(tmpCookie1, tmpCookie2);

        MockHttpServletResponse mockResponse = new MockHttpServletResponse();

        CookieUtils.deleteCookie(mockRequest, mockResponse, "test");

        assertEquals(0, Objects.requireNonNull(mockResponse.getCookie("test")).getMaxAge());
    }

    @Test
    void delete_cookies_null() {
        MockHttpServletRequest mockRequest = new MockHttpServletRequest();
        MockHttpServletResponse mockResponse = new MockHttpServletResponse();

        CookieUtils.deleteCookie(mockRequest, mockResponse, "test");
        assertNull(mockResponse.getCookie("test"));
    }

}