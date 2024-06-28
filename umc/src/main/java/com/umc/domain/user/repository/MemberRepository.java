package com.umc.domain.user.repository;

import com.umc.domain.user.entity.Member;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

    boolean existsByEmail(String email);
    Member findByNickname(String nickname);

}
