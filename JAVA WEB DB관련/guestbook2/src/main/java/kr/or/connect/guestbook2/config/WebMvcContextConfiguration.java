package kr.or.connect.guestbook2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration // 설정이라는거 알려주기
@EnableWebMvc  //기본적인 설정 자동으로해주세요
@ComponentScan(basePackages = { "kr.or.connect.guestbook2.controller" }) //controller알아서 읽어오게하기위해 컴포넌트 스캔이용
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter{ //내가 원하는 설정도 하기 위해 아답터 상속받음
	//현재 이 객체에서 하는 이 설정들은 DispatcherServlet이 읽어들이는 거라는 거.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	//URL 요청이 여기처럼 /css, /img, /js(왼쪽) 이렇게 들어오는 것들은 어떻게 처리해주세요.
    																//이런 폴더(오른쪽)에서 읽어오도록 설정을 하고 있는 거고요.
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }
 
    // default servlet handler를 사용하게 합니다.
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();//이렇게 사용해주면 default servlet handler를 사용할 수 있게 해주는 설정
        //이 부분은 매핑 정보가 없는 URL 요청이 들어왔을 때 매핑 정보가 없는 URL 요청은 Spring의 DefaultServletHttpRequsetHandler가 처리하도록 해주게 하는 거잖아요.
        //이런 부분들을 설정하게 함으로써 매핑이 없는 URL이 넘어왔을 때 WAS의 default servlet이 static 한 자원을 읽어서 보여줄수있게끔해주는 설정
    }
   
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
    	//특정 URL에 대한 처리를 컨트롤러 클래스를 작성하지 않고 매핑할 수 있도록 해주는 부분
    		System.out.println("addViewControllers가 호출됩니다. ");
        registry.addViewController("/").setViewName("index");
        //그래서 "/"라고 요청이 들어오면 "index"라는 이름의 뷰로 보여주세요. 하고 설정을 해주는 부분이죠.
        
    }
    
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        //이 부분은 이제 적절한 view resolver가 실제로 뷰의 이름(여기서는 index)을 가지고 어떤 뷰인지에 대한 정보를 찾아낼 수 있게 해주는데 지금 현재 여기 설정에서는 resolver에다가
        //Prefix랑 Suffix를 지정하게 함으로써 이렇게 적절하게 index가 들어왔을 때 /WEB-INF/views라는 디렉터리 밑에 있는 index.jsp를 보여주세요.
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}