package kr.or.connect.mvcexam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//베이스패키지하고 중괄호사용하면 패키지 여러개있을때 ,로 사용가능 없으면 해당패키지사용. 베이스패키지는 지정해줘야됨 어느패키지부터 찾을지 몰라서 잘못찾을수있음
//베이스패키지가 컨트롤러라는 패키지이고 여기서 찾을거라는 표시임
//디스패쳐 서블릿이 실행될대 읽어들이는 설정파일임 이 클래스가.
@Configuration //나 설정파일이에요~
@EnableWebMvc // 기본적인 설정은 해주세요~
@ComponentScan(basePackages = { "kr.or.connect.mvcexam.controller" })//controller라는거 붙어있는거 읽어와서 사용해요~ 라고 컴포넌트스캔추가
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//필요한 이유는 모든 요청이들어왓을때 이 서블릿이 실행하게해줘로 라고 urlpattern에 /로했는데
		//그런데 이때 들어오는 모든 요청중에는 컨트롤러의 URL이 매핑되어있는 요청만 들어오는 게 아니라 CSS라든가, 이미지라든가, 자바스크립트라든가 이런 등등의 것들도 / 때문에 요청 다받음
		//이렇게 요청하다보니 반드시 뭘 알려줘야 되지 되는 거냐면 실제로 요청이 들어올 때 /js/**, /img/**, /css/** 이렇게 시작하는 URL 요청은 애플리케이션 루트 디렉터리 아래에 있는 각각의 이런 디렉터리를 만들어놓고 거기에다가 알맞게 사용하게 해줄 거예요.
		//이렇게 요청(addResourceHandler("/assets/**"))이 들어오는 것은 여기서(classpath:/META-INF/resources/webjars/)찾아요.라는 설정임 
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }
 
    // default servlet handler를 사용하게 합니다.
	//
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();//DefaultServletHandler를 사용하도록 해주는 거예요.
        //매핑 정보가 없는 URL 요청은 Spring의 DefaultServletHttpRequestHandler가 처리하도록 해줘요
    }
   
    //addViewControllers 메서드는 특정 URL에 대한 처리를 컨트롤러 클래스를 작성하지 않고 매핑할 수 있도록 해주는 건데요.
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
    		System.out.println("addViewControllers가 호출됩니다. ");
        registry.addViewController("/").setViewName("main");
        //여기에서 보시면 "/"라는 애, 지금 요청 자체가 "/" 하고 들어오면 "main"이라고 하는 이름의 뷰로 보여주도록 하는 거죠.
        //그러니까 main은 어디서 찾아내게 되냐면 view name은 ViewResolver라는 객체를 이용해서 찾아요라고 이야기했었거든요.
        //실제 "main"이라는 이름만 가지고서는 뷰 정보를 찾아낼 수가 없고요. 뷰 정보는 getInternalResourceViewResolver 라는 메서드에서 설정된 형태로 뷰를 사용하게 돼요.
    }
    
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");//setPrefix, Suffix를 지정
        resolver.setSuffix(".jsp");//위에 "main앞에 prefix 위에 suffix붙음
        return resolver; ///이 뷰는 WEB-INF/views/main.jsp 라는 파일을 찾아주는 거예요.
    }
}
///이런 설정을 읽어들여서 DispatcherServlet이 동작을 하게 될 거다.