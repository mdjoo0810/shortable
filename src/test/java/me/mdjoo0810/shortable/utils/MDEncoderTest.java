package me.mdjoo0810.shortable.utils;

import me.mdjoo0810.shortable.common.enums.Algorithm;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class MDEncoderTest {

    @Test
    void encode_test() throws NoSuchAlgorithmException {
        MDEncoder MDEncoder = new MDEncoder();
        String encodedText = MDEncoder.encrypt("asdfasdfasdfasdfasdfasdf", Algorithm.SHA_256.getName());
        assertEquals(64, encodedText.length());
        // 256 = 64 4
    }

    @Test
    void encoded_failed_by_no_such_algorithm() {
        MDEncoder MDEncoder = new MDEncoder();
        assertThrows(IllegalArgumentException.class, () -> {
            MDEncoder.encrypt("asdfasdfasdfasdfasdfasdf", "invalid_algorithm");
        });
    }

}