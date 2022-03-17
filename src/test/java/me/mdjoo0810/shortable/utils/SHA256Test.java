package me.mdjoo0810.shortable.utils;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class SHA256Test {

    @Test
    void encode_test() throws NoSuchAlgorithmException {
        SHA256 sha256 = new SHA256();
        String encodedText = sha256.encrypt("asdfasdfasdfasdfasdfasdf");
        assertEquals(64, encodedText.length());
        // 256 = 64 4
    }

}