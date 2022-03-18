package me.mdjoo0810.shortable.url.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class URLInfoTest {

    @Test
    void create_info() {
        URLInfo urlInfo = URLInfoFixture.get();
        assertEquals( "TEST1234" ,urlInfo.getShortenKey());
    }

}