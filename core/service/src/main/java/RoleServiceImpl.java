import java.util.*;

public class RoleServiceImpl implements RoleService {
    
    private static RoleDao roleDao;

    public Set<Roles> findAll() {
        List<Roles> roleList = roleDao.findAll();
        Set<Roles> roles = new HashSet<Roles>(roleList); 
        return roles;
    }

    public Roles findById(Long id) {
        Roles role = roleDao.findById(id);
        return role;
    }

    public void addRole(String stringRole) {
        Roles newRole = new Roles();
        newRole.setRole(stringRole);
        roleDao.addRole(newRole);
    }

    public void updateRole(Long id, String urole) {
        Roles r = findById(id);
        r.setRole(urole);
        roleDao.roleUpdate(r);
    }

    public void deleteRole(Long id) {
        roleDao.deleteRole(id);
    }

}