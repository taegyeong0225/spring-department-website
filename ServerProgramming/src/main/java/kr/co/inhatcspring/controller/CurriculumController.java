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
//@RequestMapping("/curriculum")
public class CurriculumController {
    
    @Autowired
    private MapperInterface mapper;

    /***************************
     
            교과과정 컨트롤러
            
     ***************************/

    // 1학년 페이지로 이동
    @GetMapping("/first-grade")
    public String firstGrade(@RequestParam(value = "category", required = false, defaultValue = "first-grade") String category, Model model) {
        List<BoardDataBean> boardList = mapper.getBoardList(category);
        model.addAttribute("boardList", boardList);
        model.addAttribute("category", category);
        return "post/viewList"; // 1학년 교과과정 페이지 반환
    }

    // 2학년 페이지로 이동 
    @GetMapping("/second-grade")
    public String secondGrade(@RequestParam(value = "category", required = false, defaultValue = "second-grade") String category, Model model) {
        List<BoardDataBean> boardList = mapper.getBoardList(category);
        model.addAttribute("boardList", boardList);
        model.addAttribute("category", category);
        return "post/viewList"; // 2학년 교과과정 페이지 반환
    }
    
    // 3학년 페이지로 이동 
    @GetMapping("/third-grade")
    public String thirdGrade(@RequestParam(value = "category", required = false, defaultValue = "third-grade") String category, Model model) {
        List<BoardDataBean> boardList = mapper.getBoardList(category);
        model.addAttribute("boardList", boardList);
        model.addAttribute("category", category);
        return "post/viewList"; // 3학년 교과과정 페이지 반환
    }
    
    // 전공심화 과정으로 이동 
    @GetMapping("/bachelors-degree-course")
    public String bachelorsDegreeCourse(@RequestParam(value = "category", required = false, defaultValue = "bachelors-degree-course") String category, Model model) {
        List<BoardDataBean> boardList = mapper.getBoardList(category);
        model.addAttribute("boardList", boardList);
        model.addAttribute("category", category);
        return "post/viewList"; // 전공심화 교과과정 페이지 반환
    }
}
