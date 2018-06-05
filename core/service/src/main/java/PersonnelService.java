import java.util.*;

public interface PersonnelService {

    public void addPersonnel(Personnel p);

    public void updatePersonnel(Personnel p);

    public List<Personnel> listPersonnel();

 	public void deletePersonnel(Long id, String object);

 //    public void showRoles();

	public Personnel findById(Long id, String object);

 //    public boolean checkPerson(Long id);

}