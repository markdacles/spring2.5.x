import java.time.*;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RoleDaoImpl implements RoleDao {

  private SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public Session getCurrentSession() {
      return sessionFactory.getCurrentSession();
  }

  public List<Roles> findAll() {
    return (List<Roles>) getCurrentSession().createQuery("from Roles").setCacheable(true).list();
  }

  public void addRole(Roles r) {
  	getCurrentSession().save(r);
  }

  public void roleUpdate(Roles r) {
  	getCurrentSession().update(r);
  }

  public void deleteRole(Long id) {
  	Roles role = (Roles) getCurrentSession().get(Roles.class, id);
  	getCurrentSession().delete(role);
  }

  public Roles findById(Long id) {
    return (Roles) HibernateUtil.getCurrentSession().get(Roles.class, id);
  }

}