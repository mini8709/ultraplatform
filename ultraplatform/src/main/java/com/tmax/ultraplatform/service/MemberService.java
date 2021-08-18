package com.tmax.ultraplatform.service;

import com.tmax.ultraplatform.domain.Member;
import com.tmax.ultraplatform.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /*
     * 회원 가입
     */
    @Transactional
    public Long register(Member member){

        Boolean isDuplicate = findDuplicateMember(member);

        if(isDuplicate){

            throw new IllegalStateException("중복되는 회원 ID 입니다.");

        }

        memberRepository.join(member);

        return member.getId();
    }

    /*
     * 회원의 보유 금액 조회
     */
    public int findMoney(Long id){

        Member findMember = memberRepository.findOne(id);

        return findMember.getMoney();
    }

    /*
     * 회원의 보유 금액 충전
     */
    @Transactional
    public void chargeMoney(Long id, int money){

        Member findMember = memberRepository.findOne(id);

        findMember.addMoney(money);
    }

    /*
     * 회원의 보유 금액 차감
     */
    @Transactional
    public void removeMoney(Long id, int money){

        Member findMember = memberRepository.findOne(id);

        findMember.minusMoney(money);
    }

    private Boolean findDuplicateMember(Member member) {

        List<Member> findMember = memberRepository.findByName(member.getName());

        if(findMember.isEmpty()){

            return false;

        } else{

            return true;
        }
    }
}
