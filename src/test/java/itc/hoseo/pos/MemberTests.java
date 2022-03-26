package itc.hoseo.pos;


import itc.hoseo.pos.domain.Member;
import itc.hoseo.pos.repository.MemberRepository;
import itc.hoseo.pos.repository.impl.FileMemberRepository;
import itc.hoseo.pos.repository.impl.HashMapMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MemberTests {

    @Autowired
    MemberRepository repository;

    @Test
    void test_김봉남() {
        //Builder
        Member m2 = Member.builder()
                .name("김봉남")
                .build();

        assertEquals("김봉남",m2.getName());
        assertEquals(null, m2.getAge());
    }

    @Test
    void test_마봉필() {
        //AllArgCon
////        Member m1 = new Member(1,"마봉필","1",30);
//
//        assertEquals("마봉필",m1.getName());
//        assertEquals(30, m1.getAge());
    }


    @Test
    void testMemberRepository() {
        repository.save(new Member(1,"a","a","a",1));
        repository.save(new Member(2,"b","b","b",2));
        repository.save(new Member(3,"a","a","a",1));

        assertEquals(3, repository.allMembers().size());
        assertEquals(2,repository.findByName("a").size());

    }

}
