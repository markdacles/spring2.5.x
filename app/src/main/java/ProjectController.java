import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;	

public class ProjectController extends MultiActionController{
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	private ProjectService projectService;
	private PersonnelService personnelService;

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public void setPersonnelService(PersonnelService personnelService) {
		this.personnelService = personnelService;
	}

	public ModelAndView listProject (HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("projectIndex");
		List<Project> projectList = projectService.listProject();
		mav.addObject("projectList", projectList);
		mav.addObject("pact", "manj");
		return mav;
	}

	public ModelAndView deleteProject (HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("redirect:/listProject");
		projectService.deleteProject(Long.parseLong(request.getParameter("pid")), "Personnel");
		return mav;
	}

}