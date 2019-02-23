package familySearchModel.extensibleData.hypermediaEnabledData;

import familySearchModel.ResourceReference;

/**
 * Represents a source citation.
 */
public class SourceCitation extends HypermediaEnabledData {
    private String lang;                        // The language of the citation. See http://www.w3.org/International/articles/language-tags/
    private String value;                       // A rendering (as a string) of a source citation. This rendering should be the most complete rendering available.
    private ResourceReference citationTemplate; // A reference to the citation template for this citation.
    private Object[] fields;                    // The list of citation fields. Online documentation is no longer available.

    public SourceCitation(){
        super();
        lang = null;
        value = null;
        citationTemplate = null;
        fields = null;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ResourceReference getCitationTemplate() {
        return citationTemplate;
    }

    public void setCitationTemplate(ResourceReference citationTemplate) {
        this.citationTemplate = citationTemplate;
    }

    public Object[] getFields() {
        return fields;
    }

    public void setFields(Object[] fields) {
        this.fields = fields;
    }
}
