package com.sist.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sist.dto.BoardDTO;

@Mapper
public interface BoardMapper {

	public List<BoardDTO> boardList(int start);
	public int boardTotalPage();
	public BoardDTO boardDetail(int no);
	public void boardInsert(BoardDTO dto);
	public String pwdCheck(int no);
	public void boardDelete(int no);
}
