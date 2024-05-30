package kr.co.inhatcspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.inhatcspring.beans.BoardDataBean;
import kr.co.inhatcspring.mapper.MapperInterface;

@Controller
public class HomeController {
	
    @Autowired
    MapperInterface mapper; // 데이터베이스 작업을 위한 MyBatis 매퍼 인터페이스 자동 주입

    /***************************
            메인 페이지
    ***************************/
    
    // main (home) 페이지로 이동 
    @GetMapping("/")
    public String home() {
        return "etc/home"; // 'etc/home' 뷰 반환
    }

}
