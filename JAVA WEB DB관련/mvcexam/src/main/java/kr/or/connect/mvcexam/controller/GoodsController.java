package kr.or.connect.mvcexam.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller//컨트롤러인거 알려주기
public class GoodsController {
	@GetMapping("/goods/{id}") //url요청이 들어왔을때 {id}를 패스 베리어블로 받겟다임
	public String getGoodsById(@PathVariable(name="id") int id, //id라는 이름으로 넘어온것을 이 메소드에서 id로 들고오겠다, 어노테이션도 패스베리어블임
							   @RequestHeader(value="User-Agent", defaultValue="myBrowser") String userAgent,//헤더에서 넘어오는 정보 사용하려고 string으로 받음
							  HttpServletRequest request,//리퀘스트가 가진 값보여주려고 리퀘스트 사용하는거 보여주는거임
							  ModelMap model //modelmap을 이용해서 값 등록하기 jsp가 꺼내서 사용할수있도록
							  ) {
		
		String path = request.getServletPath();
		
		System.out.println("id : " + id);
		System.out.println("user_agent : " + userAgent);
		System.out.println("path : " + path);
		
		//modelmap을 이용해서 값 등록하기 jsp가 꺼내서 사용할수있도록
		model.addAttribute("id", id);
		model.addAttribute("userAgent", userAgent);
		model.addAttribute("path", path);
		return "goodsById";
	}
}