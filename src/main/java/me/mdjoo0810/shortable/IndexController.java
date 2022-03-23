package me.mdjoo0810.shortable;

import lombok.RequiredArgsConstructor;
import me.mdjoo0810.shortable.common.enums.CookieKey;
import me.mdjoo0810.shortable.member.application.MemberFacade;
import me.mdjoo0810.shortable.member.domain.entity.MemberInfo;
import me.mdjoo0810.shortable.url.application.URLFacade;
import me.mdjoo0810.shortable.utils.CookieUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final MemberFacade memberFacade;
    private final URLFacade urlFacade;

    @GetMapping
    public String index(
            Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(required = false, defaultValue = "") String shortenUrl,
            @RequestParam(required = false, defaultValue = "") String originalUrl
    ) {
        Optional<Cookie> loginUser = CookieUtils.getCookie(request, "LOGIN_USER");

        if (loginUser.isEmpty()) {
            MemberInfo memberInfo = memberFacade.registerAnonymous();
            CookieUtils.addCookie(response, CookieKey.LOGIN_USER.getValue(), memberInfo.getEmail(), 60 * 60 * 24 * 7);
        }

        if (!shortenUrl.equals("") && !originalUrl.equals("")) {
            model.addAttribute("shortenUrl", shortenUrl);
            model.addAttribute("originalUrl", originalUrl);
        }

        return "index";
    }

    @GetMapping("/{code}")
    public String redirect(
            @PathVariable String code
    ) {
        String originalURL = urlFacade.getOriginalURL(code);
        return "redirect:" + originalURL;
    }

    @GetMapping("/api/doc")
    public String goToAPI() {
        return "api_doc";
    }

}
