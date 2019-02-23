package familySearchModel;

/**
 * Information about a match.
 */
public class MatchInfo {
    private String collection;          // The collection in which this match was found.
    private boolean addsPerson;         // tells if the match would add a person to the target system
    private boolean addsFact;           // tells if the match would add a vital fact to the target system
    private boolean addsDateOrPlace;    // tells if the match would add a date or place to an existing vital fact
    private String status;              // The way this match has been resolved.

    public MatchInfo(){
        collection = null;
        addsPerson = false;
        addsFact = false;
        addsDateOrPlace = false;
        status = null;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public boolean isAddsPerson() {
        return addsPerson;
    }

    public void setAddsPerson(boolean addsPerson) {
        this.addsPerson = addsPerson;
    }

    public boolean isAddsFact() {
        return addsFact;
    }

    public void setAddsFact(boolean addsFact) {
        this.addsFact = addsFact;
    }

    public boolean isAddsDateOrPlace() {
        return addsDateOrPlace;
    }

    public void setAddsDateOrPlace(boolean addsDateOrPlace) {
        this.addsDateOrPlace = addsDateOrPlace;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
