package EntityClasses;

import java.time.LocalDate;


public class house {

    private int houseNumber;
    private int houseSize;
    private String description;
    private LocalDate dateStarted;
    private LocalDate dateOfCompletion;
    private float housePrice;
    private String houseAddress;
    private int land_landId;
    private int employee_employeeId;
    

    public house(){}
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
     * @return the houseSize
     */
    public int getHouseSize() {
        return houseSize;
    }

    /**
     * @param houseSize the houseSize to set
     */
    public void setHouseSize(int houseSize) {
        this.houseSize = houseSize;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the dateStarted
     */
    public LocalDate getDateStarted() {
        return dateStarted;
    }

    /**
     * @param dateStarted the dateStarted to set
     */
    public void setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
    }

    /**
     * @return the dateOfCompletion
     */
    public LocalDate getDateOfCompletion() {
        return dateOfCompletion;
    }

    /**
     * @param dateOfCompletion the dateOfCompletion to set
     */
    public void setDateOfCompletion(LocalDate dateOfCompletion) {
        this.dateOfCompletion = dateOfCompletion;
    }
    

    /**
     * @return the employee_employeeId
     */
    public int getEmployee_employeeId() {
        return employee_employeeId;
    }

    /**
     * @param employee_employeeId the employee_employeeId to set
     */
    public void setEmployee_employeeId(int employee_employeeId) {
        this.employee_employeeId = employee_employeeId;
    }

    /**
     * @return the land_landId
     */
    public int getLand_landId() {
        return land_landId;
    }

    /**
     * @param land_landId the land_landId to set
     */
    public void setLand_landId(int land_landId) {
        this.land_landId = land_landId;
    }

    /**
     * @return the housePrice
     */
    public float getHousePrice() {
        return housePrice;
    }

    /**
     * @param housePrice the housePrice to set
     */
    public void setHousePrice(float housePrice) {
        this.housePrice = housePrice;
    }

    /**
     * @return the houseAddress
     */
    public String getHouseAddress() {
        return houseAddress;
    }

    /**
     * @param houseAddress the houseAddress to set
     */
    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    
}
