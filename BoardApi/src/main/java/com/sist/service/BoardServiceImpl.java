package com.sist.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sist.common.Pagination;
import com.sist.dto.BoardDTO;
import com.sist.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

	private final BoardRepository boardRepository;
	private final Pagination pagination;
	@Override
	public Map<String, Object> boardAllList(int page) {
		
		//Map 리턴값으로 리스트,startpage,endpage 전달 후 vue에서 페이징로직
		
				Map<String, Object> map = new HashMap<>();
		
		int start= pagination.start(10, page);
		System.out.println(start);
			List<BoardDTO> list = boardRepository.boardList(start);
				System.out.println(list.size());
		int count = boardRepository.boardTotalPage();
		int totalPage=pagination.totalPage(count);
		int startPage=pagination.startPage(page, 10);
		int endPage= pagination.endPage(page, 10, totalPage);
		
		map.put("boardList", list);
		map.put("start", start);
		map.put("startPage",startPage);
		map.put("endPage", endPage);
		map.put("totalPage", totalPage);
	
		
			
			
			return map;
	}

	@Override
	public String insertBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		String result="";
		
		try {
			boardRepository.boardInsert(dto);
			result="OK";
		} catch (Exception e) {
			// TODO: handle exception
			result="ERROR";
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

	@Override
	public BoardDTO boardDetail(int no) {
		// TODO Auto-generated method stub
		return boardRepository.boardDetail(no);
	}

	@Override
	public String boardUpdate(BoardDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String BoardDelete(BoardDTO dto) {// 컨트롤러에서 파람 변수명과 , VUE 파람 변수명 일치 = > 자동매핑
		String findPwd= boardRepository.pwdCheck(dto.getNo()); //VUe에서 받은 게시판 번호의 패스워드 탐색
		
		
		String result="";//리턴값 
		if(dto.getPwd().equals(findPwd)) {//만약 vue에서 입력한 패스워드와 탐색한 패스워드가 같다면 
			boardRepository.boardDelete(dto.getNo());//해당 번호 게시판 삭제 
		result="OK";//Json 결과값 
		}else {
			result="CANCEL";//Json 결과값 
		}

		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public String boardInsert(BoardDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
