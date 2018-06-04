import javax.persistence.*;
import java.util.Objects;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
	private Long contactId;
	
    @Column(name = "contact_type")
    private String contactType;
	
    @Column(name = "contact_details")
    private String contactDetails;

    public Contact() { }

    public Contact(String contactType, String contactDetails) { 
        this.contactType = contactType;
        this.contactDetails = contactDetails;
    }

	public Long getContactId() { return contactId; }
    public void setContactId(Long cid) { contactId = cid; }  

    public String getContactType() { return contactType; }
    public void setContactType(String ct) { contactType = ct; }  

    public String getContactDetails() { return contactDetails; }
    public void setContactDetails(String cd) { contactDetails = cd; }  

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Contact))
            return false;
        if (obj == this)
            return true;
        return this.getContactId() == ((Contact) obj).getContactId();
    }

    public int hashCode() {
        return Objects.hash(contactId);
    }
}