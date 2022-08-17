package com.codestates.soloPr.Member.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@Setter
@Getter
public class TestDto {
    private int page ;
    private int size ;



}
