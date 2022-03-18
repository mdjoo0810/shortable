package me.mdjoo0810.shortable.url.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.mdjoo0810.shortable.url.web.dto.ShortenURLRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/url")
public class UrlController {

    @PostMapping
    public String makeShortenUrl(
            @ModelAttribute ShortenURLRequestDTO dto,
            RedirectAttributes redirectAttributes
            ) {

        log.info("request url : {}", dto.getOriginalUrl());

        redirectAttributes.addAttribute("shortenUrl", dto.getOriginalUrl());
        redirectAttributes.addAttribute("originalUrl", dto.getOriginalUrl());
        return "redirect:/";
    }

}
