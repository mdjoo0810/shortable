package me.mdjoo0810.shortable.config;

import me.mdjoo0810.shortable.utils.KeyManager;
import me.mdjoo0810.shortable.utils.MDEncoder;
import me.mdjoo0810.shortable.utils.StringUtils;
import me.mdjoo0810.shortable.utils.impl.KeyManagerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonBean {

    @Bean
    public StringUtils stringUtils() {
        return new StringUtils();
    }

    @Bean
    public KeyManager keyManager() {
        return new KeyManagerImpl();
    }

    @Bean
    public MDEncoder mdEncoder() {
        return new MDEncoder();
    }

}
