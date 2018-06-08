import org.springframework.web.multipart.MultipartFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileParser{

	RoleService roleService;

	public void setRoleManagerImpl(RoleService roleService){
		this.roleService = roleService;
	}

	public Personnel parsePersonnel(MultipartFile file) throws Exception{

		Personnel p = new Personnel();

		String[] tokenize;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		InputStream is = file.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		String fileRead = br.readLine();

		while (fileRead != null) {

			tokenize = fileRead.split(",");
			
			for(String str : tokenize) {
				p.getName().setLname(str);
				p.getName().setFname(str);
				p.getName().setMname(str);
				p.getAddress().setBrgy(str);
				p.getAddress().setCity(str);
				p.setBirthday(formatter.parse(str));
				p.setGwa(Double.parseDouble(str));
				p.setDateHired(formatter.parse(str));
			}
			
			fileRead = br.readLine();

			tokenize = fileRead.split(",");

			for(String str : tokenize) {
				Contact c = new Contact();
				c.setContactType("Landline");
				c.setContactDetails(str);
				p.getContact().add(c);
			}

			fileRead = br.readLine();

			tokenize = fileRead.split(",");

			for(String str : tokenize) {
				Contact c = new Contact();
				c.setContactType("Mobile");
				c.setContactDetails(str);
				p.getContact().add(c);
			}

			fileRead = br.readLine();

			tokenize = fileRead.split(",");

			for(String str : tokenize) {
				Contact c = new Contact();
				c.setContactType("Email");
				c.setContactDetails(str);
				p.getContact().add(c);
			}

			fileRead = br.readLine();

			tokenize = fileRead.split(",");

			for(String str : tokenize) {
				for(Roles r : roleService.listRoles()) {
					if(r.getRole() == str) {
						p.getRoles().add(r);
					}
				}
			}
			
		}

		br.close();

		return p;

	}
}