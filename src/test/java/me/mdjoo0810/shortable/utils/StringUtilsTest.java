package me.mdjoo0810.shortable.utils;

import me.mdjoo0810.shortable.utils.impl.KeyManagerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    StringUtils stringUtils;

    @BeforeEach
    void init() {
        stringUtils = new StringUtils();
    }

    @Test
    void encode_test() {
        String url = "https://naver.com/1234/1234";
        KeyManager keyManager = new KeyManagerImpl();
        String hash = keyManager.generate(url);
        String encode = stringUtils.encodeUrlBase64(hash);
        assertNotEquals(hash, encode);
    }

    @Test
    void decode_test() {
        String url = "https://naver.com/1234/1234";
        KeyManager keyManager = new KeyManagerImpl();
        String hash = keyManager.generate(url);
        String encode = stringUtils.encodeUrlBase64(hash);
        assertEquals(hash, stringUtils.decodeUrlBase64(encode));
    }

}