import java.util.List;
import java.util.stream.*;
 
public class PersonnelServiceImpl implements PersonnelService{

    private static PersonnelDao personnelDao;
    private static RoleService roleService;

    public void addPersonnel(Personnel p) {
		personnelDao.addPersonnel(p);
    }

    public void updatePersonnel(Personnel p) {
    	personnelDao.personnelUpdate(p);
    }

    public List<Personnel> listPersonnel() {
    	return personnelDao.findAll();
    }

    public void deletePersonnel(Long id) {
    	personnelDao.deletePersonnel(id);
    }

    public static void showRoles() {
		Set<Roles> roleList = roleService.findAll();
		roleList.stream().sorted(Comparator.comparing(Roles::getRoleId))
		.forEach(e -> System.out.println(e.getRoleId()+" - "+e.getRole()));
	}

	public Personnel findById(Long id) {
        Personnel personnel = personnelDao.findById(id);
        return personnel;
    }

    public boolean checkPerson(Long id) {
    	return personnelDao.checkPerson(id);
    }
}