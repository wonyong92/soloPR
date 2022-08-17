package com.codestates.soloPr.Member.Entity;

import lombok.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "MemberBuilder")
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public static MemberBuilder builder(String name) {
        if(name==null || name.length()==0) {
            throw new IllegalArgumentException("필수 파라미터 누락");
        }
        return MemberBuilder().name(name);
    }

    private String name;
    private String password;
    private String sex;
    private String company_name;
    private long company_type;
    private long company_location;
}
