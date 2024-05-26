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
@RequestMapping("/directions")
public class DirectionsController {
    
    @Autowired
    private MapperInterface mapper;

    /***************************
            오시는 길
    ***************************/
    
    // 오시는 길 페이지
    @GetMapping
    public String directions(@RequestParam(value = "category", required = false, defaultValue = "directions") String category, Model model) {
        List<BoardDataBean> boardList = mapper.getBoardList(category);
        model.addAttribute("boardList", boardList);
        model.addAttribute("category", category);
        return "etc/directions"; // 'etc/directions' 뷰 반환
    }

    
    // 오시는 길 페이지에서 글 작성 버튼 클릭 -> 글 작성 페이지
    @GetMapping("/formPost")
    public String formPost(@RequestParam("category") String category, Model model) {
        model.addAttribute("category", category); // 모델에 'category' 속성 추가
        return "etc/formPost"; // 'etc/formPost' 뷰 반환
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
        return "redirect:/" + category;
    }


}
