package me.mdjoo0810.shortable.member.infrastructure;

import me.mdjoo0810.shortable.member.domain.entity.Member;
import me.mdjoo0810.shortable.member.domain.entity.MemberFixture;
import me.mdjoo0810.shortable.member.domain.entity.MemberStore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MemberStoreImplTest {

    @Test
    void store_test() {
        Member initMember = MemberFixture.get();
        MemberJpaRepository mockRepository = mock(MemberJpaRepository.class);
        MemberStoreImpl memberStore = new MemberStoreImpl(mockRepository);

        when(mockRepository.save(initMember)).thenReturn(initMember);
        Member store = memberStore.store(initMember);

        assertEquals(initMember.getId(), store.getId());
        assertEquals(initMember.getName(), store.getName());
        assertEquals(initMember.getEmail(), store.getEmail());
        assertEquals(initMember.getCreatedAt(), store.getCreatedAt());
    }


}