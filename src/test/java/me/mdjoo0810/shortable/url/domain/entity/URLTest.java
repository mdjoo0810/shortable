package me.mdjoo0810.shortable.url.domain.entity;

import me.mdjoo0810.shortable.member.domain.entity.Member;
import me.mdjoo0810.shortable.utils.KeyManager;
import me.mdjoo0810.shortable.utils.StringUtils;
import me.mdjoo0810.shortable.utils.impl.KeyManagerImpl;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class URLTest {

    @Test
    void create_no_constructor() {
        URL url = new URL();
        assertNotNull(url);
    }

    @Test
    void create_builder() {
        StringUtils utils = new StringUtils();
        String randomString = utils.randomString(12);
        KeyManager keyManager = new KeyManagerImpl();

        String generate = keyManager.generate("https://google.com");

        URL url = URL.builder()
                .hash(generate)
                .originalURL("https://google.com")
                .member(Member.anonymous(randomString))
                .expirationAt(ZonedDateTime.now().plusDays(1))
                .build();

        assertNotNull(url.getHash());
        assertNotNull(url.getOriginalURL());
        assertNotNull(url.getMember());
        assertNotNull(url.getCreatedAt());
        assertNotNull(url.getExpirationAt());
    }

}