package familySearchModel;

/**
 * A hypermedia link, used to drive the state of a hypermedia-enabled genealogical data application.
 */
public class Link {
    private int offset;         // The index of the offset of the page, if this link refers to a page of resources.
    private String href;        // The target IRI of the link.
    private String template;    // A URI template per RFC 6570, used to link to a range of URIs, such as for the purpose of linking to a query. A link specifying a template can be formally referred to as a "Templated Link (LT)" per Amundsen, M. (2011). Hypermedia APIs with HTML5 and Node. O'Reilly.
    private String title;       // Human-readable information about the link.
    private String type;        // Metadata about the available media type(s) of the resource being linked to. The value of the "type" attribute is as defined by the HTTP specification, RFC 2616, Section 3.7. Note that this attribute can be considered an "Update Control (CU)" per Amundsen, M. (2011). Hypermedia APIs with HTML5 and Node. O'Reilly.
    private String accept;      // Metadata about the acceptable media type(s) that can be used to update (i.e. change the state of) the resource being linked to. The value of the "accept" attribute is as defined by the HTTP specification, RFC 2616, Section 3.7. Note that this attribute can be considered an "Read Control (CR)" per Amundsen, M. (2011). Hypermedia APIs with HTML5 and Node. O'Reilly.
    private String allow;       // Metadata about the allowable methods that can be used to transition to the resource being linked. The value of the "allow" attribute is as defined by the HTTP specification, RFC 2616, Section 14.7. Note that this attribute can be considered an "Method Control (CM)" per Amundsen, M. (2011). Hypermedia APIs with HTML5 and Node. O'Reilly.
    private String hreflang;    // The language of the resource being linked to. Note that this attribute can be considered an "Update Control (CU)" per Amundsen, M. (2011). Hypermedia APIs with HTML5 and Node. O'Reilly.

    public Link() {
        offset = -1;
        href = null;
        template = null;
        title = null;
        type = null;
        accept = null;
        allow = null;
        hreflang = null;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getAllow() {
        return allow;
    }

    public void setAllow(String allow) {
        this.allow = allow;
    }

    public String getHreflang() {
        return hreflang;
    }

    public void setHreflang(String hreflang) {
        this.hreflang = hreflang;
    }
}