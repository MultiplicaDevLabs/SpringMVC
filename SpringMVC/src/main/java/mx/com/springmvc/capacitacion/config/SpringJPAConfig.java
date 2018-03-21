package mx.com.springmvc.capacitacion.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class SpringJPAConfig {

	/**
	 * Se configura a conexao com o Banco de Dados
	 * 
	 * @return
	 */
	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		String host = System.getenv("MYSQL_HOST");
		String database = System.getenv("MYSQL_DATABASE");
		String username = System.getenv("MYSQL_USERNAME");
		String password = System.getenv("MYSQL_PASSWORD");
		ds.setUrl("jdbc:mysql://"+host+":3306/"+database);
		ds.setUsername(username);
		ds.setPassword(password);

		return ds;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource);
		factory.setPackagesToScan("mx.com.springmvc.capacitacion.domain"); //entidaes mapeadas
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter()); //informa que utilizaremos hibernate e jpa
		factory.setJpaProperties(this.jpaProperties());
		factory.afterPropertiesSet();
				
		return factory.getObject();
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory factory) {
		
		JpaTransactionManager tx = new JpaTransactionManager();
		tx.setEntityManagerFactory(factory);
		tx.setJpaDialect(new HibernateJpaDialect());
		
		return tx;
	}
	
	private Properties jpaProperties() {

		Properties props = new Properties();
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.format_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update"); //cria ou modifica uma entidade na BD
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return props;
	}
}
