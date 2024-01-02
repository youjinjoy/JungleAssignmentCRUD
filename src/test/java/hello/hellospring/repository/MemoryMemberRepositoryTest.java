package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat; // Assertions에서 alt + enter로 추가해준 것

class MemoryMemberRepositoryTest { // 관습: 테스트 파일명 앞부분 Memory 붙임 & public 클래스 아니여도 됨.
    MemoryMemberRepository repository = new MemoryMemberRepository(); // MemoryMemberRepository 하나에 대해서만 테스트 할 것이므로, 인터페이스(MemberRepository)에서 변경함.
    @AfterEach
    public void afterEach() {
        // 테스트 끝날 때마다 repository 깔끔하게 지워주는 코드 추가해야 함 (안그러면 서로 다른 테스트 간에 영향 미침)
        // MemoryMemberRepository 클래스에 clearStore() 추가함.
        repository.clearStore();
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // System.out.println("result = " + (result == member)); 아래와 같은 것인데 아래를 쓰는 게 좋다.
        // Assertions.assertEquals(result, member); 아래와 같은 것인데 아래를 쓰는 게 좋다.
        // Assertions.assertThat(member).isEqualTo(result); Assertions에서 alt + enter 쳐서 import 해주면 assertThat 부터만 치면 돼서 편리
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("JJ");
        repository.save(member1);

        Member member2 = new Member(); // shift + f6 하면 한번에 이름 바꿀 수 있음
        member2.setName("YY");
        repository.save(member2);

        Member result = repository.findByName("JJ").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        Member member2 = new Member();
        Member member3 = new Member();
        Member member4 = new Member();

        member1.setName("AA");
        member2.setName("BB");
        member3.setName("CC");
        member4.setName("DD");

        repository.save(member1);
        repository.save(member2);
        repository.save(member3);
        repository.save(member4);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(4);
    }
}
