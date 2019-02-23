package familySearchModel.extensibleData.hypermediaEnabledData;


import familySearchModel.Qualifier;
import familySearchModel.Tag;
import familySearchModel.extensibleData.Attribution;

/**
 * An attributable reference to a description of a source.
 */
public class SourceReference extends HypermediaEnabledData {
    private Attribution attribution;    // The attribution metadata for this source reference.
    private String description;         // A reference to a description of the source being referenced.
    private String descriptionId;       // Id of the source being referenced.
    private Qualifier[] qualifiers;     // The qualifiers associated with this source reference.

    private Tag[] tags;                 // Tags associated with the source reference. Not mentioned in online documentation.

    public SourceReference(){
        super();
        attribution = null;
        description = null;
        descriptionId = null;
        qualifiers = null;
        tags = null;
    }

    public Attribution getAttribution() {
        return attribution;
    }

    public void setAttribution(Attribution attribution) {
        this.attribution = attribution;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(String descriptionId) {
        this.descriptionId = descriptionId;
    }

    public Qualifier[] getQualifiers() {
        return qualifiers;
    }

    public void setQualifiers(Qualifier[] qualifiers) {
        this.qualifiers = qualifiers;
    }

    public Tag[] getTags() {
        return tags;
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
    }
}
