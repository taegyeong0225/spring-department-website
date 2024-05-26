package kr.co.inhatcspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.inhatcspring.beans.BoardDataBean;

@Controller
@RequestMapping("/department-info")
public class DepartmentInfoController {
	
    private BoardDataBean boardDataBean; // BoardDataBean 객체 주입
    
    /***************************
    		   학과 안내
     ***************************/
	
    // Main : drop-down 학과안내 -> 학과소개 (학과소개 페이지로 이동)
    @GetMapping("/about-department")
	public String aboutDepartment(Model model) {
    	model.addAttribute("category", "about-department");
		return "departmentInfo/aboutDepartment"; // 학과소개 뷰 반환
	}
    
    /***************************
    		   학과 연혁
     ***************************/    
    
    // Main : drop-down 학과안내 -> 학과연혁 (학과연혁 페이지로 이동)
    @GetMapping("/department-history")
	public String departmentHistory(Model model) {
    	model.addAttribute("category", "department-history");
		return "departmentInfo/departmentHistory"; // 학과연혁 뷰 반환
	}
    
    /***************************
	   		 글 작성 페이지
     ***************************/ 
    // 글 작성 click -> formPost (글 작성 페이지로 이동)
    @GetMapping("/formPost")
    public String FormPost(@RequestParam("category") String category, Model model) {
        model.addAttribute("category", category); // URL에서 category 파라미터 받아서 모델에 추가
        return "etc/formPost"; // formPost 뷰 반환
    }
}
