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
		return mav;
	}

	public ModelAndView addPersonnel (HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("personnelForm");
		List<Roles> roleList = roleService.listRoles();
		mav.addObject("roleList", roleList);
		return mav;
	}

	public ModelAndView processPersonnel (HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("redirect:/listPersonnel");
		
		Personnel p = new Personnel();
		Name name = new Name(request.getParameter("lname"),request.getParameter("fname"),request.getParameter("mname"),"","");
		p.setName(name);
		Address address = new Address("",request.getParameter("barangay"),request.getParameter("city"),"");
		p.setAddress(address);
		p.setBirthday(java.sql.Date.valueOf(LocalDate.parse(request.getParameter("birthday"), formatter)));
		p.setGwa(Double.parseDouble(request.getParameter("gwa")));
		p.setDateHired(java.sql.Date.valueOf(LocalDate.parse(request.getParameter("date_hired"), formatter)));
		
		Set<Contact> contacts = new HashSet<Contact>();
		String[] cType = request.getParameterValues("contactType");
		String[] cDetails = request.getParameterValues("contactDetails");

		if(cDetails != null){
			for(int i = 0 ; i < cDetails.length; i++){
				Contact c = new Contact();
				c.setContactDetails(cDetails[i]);
				c.setContactType(cType[i]);
				contacts.add(c);
			}
			//Collections.sort(contacts, (Contact a1, Contact a2) -> a1.getContactType().compareTo(a2.getContactType()) );
			p.setContact(contacts);
		}

		Set<Roles> roles = new HashSet<Roles>();
		String[] cRoles = request.getParameterValues("checkedRoles");

		if (cRoles != null) {
            for (String id : cRoles) {
               Roles role = roleService.findById(Long.parseLong(id), "Roles");
               p.getRoles().add(role);
            }
        }

        personnelService.addPersonnel(p);

		return mav;
	}

}