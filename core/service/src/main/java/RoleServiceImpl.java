import java.util.*;

public class RoleServiceImpl implements RoleService {
    
    private static RoleDaoImpl roleDaoImpl;

    public void setRoleDaoImpl(RoleDaoImpl roleDaoImpl){
      this.roleDaoImpl = roleDaoImpl;
    }

    public Set<Roles> findAll() {
    List<Roles> roleList = roleDaoImpl.findAll();
       return new HashSet<Roles>(roleList); 
    }

    public Roles findById(Long id) {
        return roleDaoImpl.findById(id);
    }

    public void addRole(String stringRole) {
        Roles newRole = new Roles();
        newRole.setRole(stringRole);
        roleDaoImpl.addRole(newRole);
    }

    public void updateRole(Long id, String urole) {
        Roles r = findById(id);
        r.setRole(urole);
        roleDaoImpl.roleUpdate(r);
    }

    public void deleteRole(Long id) {
        roleDaoImpl.deleteRole(id);
    }

}