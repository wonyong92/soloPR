package com.codestates.soloPr.Member.Service;

import com.codestates.soloPr.Member.Dto.TestDto;
import com.codestates.soloPr.Member.Entity.Member;
import com.codestates.soloPr.Member.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class MemberService  {
    public static String query="SELECT  *  FROM  Member  m  WHERE  m.id = 1l ";
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager entityManager;

    public Page<Member> getMemberList(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Member> MemberList = memberRepository.findAll(pageable);

        return MemberList;
    }

    public TestDto test(int page, int size)
    {
        return new TestDto(page,size);
    }

    public void init()
    {
        memberRepository.addDummy();memberRepository.addDummy2();
    }
    public List<Member> findMember(String query,int size,int page)
    {
        System.out.println("service : "+query);

        List<Member> memberList = memberRepository.test(entityManager,query,size,page);
        for(Member mm : memberList)
        {
            System.out.println(mm.getName());
        }
        return memberList;
    }

}
