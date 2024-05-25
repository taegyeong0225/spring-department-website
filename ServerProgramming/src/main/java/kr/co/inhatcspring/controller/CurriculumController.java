package kr.co.inhatcspring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.inhatcspring.beans.BoardDataBean;

@Controller
public class CurriculumController {
	
	private BoardDataBean boardDataBean;
	
    // curriculum (교과과정)
    @GetMapping("/first-grade")
	public String firstGrade(Model model) {
    	model.addAttribute("category", "1학년");
		return "curriculum/firstGrade";
	}

    @GetMapping("/second-grade")
	public String secondGrade(Model model) {
    	model.addAttribute("category", "2학년");
		return "curriculum/secondGrade";
	}
    
    @GetMapping("/third-grade")
	public String thirdGrade(Model model) {
    	model.addAttribute("category", "3학년");
		return "curriculum/thirdGrade";
	}
    
    @GetMapping("/bachelors-degree-course")
	public String bachelorsDegreeCourse(Model model) {
    	model.addAttribute("category", "전공심화");
		return "curriculum/bachelorsDegreeCourse";
	}
    
    @GetMapping("/curriculum/writePost")
    public String writePostForm(@RequestParam String category, Model model) {
        model.addAttribute("category", category);
        return "writePost";
    }
}
