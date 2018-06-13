import java.util.Set;
import java.util.*;

public class PersonnelDTO {
 
    private Long id;

    private NameDTO name;

    private AddressDTO address;

    private Date birthday;

    private Double gwa;

    private Date dateHired;

    private Set<ContactDTO> contact  = new HashSet<ContactDTO>();

    private Set<RolesDTO> roles  = new HashSet<RolesDTO>();

    public PersonnelDTO() { }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public NameDTO getName() { return name; }
    public void setName(NameDTO name) { this.name = name; }

    public AddressDTO getAddress() { return address; }
    public void setAddress(AddressDTO address) { this.address = address; }

    public Date getBirthday() { return birthday; }
    public void setBirthday(Date birthday) { this.birthday = birthday; }    

    public Double getGwa() { return gwa; }
    public void setGwa(Double gwa) { this.gwa = gwa; }

    public Date getDateHired() { return dateHired; }
    public void setDateHired(Date dateHired) { this.dateHired = dateHired; }  

    public Set<ContactDTO> getContact() { return contact; }
    public void setContact(Set<ContactDTO> contact) { this.contact = contact; }

    public Set<RolesDTO> getRoles() { return roles; }
    public void setRoles(Set<RolesDTO> rroles) { roles = rroles; }
}