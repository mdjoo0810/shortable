package me.mdjoo0810.shortable.url.application;

import lombok.RequiredArgsConstructor;
import me.mdjoo0810.shortable.url.domain.entity.URLInfo;
import me.mdjoo0810.shortable.url.domain.usecase.URLs;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class URLFacade {

    private final URLs urLs;

    public URLInfo makeShortenURL(String email, String originalURL) {
        return urLs.makeShorten(email, originalURL);
    }

    public String getOriginalURL(String code) {
        URLInfo urlInfo = urLs.getURLInfo(code);
        return urlInfo.getOriginalURL();
    }

}
