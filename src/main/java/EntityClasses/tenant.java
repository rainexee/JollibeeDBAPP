package EntityClasses;
import java.time.LocalDate;
public class tenant {

    private int tenantId;
    private String tenantLastName;
    private String tenantFirstName;
    private String tenantContactNumber;
    private String tenantEmail;
    private int tenantHouseNumber;
    private LocalDate occupancyDate;
    private LocalDate contractExpiration;

    public tenant(){}
    
    
    /**
     * @return the tenantId
     */
    public int getTenantId() {
        return tenantId;
    }

    /**
     * @param tenantId the tenantId to set
     */
    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * @return the tenantLastName
     */
    public String getTenantLastName() {
        return tenantLastName;
    }

    /**
     * @param tenantLastName the tenantLastName to set
     */
    public void setTenantLastName(String tenantLastName) {
        this.tenantLastName = tenantLastName;
    }

    /**
     * @return the tenantFirstName
     */
    public String getTenantFirstName() {
        return tenantFirstName;
    }

    /**
     * @param tenantFirstName the tenantFirstName to set
     */
    public void setTenantFirstName(String tenantFirstName) {
        this.tenantFirstName = tenantFirstName;
    }

    /**
     * @return the tenantContactNumber
     */
    public String getTenantContactNumber() {
        return tenantContactNumber;
    }

    /**
     * @param tenantContactNumber the tenantContactNumber to set
     */
    public void setTenantContactNumber(String tenantContactNumber) {
        this.tenantContactNumber = tenantContactNumber;
    }

    /**
     * @return the tenantEmail
     */
    public String getTenantEmail() {
        return tenantEmail;
    }

    /**
     * @param tenantEmail the tenantEmail to set
     */
    public void setTenantEmail(String tenantEmail) {
        this.tenantEmail = tenantEmail;
    }

    /**
     * @return the tenantHouseNumber
     */
    public int getTenantHouseNumber() {
        return tenantHouseNumber;
    }

    /**
     * @param tenantHouseNumber the tenantHouseNumber to set
     */
    public void setTenantHouseNumber(int tenantHouseNumber) {
        this.tenantHouseNumber = tenantHouseNumber;
    }


    /**
     * @return the occupancyDate
     */
    public LocalDate getOccupancyDate() {
        return occupancyDate;
    }

    /**
     * @param occupancyDate the occupancyDate to set
     */
    public void setOccupancyDate(LocalDate occupancyDate) {
        this.occupancyDate = occupancyDate;
    }

    /**
     * @return the contractExpiration
     */
    public LocalDate getContractExpiration() {
        return contractExpiration;
    }

    /**
     * @param contractExpiration the contractExpiration to set
     */
    public void setContractExpiration(LocalDate contractExpiration) {
        this.contractExpiration = contractExpiration;
    }
    
}
