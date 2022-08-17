package com.codestates.soloPr.Member.Controller;

import com.codestates.soloPr.Member.Dto.MemberResponse;
import com.codestates.soloPr.Member.Entity.Member;
import com.codestates.soloPr.Member.Mapper.MemberMapper;
import com.codestates.soloPr.Member.Service.MemberService;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class MemberController {
    private MemberService memberService;
    private MemberMapper memberMapper;

    public MemberController(MemberService memberService,
                            MemberMapper memberMapper

    ){
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @GetMapping("/")
    public ResponseEntity allMember(@RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
                                    @RequestParam(required = false, value = "size", defaultValue = "20") Integer size)
    {
        Page memberList =memberService.getMemberList(page,size);

        return new ResponseEntity<>(new MemberResponse(memberList.getContent(),memberList.getPageable()),HttpStatus.OK);

    }

    @GetMapping("/test")
    public ResponseEntity allMemberTest(@RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
                                    @RequestParam(required = false, value = "size", defaultValue = "20") Integer size)
    {


        return new ResponseEntity<>(memberService.test(page,size),HttpStatus.OK);

    }

    @GetMapping("/init")
    public ResponseEntity init(@RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
                                        @RequestParam(required = false, value = "size", defaultValue = "20") Integer size)
    {

        memberService.init();
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/find")
    public ResponseEntity findMember(@RequestParam(required = false, value = "id", defaultValue = "***") @NotNull String id,
                                     @RequestParam(required = false, value = "name", defaultValue = "***") String name,
                                     @RequestParam(required = false, value = "sex", defaultValue = "***") String sex,
                                     @RequestParam(required = false, value = "company_name", defaultValue = "***") String company_name,
                                     @RequestParam(required = false, value = "company_type", defaultValue = "***") String company_type,
                                     @RequestParam(required = false, value = "company_location", defaultValue = "***") String company_location,
                                     @RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
                                     @RequestParam(required = false, value = "size", defaultValue = "20") Integer size
                                     )
    {
        String query = "Select * From Member m ";
        boolean addWhere = false;

        if(!id.equals("***"))
        {
            if(query.indexOf("where")==-1)
                query += "where";
            query += " m.id = "+id+" ";

        }
        if(!name.equals("***"))
        {
            if(query.indexOf("where")==-1)
                query += " where ";
            else
                query += " and ";
            query += " m.name = \'"+name+"\' ";

        }
        if(!sex.equals("***"))
        {
            if(query.indexOf("where")==-1)
                query += " where ";
            else
                query += " and ";
            query += " m.sex = \'"+sex+"\' ";

        }
        if(!company_name.equals("***"))
        {
            if(query.indexOf("where")==-1)
                query += " where ";
            else
                query += " and ";
            query += " m.company_name = "+company_name+" ";

        }
        if(!company_type.equals("***"))
        {
            if(query.indexOf("where")==-1)
                query += " where ";
            else
                query += " and ";
            query += " m.company_type = "+company_type+" ";

        }
        if(!company_location.equals("***"))
        {
            if(query.indexOf("where")==-1)
                query += " where ";
            else
                query += " and ";
            query += " m.company_location = "+company_location+" ";

        }
        if(query.equals("Select * From Member "))
        {
            System.out.println("nothing checked");
            query = "Select * From Member";
        }



        System.out.println("==================\n\n"+query);
        List<Member> memberList = memberService.findMember(query,size,page);

        return new ResponseEntity<>(memberList,HttpStatus.OK);

    }
}
