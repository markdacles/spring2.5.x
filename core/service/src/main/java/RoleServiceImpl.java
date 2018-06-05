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

    public void addRole(Roles r) {
        dao.add(r);
    }

    public void updateRole(Roles r) {
        dao.update(r);
    }

    public void deleteRole(Long id, String object) {
        dao.delete(id, "Roles");
    }

}