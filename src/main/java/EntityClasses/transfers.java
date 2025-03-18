package EntityClasses;
import java.time.LocalDate;
public class transfers {
    private int transferId;
    private int oldOwnerID;
    private String oldHouseOwnerLastName; 
    private String oldHouseOwnerFirstName; 
    private String newHouseOwnerLastName;
    private String newHouseOwnerFirstName;
    private int employeeId;
    private int salesId;
    private int houseNumber;
    
    

    public transfers(){}

    /**
     * @return the transferId
     */
    public int getTransferId() {
        return transferId;
    }

    /**
     * @param transferId the transferId to set
     */
    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    /**
     * @return the oldHouseOwnerLastName
     */
    public String getOldHouseOwnerLastName() {
        return oldHouseOwnerLastName;
    }

    /**
     * @param oldHouseOwnerLastName the oldHouseOwnerLastName to set
     */
    public void setOldHouseOwnerLastName(String oldHouseOwnerLastName) {
        this.oldHouseOwnerLastName = oldHouseOwnerLastName;
    }

    /**
     * @return the oldHouseOwnerFirstName
     */
    public String getOldHouseOwnerFirstName() {
        return oldHouseOwnerFirstName;
    }

    /**
     * @param oldHouseOwnerFirstName the oldHouseOwnerFirstName to set
     */
    public void setOldHouseOwnerFirstName(String oldHouseOwnerFirstName) {
        this.oldHouseOwnerFirstName = oldHouseOwnerFirstName;
    }

    /**
     * @return the newHouseOwnerLastName
     */
    public String getNewHouseOwnerLastName() {
        return newHouseOwnerLastName;
    }

    /**
     * @param newHouseOwnerLastName the newHouseOwnerLastName to set
     */
    public void setNewHouseOwnerLastName(String newHouseOwnerLastName) {
        this.newHouseOwnerLastName = newHouseOwnerLastName;
    }

    /**
     * @return the newHouseOwnerFirstName
     */
    public String getNewHouseOwnerFirstName() {
        return newHouseOwnerFirstName;
    }

    /**
     * @param newHouseOwnerFirstName the newHouseOwnerFirstName to set
     */
    public void setNewHouseOwnerFirstName(String newHouseOwnerFirstName) {
        this.newHouseOwnerFirstName = newHouseOwnerFirstName;
    }

    /**
     * @return the salesId
     */
    public int getSalesId() {
        return salesId;
    }

    /**
     * @param salesId the salesId to set
     */
    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    /**
     * @return the houseNumber
     */
    public int getHouseNumber() {
        return houseNumber;
    }

    /**
     * @param houseNumber the houseNumber to set
     */
    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * @return the oldOwnerID
     */
    public int getOldOwnerID() {
        return oldOwnerID;
    }

    /**
     * @param oldOwnerID the oldOwnerID to set
     */
    public void setOldOwnerID(int oldOwnerID) {
        this.oldOwnerID = oldOwnerID;
    }

    /**
     * @return the employeeId
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    
    
}
