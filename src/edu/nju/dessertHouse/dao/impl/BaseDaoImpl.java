package edu.nju.dessertHouse.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.dessertHouse.dao.BaseDao;
import edu.nju.dessertHouse.model.Branch;

@Repository
public class BaseDaoImpl implements BaseDao {
	/** * Autowired 自动装配 相当于get() set() */
	@Autowired
	protected SessionFactory sessionFactory;

	/** * gerCurrentSession 会自动关闭session，使用的是当前的session事务 * * @return */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/** * openSession 需要手动关闭session 意思是打开一个新的session * * @return */
	public Session getNewSession() {
		return sessionFactory.openSession();
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

	/** * 根据 id 查询信息 * * @param id * @return */
	@SuppressWarnings("rawtypes")
	public Object load(Class c, String id) {
//		System.out.println("baseDao load");
		Session session = getSession();
		return session.get(c, id);
	}
	
	/** * 根据 id 查询信息 * * @param id * @return */
	@SuppressWarnings("rawtypes")
	public Object load(Class c, int id) {
//		System.out.println("baseDao load");
		Session session = getSession();
		return session.get(c, id);
	}

	/** * 获取所有信息 * * @param c * * @return */

	public List getAllList(Class c) {
		String hql = "from " + c.getName();
		Session session = getSession();
		return session.createQuery(hql).list();

	}

	/** * 获取总数量 * * @param c * @return */

	public Long getTotalCount(Class c) {
		Session session = getNewSession();
		String hql = "select count(*) from " + c.getName();
		Long count = (Long) session.createQuery(hql).uniqueResult();
		session.close();
		return count != null ? count.longValue() : 0;
	}

	/** * 保存 * * @param bean * */
	public void save(Object bean) {
		try {
			Session session = getNewSession();
			session.save(bean);
			session.flush();
			session.clear();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** * 更新 * * @param bean * */
	public void update(Object bean) {
		Session session = getNewSession();
		session.update(bean);
		session.flush();
		session.clear();
		session.close();
	}

	/** * 删除 * * @param bean * */
	public void delete(Object bean) {

		Session session = getNewSession();
		session.delete(bean);
		session.flush();
		session.clear();
		session.close();
	}

	/** * 根据ID删除 * * @param c 类 * * @param id ID * */
	@SuppressWarnings({ "rawtypes" })
	public void delete(Class c, String id) {
		Session session = getNewSession();
		System.out.println("baseDao"+id);
		Object obj = session.get(c, id);
		session.delete(obj);
		session.beginTransaction().commit();
		flush();
		clear();
	}
	
	/** * 根据ID删除 * * @param c 类 * * @param id ID * */
	@SuppressWarnings({ "rawtypes" })
	public void delete(Class c, int id) {
		Session session = getNewSession();
		Object obj = session.get(c,id);
		session.delete(obj);
		flush();
		clear();
	}

	/** * 批量删除 * * @param c 类 * * @param ids ID 集合 * */
	@SuppressWarnings({ "rawtypes" })
	public void delete(Class c, String[] ids) {
		for (String id : ids) {
			Object obj = getSession().get(c, id);
			if (obj != null) {
				getSession().delete(obj);
			}
		}
	}

	@SuppressWarnings({ "rawtypes" })
	public List getSearch(Class c, String column, String con) {
		// TODO Auto-generated method stub
		String hql = "from " + c.getName()+" table where table."+column+"='"+con+"'";
		Session session = getSession();
		return session.createQuery(hql).list();
	}
}
