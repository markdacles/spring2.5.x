import java.util.List;
import java.util.stream.*;
import java.util.Set;
import java.util.Comparator;
 
public class PersonnelServiceImpl implements PersonnelService{

    private static PersonnelDaoImpl personnelDaoImpl;
    private static RoleServiceImpl roleServiceImpl;

    public void setPersonnelDaoImpl(PersonnelDaoImpl personnelDaoImpl){
      this.personnelDaoImpl = personnelDaoImpl;
    }

    public void setRoleServiceImplImpl(RoleServiceImpl roleServiceImpl){
      this.roleServiceImpl = roleServiceImpl;
    }

    public void addPersonnel(Personnel p) {
		personnelDaoImpl.addPersonnel(p);
    }

    public void updatePersonnel(Personnel p) {
    	personnelDaoImpl.personnelUpdate(p);
    }

    public List<Personnel> listPersonnel() {
    	return personnelDaoImpl.findAll();
    }

    public void deletePersonnel(Long id) {
    	personnelDaoImpl.deletePersonnel(id);
    }

    public void showRoles() {
		Set<Roles> roleList = roleServiceImpl.findAll();
		roleList.stream().sorted(Comparator.comparing(Roles::getRoleId))
		.forEach(e -> System.out.println(e.getRoleId()+" - "+e.getRole()));
	}

	public Personnel findById(Long id) {
        Personnel personnel = personnelDaoImpl.findById(id);
        return personnel;
    }

    public boolean checkPerson(Long id) {
    	return personnelDaoImpl.checkPerson(id);
    }
}