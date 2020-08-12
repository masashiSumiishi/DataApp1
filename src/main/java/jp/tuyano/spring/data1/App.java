package jp.tuyano.spring.data1;

import javax.persistence.EntityManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

public class App {

	private static ApplicationContext context;
	private static EntityManager manager;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("classpath:/bean.xml");
		LocalContainerEntityManagerFactoryBean factory =
				context.getBean(LocalContainerEntityManagerFactoryBean.class);
		manager = factory.getNativeEntityManagerFactory().createEntityManager();

		MyPersonData data = manager.find(MyPersonData.class, 1L);
		System.out.println(data);
	}

}
