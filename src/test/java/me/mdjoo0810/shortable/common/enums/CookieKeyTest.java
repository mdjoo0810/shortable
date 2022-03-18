package me.mdjoo0810.shortable.common.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CookieKeyTest {

    @Test
    void use_cookie_key() {
        assertEquals("LOGIN_USER", CookieKey.LOGIN_USER.getValue());
    }

}