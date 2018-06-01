import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonnelController extends MultiActionController{
	
	PersonnelServiceImpl psi;

	public void setPSI(PersonnelServiceImpl psi){
		this.psi = psi;
	}

	public ModelAndView handleRequestInternal (HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("personnelIndex");
	}

	public ModelAndView managePersonnel (HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("personnelIndex");
		return mav;
	}
}