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
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    private MapperInterface mapper;

    /***************************
              커뮤니티
     ***************************/
    
    // 공지사항 페이지
    @GetMapping("/notification")
    public String notification(Model model) {
        model.addAttribute("category", "notification"); // 모델에 '공지사항' 카테고리 추가
        List<BoardDataBean> boardList = mapper.getBoardList("notification");
        model.addAttribute("boardList", boardList);
        return "community/notification"; // 'community/notification' 뷰 반환
    }

    // 자주 묻는 질문(FAQ) 페이지
    @GetMapping("/frequently-asked-questions")
    public String frequentlyAskedQuestions(Model model) {
        model.addAttribute("category", "frequently-asked-questions"); // 모델에 'FAQ' 카테고리 추가
        List<BoardDataBean> boardList = mapper.getBoardList("frequently-asked-questions");
        model.addAttribute("boardList", boardList);
        return "community/frequentlyAskedQuestions"; // 'community/frequentlyAskedQuestions' 뷰 반환
    }

    // 자유게시판 페이지
    @GetMapping("/free-board")
    public String freeBoard(Model model) {
        model.addAttribute("category", "free-board"); // 모델에 '자유게시판' 카테고리 추가
        List<BoardDataBean> boardList = mapper.getBoardList("free-board");
        model.addAttribute("boardList", boardList);
        return "community/freeBoard"; // 'community/freeBoard' 뷰 반환
    }

    /***************************
              글 작성 페이지
     ***************************/
    
    // 글 작성 페이지로 이동
    @GetMapping("/formPost")
    public String writePostForm(@RequestParam String category, Model model) {
        model.addAttribute("category", category); // URL에서 받은 'category'를 모델에 추가
        return "etc/formPost"; // 'writePost' 뷰 반환
    }
     
    // 글 작성 처리
    @PostMapping("/submitPost")
    public String submitPost(@RequestParam("category") String category,
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

        // 처리 후 카테고리 페이지로 리디렉션
        return "redirect:/community/" + category;
    }
}
