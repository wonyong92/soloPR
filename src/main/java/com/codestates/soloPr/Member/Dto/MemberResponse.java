package com.codestates.soloPr.Member.Dto;

import com.codestates.soloPr.Member.Entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MemberResponse {
    private List<Member> members;
    private Pageable pageInfo ;
    public MemberResponse(List<Member> Members,Pageable pageInfo)
    {
        this.members=Members;
        this.pageInfo=pageInfo;
    }


}
