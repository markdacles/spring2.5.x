import java.util.List;
import java.util.stream.*;
import java.util.Set;
import java.util.Comparator;
 
public class PersonnelServiceImpl implements PersonnelService{

    private Dao dao;

    public void setDao(Dao dao){
      this.dao = dao;
    }

    public Personnel findById(Long id, String object) {
        return (Personnel) dao.findById(id, "Personnel");
    }

    public void deletePersonnel(Long id, String object) {
        dao.delete(id, "Personnel");
    }

    public void addPersonnel(Personnel p) {
		  dao.add(p);
    }

    public void updatePersonnel(Personnel p) {
    	dao.update(p);
    }

    public List<Personnel> listPersonnel() {
    	return dao.getList("Personnel");
    }
}