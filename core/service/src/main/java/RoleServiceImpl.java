import java.util.List;

public class RoleServiceImpl implements RoleService {
    
    private Dao dao;

    public void setDao(Dao dao){
      this.dao = dao;
    }

    public List<Roles> listRoles() {
        return dao.getList("Roles");
    }

    public Roles findById(Long id, String object) {
        return (Roles) dao.findById(id, "Roles");
    }

    // public void addRole(String stringRole) {
    //     Roles newRole = new Roles();
    //     newRole.setRole(stringRole);
    //     roleDaoImpl.addRole(newRole);
    // }

    // public void updateRole(Long id, String urole) {
    //     Roles r = findById(id);
    //     r.setRole(urole);
    //     roleDaoImpl.roleUpdate(r);
    // }

    // public void deleteRole(Long id) {
    //     roleDaoImpl.deleteRole(id);
    // }

}