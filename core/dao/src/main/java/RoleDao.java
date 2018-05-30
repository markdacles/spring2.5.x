import java.util.List;

public interface RoleDao {

  public Set<Roles> findAll();

	public void addRole(Roles r);

	public void roleUpdate(Roles r);

	public void deleteRole(Long id);

  public Roles findById(Long id);

}