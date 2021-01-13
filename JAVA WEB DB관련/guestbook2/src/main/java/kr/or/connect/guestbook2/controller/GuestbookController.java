package kr.or.connect.guestbook2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.guestbook2.dto.Guestbook;
import kr.or.connect.guestbook2.service.GuestbookService;

@Controller //GuestbookController도 마찬가지로 나 컨트롤러에요 하고 알려줘야겠죠? 그래야지 ComponentScan 할 때 해당 Bean을 찾아서 사용할 수 있을 거예요.
public class GuestbookController {
	//이 컨트롤러에서는 또 누구를 사용할 거냐면 서비스를 이용하겠죠. 이 컨트롤러에서 서비스를 이용하게 하기 위해서는 @Autowired 이렇게 어노테이션 붙여주시면 되고요.
	@Autowired
	GuestbookService guestbookService; //실제 사용하게 될 서비스를 써주시면 되는데 GuestbookService 이렇게 선언해주시면 돼요.
	
	@GetMapping(path="/list") //일단은 path가 list로 들어왔을 때 처리하는 부분이에요.
	public String list(@RequestParam(name="start", required=false, defaultValue="0") int start,//@RequestParam으로 "start"라는 값을 꺼내서 사용할 수 있을 거고요. 이때 만약에 값이 없다면 defaultValue를 0으로 주겠다.
					   ModelMap model) {
		
		// start로 시작하는 방명록 목록 구하기
		List<Guestbook> list = guestbookService.getGuestbooks(start); //그리고 이제 서비스로부터 start를 넣어서 해당 목록을 얻어오면 될 거고
		
		// 전체 페이지수 구하기
		int count = guestbookService.getCount(); //그런 다음에 서비스가 갖고 있는 getCount() 이용해가지고 전체 페이지 수 얻어올 수 있겠죠?
		int pageCount = count / GuestbookService.LIMIT; //그리고 이 전체 페이지 수를 한 페이지 당 몇 개씩 보여줄래? 라는 것을 GuestbookService의 상수 LIMIT으로 지정을 했었는데
		//이 LIMIT으로 나눠보면 pageCount를 구해낼 수 있을 거고요.
		if(count % GuestbookService.LIMIT > 0)
			pageCount++;
		
		//pageCount를 얻어왔고 이제 페이지의 수만큼 start 값을 list로 저장을 해놓으면 되겠죠.
		//그래야지 우리가 숫자로 된 페이지 링크를 클릭할 때 start 값을 넣어줄 수 있을 거잖아요
		//만약에 페이지가 3이라면 start 값을 저장하는 리스트에 0, 5, 10 이렇게 들어있으면 되겠죠.
		// 페이지 수만큼 start의 값을 리스트로 저장
		// 예를 들면 페이지수가 3이면
		// 0, 5, 10 이렇게 저장된다.
		// list?start=0 , list?start=5, list?start=10 으로 링크가 걸린다.
		//실제로 값이 보내질 때 이렇게 start=0 그렇죠? list?strat=5 이렇게 링크가 걸려야 될 테니까 그 부분을 위해서 값을 저장해주는 거
		List<Integer> pageStartList = new ArrayList<>();
		for(int i = 0; i < pageCount; i++) {
			pageStartList.add(i * GuestbookService.LIMIT);
			//pageStartList에다가 값을 넣어주고있고
			//이 부분을 JSP에서 사용해야 되기 때문에
		}
		//JSP에서 사용하도록 model에다가 필요한 부분들을 넣어줄 거고요.
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pageStartList", pageStartList);
		//이 넣어준 부분을 list.jsp가 사용하면 되겠죠?
		return "list";
	}
	
	@PostMapping(path="/write")
	public String write(@ModelAttribute Guestbook guestbook,
						HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		System.out.println("clientIp : " + clientIp);
		guestbookService.addGuestbook(guestbook, clientIp);
		return "redirect:list";
	}
}