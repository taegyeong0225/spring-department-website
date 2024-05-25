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
	
	private BoardDataBean boardDataBean;

    @Autowired
    MapperInterface mapper1;
    
    // main page (home)
    @GetMapping("/")
	public String home() {
		return "etc/home";
    }
    
    // 오시는 길
    @GetMapping("/directions")
	public String directions() {
		return "etc/directions";
	}
    
    // writePost (글 작성)
    @GetMapping("/directions/formPost")
    public String formPost(@RequestParam("category") String category, Model model) {
        model.addAttribute("category", category);
        return "etc/formPost"; // directions 폴더 내의 formPost.jsp로 이동
    }
    
    
    // myBatis
    @GetMapping("/input_data")
    public String input_data() {
        return "input_data";
    }

    @PostMapping("/input_pro")
    public String input_pro(DataBean dataBean) {
        mapper1.insert_data(dataBean);
        return "input_pro";
    }

    @GetMapping("/read_data")
    public String read_data(Model model) {
        List<DataBean> list = mapper1.select_data();
        model.addAttribute("list", list);
        return "read_data";
    }
}
