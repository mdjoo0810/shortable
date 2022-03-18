package me.mdjoo0810.shortable.url.web;

import me.mdjoo0810.shortable.url.web.dto.ShortenURLRequestDTO;
import me.mdjoo0810.shortable.url.web.dto.ShortenURLRequestDTOFixture;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import static org.junit.jupiter.api.Assertions.*;

class UrlControllerTest {

    @Test
    void make_shorten_url() {
        UrlController controller = new UrlController();
        ShortenURLRequestDTO dto = ShortenURLRequestDTOFixture.get();
        RedirectAttributes redirectAttributes = new RedirectAttributesModelMap();
        String redirect = controller.makeShortenUrl(dto, redirectAttributes);
        assertEquals("redirect:/", redirect);
    }

}