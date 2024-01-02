package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    // Optional이란? Null이 반환됐을 때 Null을 처리하는 방법 중 Null을 그대로 반환하기 보다 요즘은 Optional로 감싸서 반환하는 것이 선호된다.
    List<Member> findAll();

    // 구현체 : MemoryMemeberRepository
}
