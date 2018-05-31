import java.time.*;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PersonnelDaoImpl implements PersonnelDao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
    }

    public Session getCurrentSession() {
      return sessionFactory.getCurrentSession();
    }

  	public void addPersonnel(Personnel p) {
  		getCurrentSession().save(p);
  	}

  	public List<Personnel> findAll() {
    return (List<Personnel>) getCurrentSession().createQuery("from Personnel").setCacheable(true).list();
  	}

    public Personnel getPersonnel(Long id) {
      return (Personnel) getCurrentSession().get(Personnel.class, id);
    }

    public void personnelUpdate(Personnel p) {
      getCurrentSession().update(p);
    }

    public void deletePersonnel(Long id) {
      Personnel p = (Personnel) getCurrentSession().get(Personnel.class, id);
      getCurrentSession().delete(p);
    }

    public Personnel findById(Long id) {
      return (Personnel) HibernateUtil.getCurrentSession().get(Personnel.class, id);
    }

    public boolean checkPerson(Long id) {
      Personnel personnel = (Personnel) getCurrentSession().get(Personnel.class, id);
      if(personnel == null) {
        return false;
      } else {
        return true;
      }
    }

    public void addContactToPersonnel(Personnel p) {
      getCurrentSession().update(p);
    }

    public void contactUpdate(Personnel p) {
      getCurrentSession().update(p);
    }

    public void removeContact(Personnel p) {
      getCurrentSession().update(p);
    }
}