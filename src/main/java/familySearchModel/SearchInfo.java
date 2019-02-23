package familySearchModel;

/**
 * Information about a search.
 */
public class SearchInfo {
    private int totalHits;  // The total number of hits.
    private int closeHits;  // The number of close hits.

    public SearchInfo(){
        totalHits = -1;
        closeHits = -1;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public int getCloseHits() {
        return closeHits;
    }

    public void setCloseHits(int closeHits) {
        this.closeHits = closeHits;
    }
}
