package EntityClasses;
import java.time.LocalDate;


public class tenantRent {

    private int tenantId;
    private float tenantDues;
    private LocalDate datePaid;
    private LocalDate dueDate;



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
     * @return the tenantDues
     */
    public float getTenantDues() {
        return tenantDues;
    }

    /**
     * @param tenantDues the tenantDues to set
     */
    public void setTenantDues(float tenantDues) {
        this.tenantDues = tenantDues;
    }

    /**
     * @return the datePaid
     */
    public LocalDate getDatePaid() {
        return datePaid;
    }

    /**
     * @param datePaid the datePaid to set
     */
    public void setDatePaid(LocalDate datePaid) {
        this.datePaid = datePaid;
    }

    /**
     * @return the dueDate
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
