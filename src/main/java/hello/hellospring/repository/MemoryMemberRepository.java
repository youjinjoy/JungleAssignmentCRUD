package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    // 메모리에 저장
    private static Map<Long, Member> store = new HashMap<>(); // 실전에서는 concurrency 고려해주어야 함.
    private static long sequence = 0L; // 실전에서는 concurrency 고려해주어야 함.
    // 키 값으로 쓸 예정

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // null을 반환할 가능성이 있는 경우 Optional로 감싸준다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}