package me.mdjoo0810.shortable.utils.impl;

import lombok.extern.slf4j.Slf4j;
import me.mdjoo0810.shortable.common.enums.Algorithm;
import me.mdjoo0810.shortable.utils.KeyManager;
import me.mdjoo0810.shortable.utils.MDEncoder;

@Slf4j
public class KeyManagerImpl implements KeyManager {
    @Override
    public String generate(String str) {
        MDEncoder MDEncoder = new MDEncoder();
        return MDEncoder.encrypt(str, Algorithm.SHA_256.getName());
    }

    @Override
    public String convertShortKey(String originalKey) {
        if (originalKey.length() != 64) throw new IllegalArgumentException("Not valid Key");
        return originalKey.substring(0, 6);
    }

}
