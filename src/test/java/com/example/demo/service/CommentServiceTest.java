package com.example.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.CommentDTO;

@SpringBootTest
public class CommentServiceTest {

	@Autowired
	CommentService service;
	
	@Test
	public void 댓글등록() {
		
		// 테이블에 있는 게시물 번호와 유저 아이디 필요함
		CommentDTO dto = CommentDTO.builder()
								.boardNo(1)
								.content("세번째 댓글입니다.")
								.writer("user1")
								.build();
		
		int no = service.register(dto);
	}
	
	@Test
	public void 게시물별_댓글목록조회() {
		
		List<CommentDTO> list = service.getListByBoardNo(1);
		
		for (CommentDTO dto : list) {
			System.out.println(dto);
		}
		
	}
	
	@Test
	public void 댓글삭제() {
		
		service.remove(5);
		
	}
}












