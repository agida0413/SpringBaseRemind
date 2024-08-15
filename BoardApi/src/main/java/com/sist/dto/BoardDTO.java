package com.sist.dto;

import java.sql.Date;

import lombok.Data;
@Data
public class BoardDTO {
private int no;
private String writer;
private String pwd;
private String content;
private Date date;
}
