package kr.co.inhatcspring.controller;

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
@RequestMapping("/curriculum")
public class CurriculumController {
    
    @Autowired
    private MapperInterface mapper;

    /***************************
            교과과정 컨트롤러
     ***************************/

    // 1학년 페이지
    @GetMapping("/first-grade")
    public String firstGrade(Model model) {
        model.addAttribute("category", "first-grade");
        return "curriculum/firstGrade"; // 1학년 교과과정 페이지 반환
    }

    // 2학년 페이지
    @GetMapping("/second-grade")
    public String secondGrade(Model model) {
        model.addAttribute("category", "second-grade");
        return "curriculum/secondGrade"; // 2학년 교과과정 페이지 반환
    }
    
    // 3학년 페이지
    @GetMapping("/third-grade")
    public String thirdGrade(Model model) {
        model.addAttribute("category", "third-grade");
        return "curriculum/thirdGrade"; // 3학년 교과과정 페이지 반환
    }
    
    // 전공심화 과정 페이지
    @GetMapping("/bachelors-degree-course")
    public String bachelorsDegreeCourse(Model model) {
        model.addAttribute("category", "bachelors-degree-course");
        return "curriculum/bachelorsDegreeCourse"; // 전공심화 교과과정 페이지 반환
    }
    
    /***************************
            글 작성 페이지
     ***************************/ 
    // 각 교과과정 페이지에서 글 작성 폼으로 이동
    @GetMapping("/formPost")
    public String writePostForm(@RequestParam String category, Model model) {
        model.addAttribute("category", category); // URL에서 category 파라미터를 받아 모델에 추가
        return "etc/formPost"; // 글 작성 폼 페이지 반환
    }

    // 글 작성 폼 제출 처리
    @PostMapping("/submitPost")
    public String insertBoardData(@RequestParam("category") String category,
                                  @RequestParam("title") String title,
                                  @RequestParam("userId") String userId,
                                  @RequestParam("content") String content,
                                  Model model) {
        BoardDataBean boardDataBean = new BoardDataBean();
        boardDataBean.setCategory(category);
        boardDataBean.setContent(content);
        boardDataBean.setUserId(userId);

        // 데이터 저장
        mapper.insertBoardData(boardDataBean);

        // 처리 후 카테고리 페이지로 리다이렉션
        return "redirect:/curriculum/" + category;
    }
}
