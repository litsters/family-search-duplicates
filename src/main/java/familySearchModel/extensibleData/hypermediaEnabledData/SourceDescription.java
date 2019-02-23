package familySearchModel.extensibleData.hypermediaEnabledData;

import familySearchModel.ResourceReference;
import familySearchModel.textValue.TextValue;
import familySearchModel.extensibleData.Attribution;
import com.google.gson.annotations.JsonAdapter;
import serialization.IdentifiersAdapter;

import java.util.List;
import java.util.Map;

/**
 * Represents a description of a source.
 */
public class SourceDescription extends HypermediaEnabledData {
    private String about;                       // The URI (if applicable) of the actual source.
    private SourceCitation[] citations;         // The bibliographic citations for this source.
    private ResourceReference mediator;         // A reference to the entity that mediates access to the described source.
    private ResourceReference publisher;        // A reference to the entity responsible for making the described source available.
    private SourceReference[] sources;          // References to any sources to which this source is related (usually applicable to sources that are derived from or contained in another source).
    private ResourceReference analysis;         // A reference to the analysis document explaining the analysis that went into this description of the source.
    private SourceReference componentOf;        // A reference to the source that contains this source.
    private TextValue[] titles;                 // A list of titles for this source.
    private Note[] notes;                       // Notes about a source.
    private Attribution attribution;            // The attribution metadata for this source description.
    @JsonAdapter(IdentifiersAdapter.class)
    private List<Map<String, List<String>>> identifiers;   // The list of identifiers for the agent.
    private String rights;                      // The rights for this source.
    private String replacedBy;                  // The URI that this resource has been replaced by.
    private String replaces;                    // The list of resources that this resource replaces.
    private String statuses;                    // The list of status types for the source.

    public SourceDescription(){
        super();
        about = null;
        citations = null;
        mediator = null;
        publisher = null;
        sources = null;
        analysis = null;
        componentOf = null;
        titles = null;
        notes = null;
        attribution = null;
        identifiers = null;
        rights = null;
        replacedBy = null;
        replaces = null;
        statuses = null;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public SourceCitation[] getCitations() {
        return citations;
    }

    public void setCitations(SourceCitation[] citations) {
        this.citations = citations;
    }

    public ResourceReference getMediator() {
        return mediator;
    }

    public void setMediator(ResourceReference mediator) {
        this.mediator = mediator;
    }

    public ResourceReference getPublisher() {
        return publisher;
    }

    public void setPublisher(ResourceReference publisher) {
        this.publisher = publisher;
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

    public SourceReference getComponentOf() {
        return componentOf;
    }

    public void setComponentOf(SourceReference componentOf) {
        this.componentOf = componentOf;
    }

    public TextValue[] getTitles() {
        return titles;
    }

    public void setTitles(TextValue[] titles) {
        this.titles = titles;
    }

    public Note[] getNotes() {
        return notes;
    }

    public void setNotes(Note[] notes) {
        this.notes = notes;
    }

    public Attribution getAttribution() {
        return attribution;
    }

    public void setAttribution(Attribution attribution) {
        this.attribution = attribution;
    }

    public List<Map<String, List<String>>> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<Map<String, List<String>>> identifiers) {
        this.identifiers = identifiers;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public String getReplacedBy() {
        return replacedBy;
    }

    public void setReplacedBy(String replacedBy) {
        this.replacedBy = replacedBy;
    }

    public String getReplaces() {
        return replaces;
    }

    public void setReplaces(String replaces) {
        this.replaces = replaces;
    }

    public String getStatuses() {
        return statuses;
    }

    public void setStatuses(String statuses) {
        this.statuses = statuses;
    }
}
