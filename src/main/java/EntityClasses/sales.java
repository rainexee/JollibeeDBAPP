package EntityClasses;
import java.time.LocalDate;
public class sales {
    private int salesId;
    private int employeeId;
    private int ownerId;
    private String saleCategory;
    private Integer houseNumber;
    private Integer landId;
    private int transferId;
    private float amountPaid;
    private LocalDate saleDate;
    
    
    public sales(){}

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

    /**
     * @return the ownerId
     */
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * @param ownerId the ownerId to set
     */
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * @return the saleCategory
     */
    public String getSaleCategory() {
        return saleCategory;
    }

    /**
     * @param saleCategory the saleCategory to set
     */
    public void setSaleCategory(String saleCategory) {
        this.saleCategory = saleCategory;
    }

    /**
     * @return the houseNumber
     */
    public Integer getHouseNumber() {
        return houseNumber;
    }

    /**
     * @param houseNumber the houseNumber to set
     */
    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * @return the landId
     */
    public Integer getLandId() {
        return landId;
    }

    /**
     * @param landId the landId to set
     */
    public void setLandId(Integer landId) {
        this.landId = landId;
    }

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
     * @return the amountPaid
     */
    public float getAmountPaid() {
        return amountPaid;
    }

    /**
     * @param amountPaid the amountPaid to set
     */
    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
    }

    /**
     * @return the saleDate
     */
    public LocalDate getSaleDate() {
        return saleDate;
    }

    /**
     * @param saleDate the saleDate to set
     */
    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    
    

}
