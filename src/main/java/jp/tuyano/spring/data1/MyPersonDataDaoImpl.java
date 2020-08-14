package jp.tuyano.spring.data1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
		Query query = manager.createQuery("from MyPersonData where " + field + " = '" + find + "'");
		return query.getResultList();
	}

	public void addEntity(Object entity) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		manager.flush();
		transaction.commit();
	}

	public void updateEntity(Object entity) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(entity);
		manager.flush();
		transaction.commit();
	}

	public void removeEntity(Object data) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.remove(data);
		manager.flush();
		transaction.commit();
	}

	public void removeEntity(Long id) {
		jp.tuyano.spring.data1.MyPersonData entity =
				manager.find(jp.tuyano.spring.data1.MyPersonData.class, id);
		this.removeEntity(entity);
	}
}
