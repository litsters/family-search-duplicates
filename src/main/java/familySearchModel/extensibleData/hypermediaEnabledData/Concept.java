package familySearchModel.extensibleData.hypermediaEnabledData;

import familySearchModel.ConceptAttribute;

/**
 * A vocabulary concept.
 */
public class Concept extends HypermediaEnabledData {
    private String description;             // Get the vocabulary concept description.
    private String note;                    // Get the vocabulary concept note.
    private String gedcomxUri;              // Get the Gedcomx URI associated with this vocabulary concept.
    private Term[] terms;                   // Get the vocabulary terms associated with this vocabulary concept.
    private ConceptAttribute[] attributes;  // Get the attributes associated with this vocabulary concept.

    public Concept(){
        super();
        description = null;
        note = null;
        gedcomxUri = null;
        terms = null;
        attributes = null;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getGedcomxUri() {
        return gedcomxUri;
    }

    public void setGedcomxUri(String gedcomxUri) {
        this.gedcomxUri = gedcomxUri;
    }

    public Term[] getTerms() {
        return terms;
    }

    public void setTerms(Term[] terms) {
        this.terms = terms;
    }

    public ConceptAttribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(ConceptAttribute[] attributes) {
        this.attributes = attributes;
    }
}
