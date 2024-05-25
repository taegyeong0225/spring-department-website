package kr.co.inhatcspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.inhatcspring.beans.BoardDataBean;

@Controller
public class DepartmentInfoController {
	
	private BoardDataBean boardDataBean;
	
	
    // DepartmentInformation (학과안내)
    @GetMapping("/about-department")
	public String aboutDepartment(Model model) {
    	model.addAttribute("category", "공지사항");
		return "departmentInfo/aboutDepartment";
	}
    
    @GetMapping("/department-history")
	public String departmentHistory(Model model) {
    	model.addAttribute("category", "공지사항");
		return "departmentInfo/departmentHistory";
	}
}
