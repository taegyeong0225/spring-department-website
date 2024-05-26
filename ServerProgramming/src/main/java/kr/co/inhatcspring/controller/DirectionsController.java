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
public class DirectionsController {
    
    @Autowired
    private MapperInterface mapper;
    

    /***************************
             오시는 길
    ***************************/
    
    // 오시는 길 페이지
    @GetMapping("/directions")
    public String directions(@RequestParam(value = "category", required = false, defaultValue = "directions") String category, Model model) {
        List<BoardDataBean> boardList = mapper.getBoardList(category);
        model.addAttribute("boardList", boardList);
        model.addAttribute("category", category);
        return "etc/directions"; // 'etc/directions' 뷰 반환
    }
}
