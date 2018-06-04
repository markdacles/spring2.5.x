import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import java.util.List;
import java.util.stream.Collectors;

public class DaoImpl implements Dao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
    }

    public Session getCurrentSession() {
      return sessionFactory.getCurrentSession();
    }
	
    public <T> void add(T object) {
    	getCurrentSession().save(object);
    }

  	public Object findById(long id, String object) {
  		Object o = getCurrentSession().get(object, id);
      return o;
    }
  	
  	public <T> void update(T object) {
  		getCurrentSession().update(object);
  	}

  	public <T> void delete(long id, String object) {
      Object o = getCurrentSession().get(object, id);
      if (o != null) {
          getCurrentSession().delete(o);
      }
  	}

  	public List getList(String object) {
      System.out.println("IN DAO");
      return (List<Object>) getCurrentSession().createQuery("from " + object).setCacheable(true).list();
  	}

  	// public List getOrderedList(String object, String order) {
  	// 	Session session = sessionFactory.openSession();
  	// 	List results = null;
  	// 	try {
  	// 		Criteria criteria = session.createCriteria(object);
  	// 		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
  	// 		criteria.addOrder(Order.asc(order));
   //      results = criteria.list();
  	// 	} catch (HibernateException e) {
  	// 		e.printStackTrace(); 
  	// 	}
  	// 	return results;
  	// }
}