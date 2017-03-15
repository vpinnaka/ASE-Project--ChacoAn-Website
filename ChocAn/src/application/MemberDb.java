package application;

public class MemberDb {
	private int memid;
    private String firstName;
    private String lastName;
    private String joindate;
    private String streetadd;
    private String city;
    private String state;
    private String status;
    
    public int getMemid() {
        return memid;
    }
    public void setMemid(int memid) {
        this.memid = memid;
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Member [memid=" + memid + ", firstName=" + firstName
                + ", lastName=" + lastName + ", street address=" + streetadd  + ",city=" + city  + ", state=" + state +",joindate=" + joindate  + ", status="
                + status + "]";
    }    

}
