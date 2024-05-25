package kr.co.inhatcspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.inhatcspring.beans.BoardDataBean;

@Controller
public class CommunityController {

    private BoardDataBean boardDataBean;

    // community (커뮤니티)
    @GetMapping("notification")
    public String notification(Model model) {
        model.addAttribute("category", "공지사항");
        return "community/notification";
    }

    @GetMapping("/frequently-asked-questions")
    public String frequentlyAskedQuestions(Model model) {
        model.addAttribute("category", "FAQ");
        return "community/frequentlyAskedQuestions";
    }

    @GetMapping("/free-board")
    public String freeBoard(Model model) {
        model.addAttribute("category", "자유게시판");
        return "community/freeBoard";
    }

//    // 글 작성 페이지로 이동
//    @GetMapping("community/writePost")
//    public String writePostForm(@RequestParam String category, Model model) {
//        model.addAttribute("category", category);
//        return "writePost"; 
//    }
}
