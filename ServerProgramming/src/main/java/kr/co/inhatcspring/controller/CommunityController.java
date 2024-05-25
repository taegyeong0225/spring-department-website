package kr.co.inhatcspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.inhatcspring.beans.BoardDataBean;
import kr.co.inhatcspring.mapper.MapperInterface;

@Controller
public class CommunityController {

    private BoardDataBean boardDataBean; // BoardDataBean 객체 주입
    
    @Autowired
    MapperInterface mapper;

    /***************************
              커뮤니티
     ***************************/
    
    // 공지사항 페이지
    @GetMapping("/notification")
    public String notification(Model model) {
        model.addAttribute("category", "공지사항"); // 모델에 '공지사항' 카테고리 추가
        return "community/notification"; // 'community/notification' 뷰 반환
    }

    // 자주 묻는 질문(FAQ) 페이지
    @GetMapping("/frequently-asked-questions")
    public String frequentlyAskedQuestions(Model model) {
        model.addAttribute("category", "FAQ"); // 모델에 'FAQ' 카테고리 추가
        return "community/frequentlyAskedQuestions"; // 'community/frequentlyAskedQuestions' 뷰 반환
    }

    // 자유게시판 페이지
    @GetMapping("/free-board")
    public String freeBoard(Model model) {
        model.addAttribute("category", "자유게시판"); // 모델에 '자유게시판' 카테고리 추가
        return "community/freeBoard"; // 'community/freeBoard' 뷰 반환
    }

    /***************************
              글 작성 페이지
     ***************************/
    
    // 글 작성 페이지로 이동
     @GetMapping("/community/formPost")
     public String writePostForm(@RequestParam String category, Model model) {
        model.addAttribute("category", category); // URL에서 받은 'category'를 모델에 추가
        return "etc/formPost"; // 'writePost' 뷰 반환
     }
     
     // 글 작성 처리
     @PostMapping("/submitPost")
     public String submitPost(BoardDataBean boardDataBean) {
         mapper.insertBoardData(boardDataBean);
         return "redirect:/community/" + boardDataBean.getCategory(); // 글 작성 후 해당 카테고리 페이지로 리디렉션
     }
}
