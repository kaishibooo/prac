package prac;

import java.text.MessageFormat;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.thymeleaf.util.StringUtils;

@SpringBootApplication
@MapperScan("prac.security.repository")
public class PracApplication {

	public static void main(String[] args) {

		String springProfilesActive = System.getProperty("spring.profiles.active");
		if(!StringUtils.equals(springProfilesActive, "product")
				&& !StringUtils.equals(springProfilesActive, "develop")){
			throw new UnsupportedOperationException(
				MessageFormat.format(
				"JVMの起動時引数 -Dspring.profiles.active で develop か product を指定して下さい ( -Dspring.profiles.active={0} )。"
						, springProfilesActive));
		}

		SpringApplication.run(PracApplication.class, args);
	}

	// MyBatisの設定
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);

		//コンフィグファイルの読込
		sessionFactory.setConfigLocation(new ClassPathResource("/mybatis-config.xml"));

		return sessionFactory.getObject();
	}
}
