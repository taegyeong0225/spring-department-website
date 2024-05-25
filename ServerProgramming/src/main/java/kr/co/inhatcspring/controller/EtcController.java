package kr.co.inhatcspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.inhatcspring.beans.BoardDataBean;
import kr.co.inhatcspring.beans.DataBean;
import kr.co.inhatcspring.mapper.MapperInterface;

@Controller
public class EtcController {
    
    @Autowired
    MapperInterface mapper1; // 데이터베이스 작업을 위한 MyBatis 매퍼 인터페이스 자동 주입

    /***************************
            메인 페이지
    ***************************/
    
    // 메인 페이지: 홈 ("/")
    @GetMapping("/")
    public String home() {
        return "etc/home"; // 'etc/home' 뷰 반환
    }
    
    /***************************
            오시는 길
    ***************************/
    
    // 오시는 길 페이지
    @GetMapping("/directions")
    public String directions() {
        return "etc/directions"; // 'etc/directions' 뷰 반환
    }
    
    // 오시는 길 페이지에서 글 작성 버튼 클릭 -> 글 작성 페이지
    @GetMapping("/directions/formPost")
    public String formPost(@RequestParam("category") String category, Model model) {
        model.addAttribute("category", category); // 모델에 'category' 속성 추가
        return "etc/formPost"; // 'etc/formPost' 뷰 반환
    }
    
    /***************************
            데이터 입력과 조회
    ***************************/
    
    // 데이터 입력 페이지
    @GetMapping("/input_data")
    public String input_data() {
        return "input_data";
    }

    // 데이터 입력 처리
    @PostMapping("/input_pro")
    public String input_pro(DataBean dataBean) {
        mapper1.insert_data(dataBean);
        return "input_pro";
    }

    // 데이터 조회 페이지
    @GetMapping("/read_data")
    public String read_data(Model model) {
        List<DataBean> list = mapper1.select_data();
        model.addAttribute("list", list);
        return "read_data";
    }
}
