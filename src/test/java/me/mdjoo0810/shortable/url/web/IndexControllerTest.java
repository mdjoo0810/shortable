package me.mdjoo0810.shortable.url.web;

import me.mdjoo0810.shortable.IndexController;
import me.mdjoo0810.shortable.common.enums.CookieKey;
import me.mdjoo0810.shortable.member.application.MemberFacade;
import me.mdjoo0810.shortable.member.domain.entity.MemberInfo;
import me.mdjoo0810.shortable.member.domain.entity.MemberInfoFixture;
import me.mdjoo0810.shortable.url.application.URLFacade;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.Model;

import javax.servlet.http.Cookie;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IndexControllerTest {

    MemberFacade memberFacade = mock(MemberFacade.class);
    URLFacade urlFacade = mock(URLFacade.class);

    @Test
    void index_not_have_cookie() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        when(memberFacade.registerAnonymous()).thenReturn(MemberInfoFixture.get());

        IndexController controller = new IndexController(memberFacade, urlFacade);
        controller.index(null, request, response, "", "");
        Cookie cookie = response.getCookie(CookieKey.LOGIN_USER.getValue());
        assertEquals(MemberInfoFixture.get().getEmail(), Objects.requireNonNull(cookie).getValue());
    }

    @Test
    void index_has_cookie() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        MemberInfo memberInfo = MemberInfoFixture.get();

        Cookie tmpCookie = new Cookie(CookieKey.LOGIN_USER.getValue(), memberInfo.getEmail());
        request.setCookies(tmpCookie);


        IndexController controller = new IndexController(memberFacade, urlFacade);
        String index = controller.index(null, request, response, "", "");

        assertEquals("index", index);
    }

    @Test
    void index_redirect_success_shorten_url() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        Model mockModel = mock(Model.class);
        MemberInfo memberInfo = MemberInfoFixture.get();

        Cookie tmpCookie = new Cookie(CookieKey.LOGIN_USER.getValue(), memberInfo.getEmail());
        request.setCookies(tmpCookie);


        IndexController controller = new IndexController(memberFacade, urlFacade);
        String index = controller.index(mockModel, request, response, "https://test.com/short", "https://test.com/original");

        assertEquals("index", index);
    }

    @Test
    void index_redirect_failed_shorten_url() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        Model mockModel = mock(Model.class);
        MemberInfo memberInfo = MemberInfoFixture.get();

        Cookie tmpCookie = new Cookie(CookieKey.LOGIN_USER.getValue(), memberInfo.getEmail());
        request.setCookies(tmpCookie);


        IndexController controller = new IndexController(memberFacade, urlFacade);
        String index = controller.index(mockModel, request, response, "https://test.com/short", "");

        assertEquals("index", index);
    }

}