package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//컨트롤러는 반드시 클래스위에 어노테이션 컨트롤러 입력해줘야됨
@Controller
public class PlusController {
	@GetMapping(path = "/plusform") // plusform이라는 요청이 들어왔을때, get방식으로 들어올거임
	public String plusform() { //요청들어왓을 때 일을 처리하게될 메서드임, 뷰네임을 넘겨줘야됨, string타입으로 넘길수있고 모델엔뷰로 넘길수있고 등등
		return "plusForm"; //뷰만 찾아서 뷰에대한 정보만 넘기면 되니까 뷰의 이름 return 해줌
		//plusForm을 가지고 configuration에서 prefix, suffix해줄거임, 그래서 완벽한 뷰의 경로(뷰의정보)알아서 뷰로 보여줄거임
	}

	@PostMapping(path = "/plus") // post로 받겠다했으니까 post로 form에서 값을 두개 넘겼으니 받아서 더한다음에 리퀘스트 스코프에 넣어서 넘겨주면 해당 jsp가 값을 출력할거임 
	public String plus(@RequestParam(name = "value1", required = true) int value1,
			@RequestParam(name = "value2", required = true) int value2, ModelMap modelMap) {
		//메소드 인수 애노테이션									//form에서 value1으로 들어온걸 나는 이 메소드에서 int value1으로 사용할것이다.
//mapping된 메소드의 인수에 붙일 수 있는 어노테이션
//해당 어노테이션의 name은 http parameter의 name 과 메핑이됨
//required는 필수인지 아닌지 판단
//pathvariable은 url패스에 ? 이렇게 넘겨올수있는데 거기에 대한 변수를 받는거임
		int result = value1 + value2;

		//request scope에 넣어줌 // 키     벨류  (키(이름)으로 벨류(값)넣겟다)
		modelMap.addAttribute("value1", value1); // 이론적으로 서블릿리퀘스트 선언해서 쓸수 있겠지만 sprint이 제공하고 있는 modelmap객체 받아서 여기다 넣어줄거임, 알아서 spring이 리퀘스트 스콥에 넣어줌
		modelMap.addAttribute("value2", value2);//스프링이 제공하는 객체 사용해도됨 다양한것들이있음
		modelMap.addAttribute("result", result);
		return "plusResult";
		//plusResult 는 configuration에서 서픽스 프리픽스해서 실행할거임
		
	}
}