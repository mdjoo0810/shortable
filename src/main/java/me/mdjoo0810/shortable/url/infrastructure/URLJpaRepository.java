package me.mdjoo0810.shortable.url.infrastructure;

import me.mdjoo0810.shortable.url.domain.entity.URL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URLJpaRepository extends JpaRepository<URL, String> {



}
