public class ContactDTO {

	private Long contactId;

    private String contactType;

    private String contactDetails;

    public ContactDTO() { }

    public ContactDTO(String contactType, String contactDetails) { 
        this.contactType = contactType;
        this.contactDetails = contactDetails;
    }

	public Long getContactId() { return contactId; }
    public void setContactId(Long cid) { contactId = cid; }  

    public String getContactType() { return contactType; }
    public void setContactType(String ct) { contactType = ct; }  

    public String getContactDetails() { return contactDetails; }
    public void setContactDetails(String cd) { contactDetails = cd; }  
}