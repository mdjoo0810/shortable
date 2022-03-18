package me.mdjoo0810.shortable.url.web.dto;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

class ShortenURLRequestDTOTest {

    @Test
    void get_original_url() {
        String url = "https://google.com";
        ShortenURLRequestDTO dto = new ShortenURLRequestDTO();
        ReflectionTestUtils.setField(dto, "originalUrl", url);
        assertEquals(url, dto.getOriginalUrl());
    }

    @Test
    void all_con() {
        String url = "https://google.com";
        ShortenURLRequestDTO dto = new ShortenURLRequestDTO(url);
        assertEquals(url, dto.getOriginalUrl());
    }

}