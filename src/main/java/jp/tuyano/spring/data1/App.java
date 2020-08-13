package jp.tuyano.spring.data1;

import java.util.List;

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

		MyPersonDataDao<MyPersonData> dao =
				new MyPersonDataDaoImpl<MyPersonData>(manager);
		MyPersonData personData = manager.find(MyPersonData.class, 1L);
		personData.setName("***" + personData.getName() + "***");
		dao.updateEntity(personData);

		List<MyPersonData> list = dao.getAllEntity();
		for (MyPersonData person : list) {
			System.out.println(person);
		}
	}

}
