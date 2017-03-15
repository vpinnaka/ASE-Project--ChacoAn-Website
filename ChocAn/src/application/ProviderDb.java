package application;

public class ProviderDb {
	private int proid;
    private String firstName;
    private String lastName;
    private String joindate;
    private String streetadd;
    private String city;
    private String state;
    private String type;
    private String status;
    
    public int getproid() {
        return proid;
    }
    public void setproid(int proid) {
        this.proid = proid;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getJoinDate() {
        return joindate;
    }
    public void setJoinDate(String joindate) {
        this.joindate = joindate;
    }
    public String getStreetAdd() {
        return streetadd;
    }
    public void setStreetAdd(String streetadd) {
        this.streetadd = streetadd;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Provider [proid=" + proid + ", firstName=" + firstName
                + ", lastName=" + lastName + ", street address=" + streetadd  + ",city=" + city  + ", state=" + state +",joindate=" + joindate  + ",type=" + type  + ", status="
                + status + "]";
    }    

}
