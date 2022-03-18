package me.mdjoo0810.shortable.url.web.dto;

import org.springframework.test.util.ReflectionTestUtils;

public class ShortenURLRequestDTOFixture {

    public static ShortenURLRequestDTO get() {
        String url = "https://google.com";
        ShortenURLRequestDTO dto = new ShortenURLRequestDTO();
        ReflectionTestUtils.setField(dto, "originalUrl", url);
        return dto;
    }

}
