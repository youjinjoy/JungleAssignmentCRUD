package hello.hellospring.domain;

public class Member {
    // 비즈니스 요구사항 : 회원 id와 이름
    private Long id; // 시스템이 정한 id를 의미. 유저가 정한 id 아님.
    private String name;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

}
