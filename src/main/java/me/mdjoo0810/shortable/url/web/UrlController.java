package me.mdjoo0810.shortable.url.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.mdjoo0810.shortable.common.enums.CookieKey;
import me.mdjoo0810.shortable.url.application.URLFacade;
import me.mdjoo0810.shortable.url.domain.entity.URLInfo;
import me.mdjoo0810.shortable.url.web.dto.ShortenURLRequestDTO;
import me.mdjoo0810.shortable.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/url")
public class UrlController {

    private final URLFacade urlFacade;

    @PostMapping
    public String makeShortenUrl(
            @ModelAttribute ShortenURLRequestDTO dto,
            RedirectAttributes redirectAttributes,
            HttpServletRequest request
            ) {
        Optional<Cookie> cookie = CookieUtils.getCookie(request, CookieKey.LOGIN_USER.getValue());

        if (cookie.isEmpty()) throw new IllegalArgumentException("Can't access");

        URLInfo urlInfo = urlFacade.makeShortenURL(cookie.get().getValue(), dto.getOriginalUrl());

//        redirectAttributes.addAttribute("shortenUrl", "https://shortable.me/" + urlInfo.getShortenKey());
        redirectAttributes.addAttribute("shortenUrl", "http://localhost:8080/" + urlInfo.getShortenKey());
        redirectAttributes.addAttribute("originalUrl", urlInfo.getOriginalURL());
        return "redirect:/";
    }

}
