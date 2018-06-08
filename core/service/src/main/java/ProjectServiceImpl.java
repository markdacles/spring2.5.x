import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    
    private Dao dao;

    public void setDao(Dao dao){
      this.dao = dao;
    }

    public List<Project> listProject() {
        return dao.getList("Project");
    }

    public Project findById(Long id, String object) {
        return (Project) dao.findById(id, "Project");
    }

    public void addProject(Project p) {
        dao.add(p);
    }

    public void updateProject(Project p) {
        dao.update(p);
    }

    public void deleteProject(Long id, String object) {
        dao.delete(id, "Project");
    }

}