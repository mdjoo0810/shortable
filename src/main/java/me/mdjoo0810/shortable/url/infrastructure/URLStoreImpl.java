package me.mdjoo0810.shortable.url.infrastructure;

import lombok.RequiredArgsConstructor;
import me.mdjoo0810.shortable.url.domain.entity.URL;
import me.mdjoo0810.shortable.url.domain.entity.URLStore;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class URLStoreImpl implements URLStore {

    private final URLJpaRepository urlJpaRepository;

    @Override
    public URL store(URL initStore) {
        return urlJpaRepository.save(initStore);
    }
}
