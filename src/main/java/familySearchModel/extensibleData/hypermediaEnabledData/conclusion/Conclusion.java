package familySearchModel.extensibleData.hypermediaEnabledData.conclusion;


import familySearchModel.ResourceReference;
import familySearchModel.extensibleData.Attribution;
import familySearchModel.extensibleData.hypermediaEnabledData.HypermediaEnabledData;
import familySearchModel.extensibleData.hypermediaEnabledData.Note;
import familySearchModel.extensibleData.hypermediaEnabledData.SourceReference;

/**
 * A genealogical conclusion.
 */
public class Conclusion extends HypermediaEnabledData {
    private String sortKey;             // A sort key in relation to other facts for display purposes.
    private Attribution attribution;    // Attribution metadata for a conclusion.
    private SourceReference[] sources;  // The source references for a conclusion.
    private ResourceReference analysis; // A reference to the analysis document explaining the analysis that went into this conclusion.
    private Note[] notes;               // Notes about a person.

    public Conclusion(){
        super();
        sortKey = null;
        attribution = null;
        sources = null;
        analysis = null;
        notes = null;
    }

    public String getSortKey() {
        return sortKey;
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    public Attribution getAttribution() {
        return attribution;
    }

    public void setAttribution(Attribution attribution) {
        this.attribution = attribution;
    }

    public SourceReference[] getSources() {
        return sources;
    }

    public void setSources(SourceReference[] sources) {
        this.sources = sources;
    }

    public ResourceReference getAnalysis() {
        return analysis;
    }

    public void setAnalysis(ResourceReference analysis) {
        this.analysis = analysis;
    }

    public Note[] getNotes() {
        return notes;
    }

    public void setNotes(Note[] notes) {
        this.notes = notes;
    }
}
