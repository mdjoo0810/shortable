package me.mdjoo0810.shortable.url.domain.entity;

import me.mdjoo0810.shortable.member.domain.entity.MemberFixture;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.ZonedDateTime;

public class URLFixture {

    public static URL get(String hash) {
        URL url = new URL();
        ReflectionTestUtils.setField(url, "hash", hash);
        ReflectionTestUtils.setField(url, "originalURL", "https://google.com");
        ReflectionTestUtils.setField(url, "redirectCount", 0);
        ReflectionTestUtils.setField(url, "createdAt", ZonedDateTime.now());
        ReflectionTestUtils.setField(url, "expirationAt", ZonedDateTime.now().plusDays(7));
        ReflectionTestUtils.setField(url, "member", MemberFixture.get());
        return url;
    }

}
