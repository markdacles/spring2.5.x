import java.util.Set;
import java.util.Objects;
import java.lang.*;

public class RolesDTO {

	private Long roleId;

	private String role;

	private Set<PersonnelDTO> personnel;
	
	public RolesDTO() { }

	public Long getRoleId() { return roleId; }
	public void setRoleId(Long r) { roleId = r; }

	public String getRole() { return role; }
	public void setRole(String r) { role = r; }

	public Set<PersonnelDTO> getPersonnel() { return personnel; }
	public void setPersonnel(Set<PersonnelDTO> p) { personnel = p; }
}