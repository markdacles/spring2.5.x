import java.util.*;

public class PersonnelService {

    public void addPersonnel(Personnel p);

    public void updatePersonnel(Personnel p);

    public List<Personnel> listPersonnel();

    public void deletePersonnel(Long id);

    public static void showRoles();

	public Personnel findById(Long id);

    public boolean checkPerson(Long id);

}