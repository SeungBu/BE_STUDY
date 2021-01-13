package kr.or.connect.guestbook2.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.guestbook2.dto.Guestbook;
import kr.or.connect.guestbook2.service.GuestbookService;

@RestController// 이 부분은 Rest Controller라고 했잖아요? 어노테이션을 RestController로 붙이면 된다
@RequestMapping(path="/guestbooks") //그리고 해당 API 클래스 안에는 같은 매핑으로 여러 개를 수행하잖아요. 그러니까 이 클래스 자체에다가 RequestMapping을 선언하시면
//안쪽에 있는 것들을 다 공통으로 사용할 수가 있어요. 해서 RequestMapping에 "/guestbooks" 이렇게 path를 지정해주시면 되고요.
public class GuestbookApiController {
	//이 클래스에서도 서비스가 사용되야지 될 거니까
	//서비스를 사용하기 위해서 @Autowired 넣어주시면 되겠죠?
	@Autowired
	GuestbookService guestbookService;
	
 //@GetMapping 되어있는데 path는 따로 없죠? 그 이유는 여기에 RequestMapping이 붙어있고요.
	//path가 /guestbooks라고 시작을 하면서 Get 방식으로 요청이 들어오면 이 메서드를 실행할 거예요.
	//이런 URL로 요청이 들어오면서 Content-Type이 application/json 그리고 Get 방식으로 요청이 들어오면 이 메서드가 실행될 거다.
	// 이 메서드가 실행되는데 결과 값으로 Map 객체를 반환할 거다.
	@GetMapping
	public Map<String, Object> list(@RequestParam(name="start", required=false, defaultValue="0") int start) {
		//application/json 요청이기 때문에 DipatcherServlet은 jsonMessageConvert를 내부적으로 사용해서 해당 Map 객체를 json으로 변환해서 전송을 하게 됩니다.
		
		List<Guestbook> list = guestbookService.getGuestbooks(start);
		
		int count = guestbookService.getCount();
		int pageCount = count / GuestbookService.LIMIT;
		if(count % GuestbookService.LIMIT > 0)
			pageCount++;
		
		List<Integer> pageStartList = new ArrayList<>();
		for(int i = 0; i < pageCount; i++) {
			pageStartList.add(i * GuestbookService.LIMIT);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("count", count);
		map.put("pageStartList", pageStartList);
		
		return map;
	}
	//Post 방식의 요청은 @PostMapping이 붙어있는 write라는 메서드가 호출이 될 거고요.
	//해당 결과는 Guestbook 객체로 반환하는데 이것도 마찬가지 json 메서드로 변환돼서 클라이언트한테는 갈 거예요.
	//클라이언트한테 응답이 갈 때는 json으로 바뀌어서 가더라.
	@PostMapping
	public Guestbook write(@RequestBody Guestbook guestbook,
						HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		// id가 입력된 guestbook이 반환된다.
		Guestbook resultGuestbook = guestbookService.addGuestbook(guestbook, clientIp);
		return resultGuestbook;
	}
	
	//DeleteMapping은 path 정보가 있어요. 이것은 위에서 지정한 guestbooks/ id가 온다 이거 알 수 있겠죠?
	@DeleteMapping("/{id}")//이런 id 정보를 PathVariable이라고 했던 거 기억하시죠?
	public Map<String, String> delete(@PathVariable(name="id") Long id, //메서드의 인자 보면 @pathVaialbe이라는 어노테이션으로 값을 읽어들이고 있는 것을 볼 수 있을 거고요.
			HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		
		int deleteCount = guestbookService.deleteGuestbook(id, clientIp);
		return Collections.singletonMap("success", deleteCount > 0 ? "true" : "false");
		//해당 메서드가 성공하면 Map 객체를 생성하는데 키값은 "success"로 주고 값은 true나 false가 리턴이 되겠죠.
	}
}

//이렇게 작성한 Rest API는 제대로 수행이 잘 됐는지 안 됐는지 확인을 하기 위해서는 Rest API를 테스트하기 위한 클라이언트가 필요할 거예요.
//이런 클라이언트는 다양하게 존재하는데요. 저는 크롬 브라우저에서 Restlet Client(오른쪽 맨위)라는 여기 보이는 거요. 확장 프로그램을 설치해서 사용해요.



//보면 Add라고 되어있는 버튼 보이시죠. Add를 선택하셔가지고 Request에다가 원하는 이름을 써주시면 되는데요.
//거기다가 이름을 쓰시고 사용을 하시면 되고요.  그리고 이제 실제 테스트해보기 위해서 메서드를 여기서 선택하면 돼요. (get put 등등)
//HEADERS 부분에다가 Content-Type이라고 지정을 하시고 해당 Content-Type을 application/json 이라고 지정을 해주셔야지 돼요.
//그리고 테스트할 URL을 넣어주시면 되는데요 지금 우리 URL 같은 경우에 이렇게 guestbook/guestbooks 하고 되어있잖아요. 이렇게 설정을 하시고 Send 하셔가지고 실행을 해보면요.
//하단에 Respone 하고 나오는 걸 보실 수 있을 텐데 여기에서는 list를 보여줘요 했기 때문에 지금 이렇게 list가 보여지는 걸 볼 수 있죠.
//이렇게 수행하실 때 뒤에다가 ?start=5 이렇게 실행하시고 Send 해보시면 이 부분에 하나만 나오고 있는 거를 볼 수 있을 거예요.

//PostMapping 할 때는 실제 입력할 guestbook의 정보를 가지고 들어와야 되잖아요.
//그래서 여러분이 테스트하실 때에도 메서드는 POST로 하시면 되고요. URL은 같으니까 그냥 두시면 되고 Content-Type은 똑같겠죠.
//json 타입으로 올 거니까. 그런데 하나 추가하셔야 될 부분은 바디에다가 실제 입력할 값을 json 형태로 추가를 해주셔야지 테스트가 가능할 거예요.

//삭제하는 거는 DeleteMapping이잖아요.
//DeleteMapping에다가 뒤에다가 id 값만 넣어주시면 되는데 우리 id를 3 번으로 하자고 했으니까 메서드를 DELETE로 바꾸시고
//여기에다가 /3 이렇게 넣어주시면 되겠죠? 그런 다음에 Send 하셔가지고 테스트를 해보면 suucess 해서 true가 리턴되고 있는 것을 확인할 수 있을 거예요.