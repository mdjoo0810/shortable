package me.mdjoo0810.shortable.config;

import me.mdjoo0810.shortable.utils.KeyManager;
import me.mdjoo0810.shortable.utils.MDEncoder;
import me.mdjoo0810.shortable.utils.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonBeanTest {

    @Test
    void apply_string_utils_bean() {
        CommonBean commonBean = new CommonBean();
        StringUtils stringUtils = commonBean.stringUtils();
        assertNotNull(stringUtils);
    }

    @Test
    void apply_MD_encoder_bean() {
        CommonBean commonBean = new CommonBean();
        MDEncoder mdEncoder = commonBean.mdEncoder();
        assertNotNull(mdEncoder);
    }

    @Test
    void apply_key_manager_bean() {
        CommonBean commonBean = new CommonBean();
        KeyManager keyManager = commonBean.keyManager();
        assertNotNull(keyManager);
    }


}