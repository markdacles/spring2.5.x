import java.time.*;
import java.util.*;


public class ProjectDTO {
	
	private Long projectId;

	private String projectName;

    private Date startDate;

    private Date endDate;

	private Set<PersonnelDTO> personnel = new HashSet<PersonnelDTO>();
	
	public ProjectDTO() { }

	public Long getProjectId() { return projectId; }
	public void setProjectId(Long p) { projectId = p; }

	public String getProjectName() { return projectName; }
	public void setProjectName(String p) { projectName = p; }

	public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }  

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }  

	public Set<PersonnelDTO> getPersonnel() { return personnel; }
	public void setPersonnel(Set<PersonnelDTO> p) { personnel = p; }
	
}