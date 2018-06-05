import java.util.List;
import java.util.stream.*;
import java.util.Set;
import java.util.Comparator;
 
public class PersonnelServiceImpl implements PersonnelService{

    private Dao dao;
    //private static RoleServiceImpl roleServiceImpl;

    public void setDao(Dao dao){
      this.dao = dao;
    }

    // public void setRoleServiceImplImpl(RoleServiceImpl roleServiceImpl){
    //   this.roleServiceImpl = roleServiceImpl;
    // }

    public Personnel findById(Long id, String object) {
        return (Personnel) dao.findById(id, "Personnel");
    }

    public void deletePersonnel(Long id, String object) {
        dao.delete(id, "Personnel");
    }

    public void addPersonnel(Personnel p) {
		  dao.add(p);
    }

    public void updatePersonnel(Personnel p) {
    	dao.update(p);
    }

    public List<Personnel> listPersonnel() {
    	return dao.getList("Personnel");
    }

 //    public void deletePersonnel(Long id) {
 //    	personnelDaoImpl.deletePersonnel(id);
 //    }

 //    public void showRoles() {
	// 	Set<Roles> roleList = roleServiceImpl.findAll();
	// 	roleList.stream().sorted(Comparator.comparing(Roles::getRoleId))
	// 	.forEach(e -> System.out.println(e.getRoleId()+" - "+e.getRole()));
	// }

	// public Personnel findById(Long id) {
 //        Personnel personnel = personnelDaoImpl.findById(id);
 //        return personnel;
 //    }

 //    public boolean checkPerson(Long id) {
 //    	return personnelDaoImpl.checkPerson(id);
 //    }
}