package me.mdjoo0810.shortable.member.infrastructure;

import me.mdjoo0810.shortable.common.CommonFixture;
import me.mdjoo0810.shortable.member.domain.entity.Member;
import me.mdjoo0810.shortable.member.domain.entity.MemberFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MemberReaderImplTest {
    String email = "anonymous@" + CommonFixture.getDomainURL();
    MemberJpaRepository mockRepository;
    MemberReaderImpl memberReader;
    @BeforeEach
    void init () {
        mockRepository = mock(MemberJpaRepository.class);
        memberReader = new MemberReaderImpl(mockRepository);

    }

    @Test
    void find_by_email_test() {

        when(mockRepository.findByEmail(email))
                .thenReturn(Optional.of(MemberFixture.get()));

        Optional<Member> byEmail = memberReader.findByEmail(email);
        assertTrue(byEmail.isPresent());

        Member member = byEmail.get();
        assertEquals(email, member.getEmail());
    }

    @Test
    void exist_by_email_true() {
        when(mockRepository.existsByEmail(email))
                .thenReturn(true);

        boolean exist = memberReader.existByEmail(email);
        assertTrue(exist);
    }

    @Test
    void exist_by_email_false() {
        when(mockRepository.existsByEmail(email))
                .thenReturn(true);

        boolean exist = memberReader.existByEmail("test@test.com");
        assertFalse(exist);
    }

}