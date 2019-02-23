package familySearchModel.extensibleData;

import familySearchModel.NameFormInfo;

/**
 * A form of a name.
 */
public class NameForm extends ExtensibleData {
    private String lang;            // The language of the conclusion. See http://www.w3.org/International/articles/language-tags/
    private String fullText;        // The full text of the name form.
    private NamePart[] parts;               // The different parts of the name form.
    private NameFormInfo[] nameFormInfo;    // Information about the name form.

    public NameForm(){
        super();
        lang = null;
        fullText = null;
        parts = null;
        nameFormInfo = null;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public NamePart[] getParts() {
        return parts;
    }

    public void setParts(NamePart[] parts) {
        this.parts = parts;
    }

    public NameFormInfo[] getNameFormInfo() {
        return nameFormInfo;
    }

    public void setNameFormInfo(NameFormInfo[] nameFormInfo) {
        this.nameFormInfo = nameFormInfo;
    }

}
