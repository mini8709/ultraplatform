package com.tmax.ultraplatform.repository;

import com.tmax.ultraplatform.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    /*
     * 등록
     */
    public void join(Member member){

        em.persist(member);

    }

    /*
     * 사용자 1명 검색
     */
    public Member findOne(Long id){

        return em.find(Member.class, id);

    }

    /*
     * 모든 사용자 검색
     */
    public List<Member> findAll(){

        return em.createQuery("select m from Member m", Member.class).getResultList();

    }

    /*
     * 사용자 이름으로 검색 (회원 가입 시 중복 검사 필요)
     */
    public List<Member> findByName(String name){

        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name).getResultList();
    }

}
