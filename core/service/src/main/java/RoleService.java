import java.util.List;
import java.util.Set;

public interface RoleService {
    
    public Set<Roles> findAll();

    public Roles findById(Long id);

    public void addRole(String stringRole);

    public void updateRole(Long id, String urole);

    public void deleteRole(Long id);

}