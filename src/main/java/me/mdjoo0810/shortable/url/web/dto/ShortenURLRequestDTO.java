package me.mdjoo0810.shortable.url.web.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShortenURLRequestDTO {

    private String originalUrl;

    public ShortenURLRequestDTO(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
