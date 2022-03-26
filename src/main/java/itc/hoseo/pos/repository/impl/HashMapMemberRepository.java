package itc.hoseo.pos.repository.impl;

import itc.hoseo.pos.domain.Member;
import itc.hoseo.pos.repository.MemberRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@Profile("hashmap")
public class HashMapMemberRepository implements MemberRepository {

//    private final static HashMapMemberRepository instance = new HashMapMemberRepository();
//    public static HashMapMemberRepository getInstance(){
//        return instance;
//    }

    private Map<Integer, Member> map = new HashMap<>();

    @Override
    public Optional<Member> findById(String id) {
        return Optional.of(map.get(id));
    }

    @Override
    public List<Member> findByName(String name) {
        //1. 결과로 돌려줄 반환 리스트 하나 생성
        List<Member> list = new ArrayList<>();
        //2. 맵 전체에서  K,V 모든 맴버를 가져옴
        for(Member m : map.values()){
            //이름이 넘어온 파라미터와 일치하면? 리스트에추가
            if(name.equals(m.getName())){
                list.add(m);
            }
        }
        //리스트 반환
        return list;
        //JAVA8 람다식, 스트림 API
//        return map.values().stream()
//                .filter(i -> {
//                    return name.equals(i.getName()) ;
//                })
//                .collect(Collectors.toList());
    }

    @Override
    public void save(Member member) {
        System.out.printf("HASHMAP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        map.put(member.getSeq(),member);
    }

    @Override
    public List<Member> allMembers() {
        return map.values()
                .stream()
                .collect(Collectors.toList());
    }
}
