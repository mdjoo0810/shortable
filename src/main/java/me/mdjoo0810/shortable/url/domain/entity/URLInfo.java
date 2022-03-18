package me.mdjoo0810.shortable.url.domain.entity;

import lombok.Getter;

@Getter
public class URLInfo {
    private final String shortenKey;
    private final String originalURL;

    public URLInfo(String shortenKey, String originalURL) {
        this.shortenKey = shortenKey;
        this.originalURL = originalURL;
    }
}
