package jp.tuyano.spring.data1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	private static ApplicationContext context;
	private static EntityManager manager;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(MyAppConfig.class);
		EntityManagerFactory factory = context.getBean(EntityManagerFactory.class);
		manager = factory.createEntityManager();

		MyPersonDataDao<MyPersonData> dao =
				new MyPersonDataDaoImpl<MyPersonData>(manager);

		List<MyPersonData> list = dao.getAllEntity();
		for (MyPersonData person : list) {
			System.out.println(person);
		}
	}

}
