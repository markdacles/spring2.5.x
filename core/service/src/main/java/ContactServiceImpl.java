import java.util.*;

public class ContactServiceImpl implements ContactService {

    private static PersonnelDaoImpl personnelDaoImpl;

    public void setPersonnelDaoImpl(PersonnelDaoImpl personnelDaoImpl){
      this.personnelDaoImpl = personnelDaoImpl;
    }

    public void addContactToPersonnel(Personnel p) {
        personnelDaoImpl.addContactToPersonnel(p);
    }

    public void updateContact(Personnel p) {
        personnelDaoImpl.contactUpdate(p);
    }

    public void removeContact(Long id, Long cid) {
        Personnel p = personnelDaoImpl.getPersonnel(id);
        for(Contact c : p.getContact()) {
            if(c.getContactId() == cid) {
                p.getContact().remove(c);
                break;
            }
        }
        personnelDaoImpl.removeContact(p);
    }

    public boolean doesContactExist(Long id) {
        List<Personnel> personnelList =  personnelDaoImpl.findAll();
        for(Personnel p : personnelList) {
            for(Contact c : p.getContact()) {
                if(c.getContactId() == id) {
                    return true;
                }
            }
        }
        return false;
    }
}