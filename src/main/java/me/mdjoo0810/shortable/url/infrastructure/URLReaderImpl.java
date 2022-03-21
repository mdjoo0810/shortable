package me.mdjoo0810.shortable.url.infrastructure;

import lombok.RequiredArgsConstructor;
import me.mdjoo0810.shortable.url.domain.entity.URL;
import me.mdjoo0810.shortable.url.domain.entity.URLReader;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class URLReaderImpl implements URLReader {

    private final URLJpaRepository urlJpaRepository;

    @Override
    public Optional<URL> getByCodeLike(String code) {
        return urlJpaRepository.findByHashLike(code);
    }
}
