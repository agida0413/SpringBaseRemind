package com.sist.repository;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.sist.dto.BoardDTO;

import lombok.RequiredArgsConstructor;
@Repository
@RequiredArgsConstructor
public class MyBatisBoardRepository  implements BoardRepository{

	private final BoardMapper boardMapper;
	
	
	@Override
	public List<BoardDTO> boardList(int start) {
		// TODO Auto-generated method stub
		return boardMapper.boardList(start);
	}


	@Override
	public int boardTotalPage() {
		// TODO Auto-generated method stub
		return boardMapper.boardTotalPage();
	}


	@Override
	public BoardDTO boardDetail(int no) {
		// TODO Auto-generated method stub
		return boardMapper.boardDetail(no);
	}


	@Override
	public void boardInsert(BoardDTO dto) {
		// TODO Auto-generated method stub
		boardMapper.boardInsert(dto);
	}


	@Override
	public String pwdCheck(int no) {
		// TODO Auto-generated method stub
		return boardMapper.pwdCheck(no);
	}


	@Override
	public void boardDelete(int no) {
		// TODO Auto-generated method stub
		boardMapper.boardDelete(no);
	}

}
