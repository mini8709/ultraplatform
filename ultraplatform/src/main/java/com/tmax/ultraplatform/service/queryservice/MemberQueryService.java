package com.tmax.ultraplatform.service.queryservice;

import com.tmax.ultraplatform.domain.Member;
import com.tmax.ultraplatform.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberQueryService {

    private final MemberRepository memberRepository;

    /*
     * 회원의 보유 금액 조회
     */
    public int findMoney(Long id){

        Member findMember = memberRepository.findOne(id);

        return findMember.getMoney();
    }
}
