package kr.or.connect.guestbook2.service;

import java.util.List;

import kr.or.connect.guestbook2.dto.Guestbook;

//GuestbookService에서는 비즈니스가 뭐뭐 있을 거냐.
//방명록 요구 사항을 다시 한 번 생각을 해보면
//방명록 정보를 페이지 별로 읽어오기
//페이징 처리를 위해서 전체 건 수 구하기
//방명록 저장하기, 이런 것들이 필요했단 말이에요.
//
public interface GuestbookService {
	public static final Integer LIMIT = 5;
	public List<Guestbook> getGuestbooks(Integer start); 
	//그리고 지금 시간은 아니지만 우리가 다음에 사용하기 위해서 id에 해당하는 방명록을 삭제하는 이런 메서드들을 지금 선언하고 있어요.
	public int deleteGuestbook(Long id, String ip);
	
	//그리고 이런 삭제와 등록의 경우에는 이미 해당 정보는 ip라는 정보를 인자로 전달을 하고 있는 것을 볼 수 있을 텐데요.
	//LogDao를 이용해서 Log 테이블에 저장하게 될 거예요.
	public Guestbook addGuestbook(Guestbook guestbook, String ip);
	public int getCount();
}
//이런 부분들이 필요할 거다고 서비스 인터페이스에서 정의했다면 인터페이스를 구현하는 클래스를 작성해야겠죠?
//구현하는 클래스는 impl에다가 작성을 해주시면 되고요.