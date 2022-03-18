package me.mdjoo0810.shortable.url.infrastructure;

import me.mdjoo0810.shortable.url.domain.entity.URL;
import me.mdjoo0810.shortable.url.domain.entity.URLFixture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class URLStoreImplTest {

    @Test
    void store() {
        URLJpaRepository mockRepository = mock(URLJpaRepository.class);
        URLStoreImpl store = new URLStoreImpl(mockRepository);
        when(mockRepository.save(any())).thenReturn(URLFixture.get("TEST1234"));
        URL url = store.store(URLFixture.get("TEST1234"));
        assertNotNull(url.getHash());
        assertNotNull(url.getMember());
        assertNotNull(url.getCreatedAt());
        assertNotNull(url.getOriginalURL());
        assertNotNull(url.getExpirationAt());
    }

}