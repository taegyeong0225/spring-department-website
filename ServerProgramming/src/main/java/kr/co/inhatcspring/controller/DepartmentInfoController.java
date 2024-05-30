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
public class DepartmentInfoController {
    
    @Autowired
    private MapperInterface mapper;
    
	/***************************
	 
	  	   학과 안내 컨트롤러 
	  		  
	 ***************************/   
	
	// Main : drop-down 학과안내 -> 학과소개 (학과소개 페이지로 이동)
	@GetMapping("/about-department")
	public String aboutDepartment(@RequestParam(value = "category", required = false, defaultValue = "about-department") String category, Model model) {
		List<BoardDataBean> boardList = mapper.getBoardList(category);
		model.addAttribute("boardList", boardList);
		model.addAttribute("category", category);
		return "departmentInfo/aboutDepartment"; // 학과소개 뷰 반환
	}
	
	// Main : drop-down 학과안내 -> 학과연혁 (학과연혁 페이지로 이동)
	@GetMapping("/department-history")
	public String departmentHistory(@RequestParam(value = "category", required = false, defaultValue = "department-history") String category, Model model) {
		List<BoardDataBean> boardList = mapper.getBoardList(category);
		model.addAttribute("boardList", boardList);
		model.addAttribute("category", category);
		return "departmentInfo/departmentHistory"; // 학과연혁 뷰 반환
	}
//    
//    /***************************
//               글 작성 페이지
//     ***************************/ 
//    // 글 작성 click -> formPost (글 작성 페이지로 이동)
//    @GetMapping("/formPost")
//    public String FormPost(@RequestParam("category") String category, Model model) {
//        model.addAttribute("category", category); // URL에서 category 파라미터 받아서 모델에 추가
//        return "post/formPost"; // formPost 뷰 반환
//    }
//
//    // 글 작성 폼 제출 처리
//    @PostMapping("/about-department/submitPost")
//    public String insertBoardData(@RequestParam("category") String category,
//                                  @RequestParam("title") String title,
//                                  @RequestParam("userId") String userId,
//                                  @RequestParam("content") String content,
//                                  Model model) {
//        BoardDataBean boardDataBean = new BoardDataBean();
//        boardDataBean.setCategory(category);
//        boardDataBean.setContent(content);
//        boardDataBean.setUserId(userId);
//
//        // 데이터 저장
//        mapper.insertBoardData(boardDataBean);
//
//        // 처리 후 카테고리 페이지로 리다이렉션
//        return "redirect:/" + category;
//    }
//    
//    // 글 조회 페이지로 이동
//    @GetMapping("/viewPost")
//    public String viewPost(@RequestParam("boardId") Long boardId, Model model) {
//        BoardDataBean boardDataBean = mapper.getBoardData(boardId);
//        model.addAttribute("boardDataBean", boardDataBean);
//        return "post/viewPost"; // 'post/viewPost' 뷰 반환
//    }
//
//    // 글 수정 폼으로 이동
//    @GetMapping("/editPost")
//    public String editPost(@RequestParam("boardId") Long boardId, Model model) {
//        BoardDataBean boardDataBean = mapper.getBoardData(boardId);
//        model.addAttribute("boardDataBean", boardDataBean);
//        return "post/editPost"; // 'post/editPost' 뷰 반환
//    }
//
//    // 글 수정 처리
//    @PostMapping("/updatePost")
//    public String updateBoardData(@RequestParam("category") String category,
//    							  @RequestParam("boardId") Long boardId,
//                                  @RequestParam("title") String title,
//                                  @RequestParam("content") String content,
//                                  Model model) {
//        BoardDataBean boardDataBean = new BoardDataBean();
//        boardDataBean.setBoardId(boardId);
//        boardDataBean.setTitle(title);
//        boardDataBean.setContent(content);
//
//        // 데이터 업데이트
//        mapper.updateBoardData(boardDataBean);
//
//        return "redirect:/" + category;
//    }
//
//    // 글 삭제 처리
//    @GetMapping("/deletePost")
//    public String deletePost(@RequestParam("category") String category,
//    						 @RequestParam("boardId") Long boardId, Model model) {
//        mapper.deleteBoardData(boardId);
//        return "redirect:/" + category;
//    }
}
