package itc.hoseo.pos.repository;

import itc.hoseo.pos.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    /**
     * ID로 맴버를 찾음
     * @param id
     * @return
     */
    public Optional<Member> findById(String id);

    /**
     * 이름으로 맴버를 찾음(중복될수 있으니 리스트를 반환)
     * @param name
     * @return
     */
    public List<Member> findByName(String name);

    /**
     * 맴버를 저장
     * @param member
     */
    public void save(Member member);

    /**
     * 모든 회원을 반환
     * @return
     */
    public List<Member> allMembers();
}
