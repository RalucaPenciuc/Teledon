package teledon.model;

import java.io.Serializable;

public class CazCaritabil implements HasID<String>, Serializable {
    private String ID;
    private double totalSum;

    public CazCaritabil(String ID, double totalSum) {
        this.ID = ID;
        this.totalSum = totalSum;
    }

    public CazCaritabil(String ID) {
        this.ID = ID;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    @Override
    public String toString() {
        return "teledon.model.CazCaritabil{" +
                "ID='" + ID + '\'' +
                ", totalSum=" + totalSum +
                '}';
    }
}
