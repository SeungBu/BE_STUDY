package kr.or.connect.reservation.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@EnableTransactionManagement
public class DBConfig implements TransactionManagementConfigurer {
	  private String driverClassName = "com.mysql.jdbc.Driver";
	    private String url = "jdbc:mysql://localhost:3306/reservation?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
	    private String adminId = "jinhong";
	    private String adminPasswd = "dkansk";

	    @Bean
	    public DataSource dataSource() {
	        BasicDataSource dataSource = new BasicDataSource();
	        dataSource.setDriverClassName(driverClassName);
	        dataSource.setUrl(url);
	        dataSource.setUsername(adminId);
	        dataSource.setPassword(adminPasswd);
	        return dataSource;
	    }

	    @Override
	    public PlatformTransactionManager annotationDrivenTransactionManager() {
	        return transactionManger();
	    }

	    @Bean
	    public PlatformTransactionManager transactionManger() {
	        return new DataSourceTransactionManager(dataSource());
	    }
}
