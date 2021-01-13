package kr.or.connect.guestbook2.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;


// 데이터베이스에 관련된 설정 Spring JDBC가 읽어낼 수 있도록 하게 하기 위해서요.


@Configuration //이 부분 때문에 나 Configuration이에요. 하고 알려주는 거고요.
@EnableTransactionManagement //이 어노테이션은 트랜잭션과 관련된 설정을 자동으로 해줘요. 단, 사용자 간의 트랜잭션 처리를 위한 PlatformTransactionManager를 설정하기 위해서는 TransactionManagement Confiugre를 구현
public class DBConfig implements TransactionManagementConfigurer {
	private String driverClassName = "com.mysql.jdbc.Driver";

	private String url = "jdbc:mysql://localhost:3306/guestbookdb?useUnicode=true&characterEncoding=utf8";

	private String username = "root";

	private String password = "qsd1001918";

	@Bean
	public DataSource dataSource() {
		//이 앞에 있는 부분들은 데이터베이스 연결하기 위해서 사용했었던 DataSource Bean 등록하고 있는 부분을 볼 수 있죠.
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		//annotationDrivenTransactionManager 메서드를 오버라이딩 해야 돼요.
		//해당 메서드에서 트랜잭션을 처리할 PlatformTransactionManager 객체를 반환하게 하면 돼요.
		//현재 이 메서드 보니까 transactionManger 호출하고 있는데
		
		return transactionManger();
	}

	@Bean
	public PlatformTransactionManager transactionManger() {
		//transactionManger라는 메서드를 보니까 PlatformTransactionManager를 리턴하고 있죠.
		return new DataSourceTransactionManager(dataSource());
	}
}