import java.util.List;
import java.util.Set;

public interface RoleService {
    
    public List<Roles> listRoles();

    public Roles findById(Long id, String object);

    // public void addRole(String stringRole);

    // public void updateRole(Long id, String urole);

    // public void deleteRole(Long id);

}