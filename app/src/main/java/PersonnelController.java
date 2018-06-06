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

public class PersonnelController extends MultiActionController{
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	private PersonnelService personnelService;
	private RoleService roleService;

	public void setPersonnelService(PersonnelService personnelService) {
		this.personnelService = personnelService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public ModelAndView listPersonnel (HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("personnelIndex");
		List<Personnel> personnelList = personnelService.listPersonnel();
		mav.addObject("personnelList", personnelList);
		mav.addObject("pact", "manp");
		return mav;
	}

	// public ModelAndView addPersonnel (HttpServletRequest request, HttpServletResponse response) {
	// 	ModelAndView mav = new ModelAndView("personnelForm");
	// 	List<Roles> roleList = roleService.listRoles();
	// 	mav.addObject("roleList", roleList);
	// 	mav.addObject("requestStatus", "Add Personnel");
	// 	return mav;
	// }

	// public ModelAndView processPersonnel (HttpServletRequest request, HttpServletResponse response) {

	// 	ModelAndView mav = new ModelAndView("redirect:/listPersonnel");
		
	// 	if ("Update Personnel".equals(request.getParameter("requestStatus"))) {
	// 		Personnel p = personnelService.findById(Long.parseLong(request.getParameter("pid")), "Personnel");
	// 		p.getName().setLname(request.getParameter("lname"));
	// 		p.getName().setFname(request.getParameter("fname"));
	// 		p.getName().setMname(request.getParameter("mname"));
	// 		p.getAddress().setBrgy(request.getParameter("barangay"));
	// 		p.getAddress().setCity(request.getParameter("city"));
	// 		p.setBirthday(java.sql.Date.valueOf(LocalDate.parse(request.getParameter("birthday"), formatter)));
	// 		p.setGwa(Double.parseDouble(request.getParameter("gwa")));
	// 		p.setDateHired(java.sql.Date.valueOf(LocalDate.parse(request.getParameter("date_hired"), formatter)));
	// 		p.getContact().clear();
	// 		p.getRoles().clear();

	// 		String[] cType = request.getParameterValues("contactType");
	// 		String[] cDetails = request.getParameterValues("contactDetails");

	// 		if(cDetails != null){
	// 			for(int i = 0; i < cDetails.length; i++){
	// 				Contact c = new Contact();
	// 				c.setContactType(cType[i]);
	// 				c.setContactDetails(cDetails[i]);
	// 				p.getContact().add(c);
	// 			}
	// 		}

	// 		String[] cRoles = request.getParameterValues("checkedRoles");

	// 		if (cRoles != null) {
	//             for (String id : cRoles) {
	//                Roles role = roleService.findById(Long.parseLong(id), "Roles");
	//                p.getRoles().add(role);
	//             }
	//         }
	//         personnelService.updatePersonnel(p);

	// 	} else if ("Add Personnel".equals(request.getParameter("requestStatus"))) {
	// 		Personnel p = new Personnel();
	// 		Name name = new Name();
	// 		name.setLname(request.getParameter("lname"));
	// 		name.setFname(request.getParameter("fname"));
	// 		name.setMname(request.getParameter("mname"));
	// 		p.setName(name);
	// 		Address address = new Address("",request.getParameter("barangay"),request.getParameter("city"),"");
	// 		p.setAddress(address);
	// 		p.setBirthday(java.sql.Date.valueOf(LocalDate.parse(request.getParameter("birthday"), formatter)));
	// 		p.setGwa(Double.parseDouble(request.getParameter("gwa")));
	// 		p.setDateHired(java.sql.Date.valueOf(LocalDate.parse(request.getParameter("date_hired"), formatter)));
			
	// 		String[] cType = request.getParameterValues("contactType");
	// 		String[] cDetails = request.getParameterValues("contactDetails");

	// 		if(cDetails != null){
	// 			for(int i = 0; i < cDetails.length; i++){
	// 				Contact c = new Contact();
	// 				c.setContactType(cType[i]);
	// 				c.setContactDetails(cDetails[i]);
	// 				p.getContact().add(c);
	// 			}
	// 		}

	// 		String[] cRoles = request.getParameterValues("checkedRoles");

	// 		if (cRoles != null) {
	//             for (String id : cRoles) {
	//                Roles role = roleService.findById(Long.parseLong(id), "Roles");
	//                p.getRoles().add(role);
	//             }
	//         }
	//         personnelService.addPersonnel(p);
	// 	}

	// 	return mav;
	// }

	// public ModelAndView updatePersonnel (HttpServletRequest request, HttpServletResponse response) {
	// 	ModelAndView mav = new ModelAndView("personnelForm");
	// 	Personnel p = personnelService.findById(Long.parseLong(request.getParameter("pid")), "Personnel");
	// 	List<Roles> roleList = roleService.listRoles();
	// 	mav.addObject("roleList", roleList);
	// 	mav.addObject("personnel",p);
	// 	mav.addObject("requestStatus", "Update Personnel");
	// 	mav.addObject("pact", "")
	// 	return mav;
	// }

	public ModelAndView deletePersonnel (HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("redirect:/listPersonnel");
		personnelService.deletePersonnel(Long.parseLong(request.getParameter("pid")), "Personnel");
		return mav;
	}

}