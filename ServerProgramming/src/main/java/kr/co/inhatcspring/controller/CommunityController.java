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
public class CommunityController {

    @Autowired
    private MapperInterface mapper;

    /***************************
              커뮤니티
     ***************************/
    
    // 공지사항 페이지
    @GetMapping("/notification")
    public String notification(@RequestParam(value = "category", required = false, defaultValue = "notification") String category, Model model) {
        List<BoardDataBean> boardList = mapper.getBoardList(category);
        model.addAttribute("boardList", boardList);
        model.addAttribute("category", category);
        return "community/notification"; // 'community/notification' 뷰 반환
    }

    // 자주 묻는 질문(FAQ) 페이지
    @GetMapping("/frequently-asked-questions")
    public String frequentlyAskedQuestions(@RequestParam(value = "category", required = false, defaultValue = "frequently-asked-questions") String category, Model model) {
        List<BoardDataBean> boardList = mapper.getBoardList(category);
        model.addAttribute("boardList", boardList);
        model.addAttribute("category", category);
        return "community/frequentlyAskedQuestions"; // 'community/frequentlyAskedQuestions' 뷰 반환
    }

    // 자유게시판 페이지
    @GetMapping("/free-board")
    public String freeBoard(@RequestParam(value = "category", required = false, defaultValue = "free-board") String category, Model model) {
        List<BoardDataBean> boardList = mapper.getBoardList(category);
        model.addAttribute("boardList", boardList);
        model.addAttribute("category", category);
        return "community/freeBoard"; // 'community/freeBoard' 뷰 반환
    }

}
