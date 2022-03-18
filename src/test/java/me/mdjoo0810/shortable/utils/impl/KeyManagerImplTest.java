package me.mdjoo0810.shortable.utils.impl;

import me.mdjoo0810.shortable.utils.KeyManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeyManagerImplTest {

    String code;
    KeyManager manager;

    @BeforeEach
    void init() {
        String url = "https://aws.amazon.com/ko/";
        manager = new KeyManagerImpl();
        code = manager.generate(url);
    }

    @Test
    void generate_valid_in_valid_out() {
        assertEquals(64, code.length());
    }

    @Test
    void convert_valid_in_valid_out() {
        String key = manager.convertShortKey(code);
        assertEquals(8, key.length());
    }

}