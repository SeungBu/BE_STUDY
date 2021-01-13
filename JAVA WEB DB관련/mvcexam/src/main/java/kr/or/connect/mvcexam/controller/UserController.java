package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.connect.mvcexam.dto.User;

@Controller
public class UserController {
	@RequestMapping(path="/userform", method=RequestMethod.GET)
	public String userform() {
		return "userForm";
	}
	
	@RequestMapping(path="/regist", method=RequestMethod.POST)
	public String regist(@ModelAttribute User user) { //하나하나 꺼낸다는게 아니라 해당 어노테이션을 이용해서 User객체 사용, 이렇게 선언만 해주면 spring mvc가 userfome에 있는 input들 꺼나와서 User객체 생성해서 넣어줌 
		//지난 예제(plusform에서는 requestparam을 통해 하나하나하나 갖고왔는데 하나 보단 가방처럼 갖고다니는 dto같은 역할을 할수있는
		//@ModelAttribute 라는 어노테이션을 붙이고 User해당 객체에 담아달라는뜻임
		System.out.println("사용자가 입력한 user 정보입니다. 해당 정보를 이용하는 코드가 와야합니다.");
		System.out.println(user);
		return "regist";
	}
}