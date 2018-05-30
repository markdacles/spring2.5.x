import java.util.*;

public interface PersonnelDao {

	public void addPersonnel(Personnel p);

	public List<Personnel> findAll();

  public Personnel getPersonnel(Long id);

  public void personnelUpdate(Personnel p);

  public void deletePersonnel(Long id);

  public Personnel findById(Long id);

  public boolean checkPerson(Long id);

  public void addContactToPersonnel(Personnel p);

  public void contactUpdate(Personnel p);

  public void removeContact(Personnel p);

}