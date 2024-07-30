package com.sist.repository;

import java.util.List;

import com.sist.dto.BoardDTO;

public interface BoardRepository {
	public List<BoardDTO> boardList(int start);
	public int boardTotalPage();
	public BoardDTO boardDetail(int no);
	public void boardInsert(BoardDTO dto);
	public String pwdCheck(int no);
	public void boardDelete(int no);
	
	
}
