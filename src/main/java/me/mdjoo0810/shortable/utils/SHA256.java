package me.mdjoo0810.shortable.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {

    public String encrypt(String text) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(text.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(messageDigest.digest());
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for(byte data: bytes) {
            builder.append(String.format("%02x", data));
        }
        return builder.toString();
    }

}
