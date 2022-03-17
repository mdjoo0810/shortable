package me.mdjoo0810.shortable.utils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

public class StringUtils {

    public String encodeUrlBase64(String str) {
        return Base64.getUrlEncoder().withoutPadding().encodeToString(str.getBytes(StandardCharsets.UTF_8));
    }

    public String decodeUrlBase64(String str) {
        byte[] decode = Base64.getUrlDecoder().decode(str.getBytes(StandardCharsets.UTF_8));
        return new String(decode);
    }

    public String randomString(int length) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'

        Random random = new Random();

        return random.ints(leftLimit,rightLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

}
