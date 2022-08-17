package com.codestates.soloPr.Member.Repository;

import com.codestates.soloPr.Member.Entity.Member;
import com.codestates.soloPr.Member.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member,Long> {


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO MEMBER (NAME,PASSWORD,SEX,COMPANY_NAME,COMPANY_TYPE,COMPANY_LOCATION) VALUES ('김코딩','s4goodbye!','m','프로젝트스테이츠',005,001) ;", nativeQuery = true)
    public void addDummy();
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO MEMBER (NAME,PASSWORD,SEX,COMPANY_NAME,COMPANY_TYPE,COMPANY_LOCATION) VALUES ('김코딩2','s4goodbye!','m','프로젝트스테이츠',005,001) ;", nativeQuery = true)
    public void addDummy2();

   // @Query(value = MemberService.query,nativeQuery = true)  // (2-3)
    //List<Member> findMembers();

    default List<Member> test(EntityManager em , String query,int size,int page){
        return em.createNativeQuery(query,Member.class).setFirstResult(page*size).setMaxResults(size).getResultList();
    }





}
