package familySearchModel.textValue;

/**
 * An element representing a text value that may be in a specific language.
 */
public class TextValue {
    private String lang;    // The language of the text value. See http://www.w3.org/International/articles/language-tags/
    private String value;   // The text value.

    public TextValue(){
        lang = null;
        value = null;
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

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("{\n");
        builder.append("     lang: " + lang + "\n");
        builder.append("     value: " + value + "\n");
        builder.append("}\n");

        return builder.toString();
    }
}
