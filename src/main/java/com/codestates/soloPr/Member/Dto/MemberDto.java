package com.codestates.soloPr.Member.Dto;

public class MemberDto {
    public class Get{
        private String name;

        private String email;

        private String company_name;

        public String getEmail() {
            return email;
        }

        public String getName() {
            return name;
        }

        public String getCompany_name() {
            return company_name;
        }
    }
}
