package familySearchModel.extensibleData.hypermediaEnabledData.conclusion.subject;

import familySearchModel.extensibleData.hypermediaEnabledData.EvidenceReference;
import familySearchModel.extensibleData.hypermediaEnabledData.SourceReference;
import familySearchModel.extensibleData.hypermediaEnabledData.conclusion.Conclusion;
import com.google.gson.annotations.JsonAdapter;
import serialization.IdentifiersAdapter;

import java.util.List;
import java.util.Map;

/**
 * The Subject data type defines the abstract concept of a genealogical subject. A subject is something with a
 * unique and intrinsic identity, e.g., a person, a location on the surface of the earth. We identify that subject
 * in time and space using various supporting conclusions, e.g. for a person: things like name, birth date, age,
 * address, etc. We aggregate these supporting conclusions to form an apparently-unique identity by which we can
 * distinguish our subject from all other possible subjects.
 */
public class Subject extends Conclusion {
    private boolean extracted;                // Whether this subject has been identified as "extracted", meaning it captures information extracted from a single source.
    private EvidenceReference[] evidence;     // References to the evidence being referenced for this subject.
    private SourceReference[] media;          // References to multimedia resources associated with this subject.
    @JsonAdapter(IdentifiersAdapter.class)
    private List<Map<String, List<String>>> identifiers;

    public Subject(){
        super();
        extracted = false;
        evidence = null;
        media = null;
        identifiers = null;
    }

    public boolean isExtracted() {
        return extracted;
    }

    public void setExtracted(boolean extracted) {
        this.extracted = extracted;
    }

    public EvidenceReference[] getEvidence() {
        return evidence;
    }

    public void setEvidence(EvidenceReference[] evidence) {
        this.evidence = evidence;
    }

    public SourceReference[] getMedia() {
        return media;
    }

    public void setMedia(SourceReference[] media) {
        this.media = media;
    }

    public List<Map<String, List<String>>> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<Map<String, List<String>>> identifiers) {
        this.identifiers = identifiers;
    }
}
