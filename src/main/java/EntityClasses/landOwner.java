package EntityClasses;
import java.time.LocalDate;

public class landOwner {
    private int idNumber;
    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;
    private int landNumber;
    private LocalDate start_date;
    private LocalDate end_date;

    public landOwner(){
    }
    /**
     * @return the idNumber
     */
    public int getOwnerId() {
        return getIdNumber();
    }

    /**
     * @param idNumber the idNumber to set
     */
    public void setOwnerId(int idNumber) {
        this.setIdNumber(idNumber);
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * @return the landNumber
     */
    public int getlandNumber() {
        return landNumber;
    }

    /**
     * @param landNumber the landNumber to set
     */
    public void setlandNumber(int landNumber) {
        this.landNumber = landNumber;
    }

    /**
     * @return the idNumber
     */
    public int getIdNumber() {
        return idNumber;
    }

    /**
     * @param idNumber the idNumber to set
     */
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * @return the start_date
     */
    public LocalDate getStart_date() {
        return start_date;
    }

    /**
     * @param start_date the start_date to set
     */
    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    /**
     * @return the end_date
     */
    public LocalDate getEnd_date() {
        return end_date;
    }

    /**
     * @param end_date the end_date to set
     */
    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }
}
