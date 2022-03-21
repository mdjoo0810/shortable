package me.mdjoo0810.shortable.url.domain.usecase;

import lombok.RequiredArgsConstructor;
import me.mdjoo0810.shortable.member.domain.entity.Member;
import me.mdjoo0810.shortable.member.domain.entity.MemberReader;
import me.mdjoo0810.shortable.url.domain.entity.URL;
import me.mdjoo0810.shortable.url.domain.entity.URLInfo;
import me.mdjoo0810.shortable.url.domain.entity.URLReader;
import me.mdjoo0810.shortable.url.domain.entity.URLStore;
import me.mdjoo0810.shortable.utils.KeyManager;
import me.mdjoo0810.shortable.utils.MDEncoder;
import me.mdjoo0810.shortable.utils.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class URLManager implements URLs{

    private final StringUtils stringUtils;
    private final KeyManager keyManager;

    private final URLStore urlStore;
    private final URLReader urlReader;
    private final MemberReader memberReader;

    @Override
    @Transactional
    public URLInfo makeShorten(String email, String originalUrl) {
        String hashKey = keyManager.generate(originalUrl);
        String shortenKey = getShortenKey(hashKey);

        // TODO: 중복 체크 필요 or KGS 개발
        Member member = memberReader.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("NO MEMBER : " + email));
        URL initURL = new URL(hashKey, originalUrl, member, ZonedDateTime.now().plusDays(7));
        urlStore.store(initURL);

        return new URLInfo(shortenKey, originalUrl);
    }

    @Override
    @Transactional
    public URLInfo getURLInfo(String code) {
        String decodeStr = stringUtils.decodeUrlBase64(code);
        URL url = urlReader.getByCodeLike(decodeStr + "%").orElseThrow(() -> new IllegalArgumentException("NO URL ROW : " + code + " decoded : " + decodeStr));
        url.redirect();
        String shortenKey = getShortenKey(url.getHash());
        return new URLInfo(shortenKey, url.getOriginalURL());
    }

    private String getShortenKey(String hash) {
        String encodedStr = stringUtils.encodeUrlBase64(hash);
        return keyManager.convertShortKey(encodedStr);
    }
}
