package kr.co.inhatcspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.inhatcspring.beans.BoardDataBean;
import kr.co.inhatcspring.mapper.MapperInterface;

@Controller
public class DepartmentInfoController {
    
    @Autowired
    private MapperInterface mapper;
    
	/***************************
	 
	  	   학과 안내 컨트롤러 
	  		  
	 ***************************/   
	
	// Main : drop-down 학과안내 -> 학과소개 (학과소개 페이지로 이동)
	@GetMapping("/about-department")
	public String aboutDepartment(@RequestParam(value = "category", required = false, defaultValue = "about-department") String category, Model model) {
		List<BoardDataBean> boardList = mapper.getBoardList(category);
		model.addAttribute("boardList", boardList);
		model.addAttribute("category", category);
		return "post/viewList"; // 학과소개 뷰 반환
	}
	
	// Main : drop-down 학과안내 -> 학과연혁 (학과연혁 페이지로 이동)
	@GetMapping("/department-history")
	public String departmentHistory(@RequestParam(value = "category", required = false, defaultValue = "department-history") String category, Model model) {
		List<BoardDataBean> boardList = mapper.getBoardList(category);
		model.addAttribute("boardList", boardList);
		model.addAttribute("category", category);
		return "post/viewList"; // 학과연혁 뷰 반환
	}
}
