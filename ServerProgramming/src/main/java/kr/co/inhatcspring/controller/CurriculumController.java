package kr.co.inhatcspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.inhatcspring.beans.BoardDataBean;

@Controller
public class CurriculumController {
	
    private BoardDataBean boardDataBean; // BoardDataBean 객체 주입

    /***************************
            교과과정 컨트롤러
     ***************************/

    // 1학년 페이지
    @GetMapping("/first-grade")
    public String firstGrade(Model model) {
        model.addAttribute("category", "1학년");
        return "curriculum/firstGrade"; // 1학년 교과과정 페이지 반환
    }

    // 2학년 페이지
    @GetMapping("/second-grade")
    public String secondGrade(Model model) {
        model.addAttribute("category", "2학년");
        return "curriculum/secondGrade"; // 2학년 교과과정 페이지 반환
    }
    
    // 3학년 페이지
    @GetMapping("/third-grade")
    public String thirdGrade(Model model) {
        model.addAttribute("category", "3학년");
        return "curriculum/thirdGrade"; // 3학년 교과과정 페이지 반환
    }
    
    // 전공심화 과정 페이지
    @GetMapping("/bachelors-degree-course")
    public String bachelorsDegreeCourse(Model model) {
        model.addAttribute("category", "전공심화");
        return "curriculum/bachelorsDegreeCourse"; // 전공심화 교과과정 페이지 반환
    }
    
    /***************************
		    글 작성 페이지
     ***************************/ 
    // 각 교과과정 페이지에서 글 작성 폼으로 이동
    @GetMapping("/curriculum/formPost")
    public String writePostForm(@RequestParam String category, Model model) {
        model.addAttribute("category", category); // URL에서 category 파라미터를 받아 모델에 추가
        return "etc/formPost"; // 글 작성 폼 페이지 반환
    }
}
