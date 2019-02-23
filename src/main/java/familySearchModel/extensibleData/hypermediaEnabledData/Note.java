package familySearchModel.extensibleData.hypermediaEnabledData;

import familySearchModel.extensibleData.Attribution;

/**
 * A note about a genealogical resource (e.g. conclusion or source).
 */
public class Note extends HypermediaEnabledData {
    private String lang;                // The language of the note. See http://www.w3.org/International/articles/language-tags/
    private String subject;             // The subject of the note. This is a short title describing the contents of the note text.
    private String text;                // The text of the note.
    private Attribution attribution;    // Attribution metadata for a note.

    public Note(){
        super();
        lang = null;
        subject = null;
        text = null;
        attribution = null;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Attribution getAttribution() {
        return attribution;
    }

    public void setAttribution(Attribution attribution) {
        this.attribution = attribution;
    }
}
