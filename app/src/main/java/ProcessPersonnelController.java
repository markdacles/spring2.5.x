import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;	
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcessPersonnelController extends SimpleFormController{

	private PersonnelService personnelService;
	private RoleService roleService;

	public void setPersonnelService(PersonnelService personnelService) {
		this.personnelService = personnelService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        // to actually be able to convert Multipart instance to byte[]
        // we have to register a custom editor
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
            dateFormat, true));
        // now Spring knows how to handle multipart object and convert them
    }

	public ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors) throws Exception {
		ModelAndView mav = new ModelAndView(getFormView());
        mav.addAllObjects(errors.getModel());
		mav.addObject("roleList", roleService.listRoles());
		if("add".equals(request.getParameter("action"))){
			mav.addObject("pact", "add");
			mav.addObject("pacts", "add");
		} else if("update".equals(request.getParameter("action"))){
			Personnel p = personnelService.findById(Long.parseLong(request.getParameter("pid")), "Personnel");
			String url = "update&pid=" + request.getParameter("pid");
			List<Roles> roleList = roleService.listRoles();
			mav.addObject("roleList", roleList);
			mav.addObject("personnel",p);
			mav.addObject("pact", "updateform");
			mav.addObject("pacts", url);
		}
		return mav;
	}

	public ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception { 
		Personnel personnel = (Personnel) command;
		if(errors.hasErrors()) {
			System.out.println("ERRORS FOUND!!!!");
		    ModelAndView mav = new ModelAndView(getFormView());
		    mav.addAllObjects(errors.getModel());
		    mav.addObject("roleList", roleService.listRoles());
		    if("add".equals(request.getParameter("addOrUpdate"))) {
		    	mav.addObject("pact", "add");
				mav.addObject("pacts", "add");
		    } else if ("updateform".equals(request.getParameter("addOrUpdate"))) {
		    	String url = "update&pid=" + request.getParameter("pid");
		    	mav.addObject("pact", "updateform");
				mav.addObject("pacts", url);
		    }
		    
		    return mav;

		} else {
			System.out.println("NO ERRORS FOUND!!!!");
			return onSubmit(request,response,command,errors);		
		}

	}

	@Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {
        
        Personnel p = (Personnel) command;

		String[] cType = request.getParameterValues("contactType");
		String[] cDetails = request.getParameterValues("contactDetails");

		if(cDetails != null){
			for(int i = 0; i < cDetails.length; i++){
				Contact c = new Contact();
				c.setContactType(cType[i]);
				c.setContactDetails(cDetails[i]);
				p.getContact().add(c);
			}
		}

		String[] cRoles = request.getParameterValues("checkedRoles");

		if (cRoles != null) {
            for (String id : cRoles) {
               Roles role = roleService.findById(Long.parseLong(id), "Roles");
               p.getRoles().add(role);
            }
        }
        if("add".equals(request.getParameter("addOrUpdate"))) {
        	personnelService.addPersonnel(p);
        } else if("updateform".equals(request.getParameter("addOrUpdate"))) {
        	personnelService.updatePersonnel(p);
        }
        
		return new ModelAndView("redirect:/listPersonnel");
    }
}