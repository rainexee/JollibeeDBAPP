package EntityClasses;
import java.util.*;
public class land {

    private int landId;
    private int size;
    private float price;
    private String landProgress;
    private boolean land_sold;
    
    public land(){}
    /**
     * @return the landId
     */
    public int getLandId() {
        return landId;
    }

    /**
     * @param landId the landId to set
     */
    public void setLandId(int landId) {
        this.landId = landId;
    }
    
    /**
     * @return the landProgress
     */
    public String getLandProgress() {
        return landProgress;
    }

    /**
     * @param landProgress the landProgress to set
     */
    public void setLandProgress(String landProgress) {
        this.landProgress = landProgress;
    }

 

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }
    
    /**
     * @return the land_sold
     */
    public Boolean isLand_sold() {
        return land_sold;
    }

    /**
     * @param land_sold the land_sold to set
     */
    public void setLand_sold(boolean land_sold) {
        this.land_sold = land_sold;
    }
}
