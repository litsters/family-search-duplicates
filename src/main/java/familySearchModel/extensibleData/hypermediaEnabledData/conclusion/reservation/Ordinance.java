package familySearchModel.extensibleData.hypermediaEnabledData.conclusion.reservation;

import familySearchModel.extensibleData.Date;

/**
 * An ordinance reservation.
 */
public class Ordinance extends Reservation {
    private boolean living;     // Whether this ordinance was performed during the life of the person.
    private Date date;          // The date of this ordinance.
    private String templeCode;  // The code for the temple at which the ordinance was performed.

    public Ordinance(){
        super();
        living = false;
        date = null;
        templeCode = null;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTempleCode() {
        return templeCode;
    }

    public void setTempleCode(String templeCode) {
        this.templeCode = templeCode;
    }
}
