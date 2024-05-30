package kr.co.inhatcspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.inhatcspring.beans.BoardDataBean;
import kr.co.inhatcspring.mapper.MapperInterface;

@Controller
public class DirectionsController {
	
    @Autowired
    MapperInterface mapper; // 데이터베이스 작업을 위한 MyBatis 매퍼 인터페이스 자동 주입
    
	/***************************
			오시는 길
	 ***************************/

	// Main : 오시는 길 -> 오시는 길 (오시는 길 페이지로 이동)
	@GetMapping("/directions")
	public String directions(@RequestParam(value = "category", required = false, defaultValue = "directions") String category, Model model) {
		List<BoardDataBean> boardList = mapper.getBoardList(category);
		model.addAttribute("boardList", boardList);
		model.addAttribute("category", category);
		return "post/viewList";
	}

}
