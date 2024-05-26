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
public class BoardController {

    @Autowired
    private MapperInterface mapper;

    // 글 작성 페이지로 이동
    @GetMapping("/formPost")
    public String formPost(@RequestParam("category") String category, Model model) {
        model.addAttribute("category", category); // 모델에 'category' 속성 추가
        return "post/formPost"; // 'post/formPost' 뷰 반환
    }

    // 글 작성 폼 제출 처리
    @PostMapping("/submitPost")
    public String insertBoardData(@RequestParam("category") String category,
                                  @RequestParam("title") String title,
                                  @RequestParam("userId") String userId,
                                  @RequestParam("content") String content) {
        BoardDataBean boardDataBean = new BoardDataBean();
        boardDataBean.setCategory(category);
        boardDataBean.setTitle(title);
        boardDataBean.setContent(content);
        boardDataBean.setUserId(userId);

        // 데이터 저장
        mapper.insertBoardData(boardDataBean);

        return "redirect:/" + category;
    }
    
    // 글 조회 페이지로 이동
    @GetMapping("/viewPost")
    public String viewPost(@RequestParam("boardId") Long boardId, Model model) {
        BoardDataBean boardDataBean = mapper.getBoardData(boardId);
        model.addAttribute("boardDataBean", boardDataBean);
        return "post/viewPost"; // 'post/viewPost' 뷰 반환
    }
}
