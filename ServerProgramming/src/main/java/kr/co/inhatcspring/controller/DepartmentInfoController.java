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
@RequestMapping("/department-info")
public class DepartmentInfoController {
    
    @Autowired
    private MapperInterface mapper;

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
        return "redirect:/department-info/" + category;
    }
}
