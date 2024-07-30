package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.dto.BoardDTO;

public interface BoardService {

	public Map<String,Object> boardAllList(int page);//현재페이지, 총페이지 , list, startPage,endPage
	public String insertBoard(BoardDTO dto);
	public BoardDTO boardDetail(int no);
	public String boardInsert(BoardDTO dto);
	public String boardUpdate(BoardDTO dto);
	public String BoardDelete(BoardDTO dto);
	
	
	
}
