package com.sist.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dto.BoardDTO;
import com.sist.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class BoardController {

	private final BoardService boardService;
	
	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	}
	@GetMapping("/board/list") //  /board/list"api 호출
	public Map<String,Object> boardList(int page){
	

		
		return boardService.boardAllList(page);
		
	}
	
	@GetMapping("/board/detail")
	public BoardDTO boardDetail(int no){


		
		return boardService.boardDetail(no);
		
	}
	
	@PostMapping("/board/insert")
	public String boardInsert(BoardDTO dto){


		
		return boardService.insertBoard(dto);
		
	}
	
	@PostMapping("/board/delete")
	public String boardDelete(BoardDTO dto) {
		return boardService.BoardDelete(dto);
	}
}
