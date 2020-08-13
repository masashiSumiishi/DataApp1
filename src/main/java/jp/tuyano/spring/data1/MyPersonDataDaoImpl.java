package jp.tuyano.spring.data1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class MyPersonDataDaoImpl<MyPersonData>
	implements MyPersonDataDao<MyPersonData> {

	private EntityManager manager = null;

	public MyPersonDataDaoImpl(EntityManager manager) {
		super();
		this.manager = manager;
	}

	public List<MyPersonData> getAllEntity() {
		Query query = manager.createQuery("from MyPersonData");
		return query.getResultList();
	}

	@SuppressWarnings({"unchecked", "rawtypes" })
	public List findByField(String field, String find) {
		return null;
	}

	public void addEntity(Object entity) {

	}

	public void updateEntity(Object entity) {

	}

	public void removeEntity(Object data) {

	}

	public void removeEntity(Long id) {

	}
}
