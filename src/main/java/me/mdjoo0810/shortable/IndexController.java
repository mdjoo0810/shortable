package me.mdjoo0810.shortable;

import lombok.RequiredArgsConstructor;
import me.mdjoo0810.shortable.common.enums.CookieKey;
import me.mdjoo0810.shortable.member.application.MemberFacade;
import me.mdjoo0810.shortable.member.domain.entity.MemberInfo;
import me.mdjoo0810.shortable.utils.CookieUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final MemberFacade memberFacade;

    @GetMapping
    public String index(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        Optional<Cookie> loginUser = CookieUtils.getCookie(request, "LOGIN_USER");

        if (loginUser.isEmpty()) {
            MemberInfo memberInfo = memberFacade.registerAnonymous();
            CookieUtils.addCookie(response, CookieKey.LOGIN_USER.getValue(), memberInfo.getEmail(), 60 * 60 * 24 * 7);
        }

        return "index";
    }

}
