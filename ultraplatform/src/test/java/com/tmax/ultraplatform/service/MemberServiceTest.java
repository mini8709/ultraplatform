package com.tmax.ultraplatform.service;

import com.tmax.ultraplatform.domain.Address;
import com.tmax.ultraplatform.domain.Member;
import com.tmax.ultraplatform.domain.MemberType;
import com.tmax.ultraplatform.exception.NotEnoughMoneyException;
import com.tmax.ultraplatform.repository.MemberRepository;
import com.tmax.ultraplatform.service.commandservice.MemberCommandService;
import com.tmax.ultraplatform.service.queryservice.MemberQueryService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberCommandService memberCommandService;
    @Autowired
    MemberQueryService memberQueryService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception{

        Member member = new Member();
        Address address = new Address();
        address.setCity("서울");
        address.setStreet("마포구");
        address.setZipcode("123-12");

        member.setMembers("test1234", "12341234", "Kim", address, MemberType.BUYER, 0);

        memberCommandService.register(member);


        Member findMember = memberRepository.findOne(member.getId());
        assertEquals(member, findMember);
    }

    @Test
    public void 중복회원가입() throws Exception{

        Member member1 = new Member();
        Address address = new Address();

        address.setCity("서울");
        address.setStreet("마포구");
        address.setZipcode("123-12");

        member1.setMembers("test1234", "12341234", "Kim", address, MemberType.BUYER, 0);

        memberCommandService.register(member1);

        assertThrows(IllegalStateException.class, () -> {
            Member member2 = new Member();
            member2.setMembers("test1234", "12341234", "Kim", address, MemberType.BUYER, 0);
            memberCommandService.register(member2);
        });
    }

    @Test
    public void 금액차감() throws Exception{

        Member member1 = new Member();
        Address address = new Address();

        address.setCity("서울");
        address.setStreet("마포구");
        address.setZipcode("123-12");

        member1.setMembers("test1234", "12341234", "Kim", address, MemberType.BUYER, 0);

        memberCommandService.register(member1);

        memberCommandService.chargeMoney(member1.getId(), 10000);

        assertEquals(memberQueryService.findMoney(member1.getId()), 10000);

        memberCommandService.removeMoney(member1.getId(), 10000);

        assertEquals(memberQueryService.findMoney(member1.getId()), 0);

        assertThrows(NotEnoughMoneyException.class, () -> {
            memberCommandService.removeMoney(member1.getId(), 10000);
        });

    }
}