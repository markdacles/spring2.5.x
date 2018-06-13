public class AddressDTO {

    private String brgy;

    private String city;

    public AddressDTO() { }

    public AddressDTO(String brgy, String city) {
        this.brgy = brgy;
        this.city = city;
    }

    public String getBrgy() { return brgy; }
    public void setBrgy(String b) { brgy = b; }  

    public String getCity() { return city; }
    public void setCity(String c) { city = c; }   
    
}