import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class FileUploadController extends SimpleFormController {
	private PersonnelService personnelService;

	public void setPersonnelService(PersonnelService personnelService) {
		this.personnelService = personnelService;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception{

	    FileUpload f = (FileUpload)command;
        MultipartFile file = f.getMultipartFile();

        FileParser parser = new FileParser();
		
		if(file != null){
			Personnel p = parser.parsePersonnel(file);
			personnelService.addPersonnel(p);
		}
		
		return new ModelAndView(getFormView());
		
	}


}