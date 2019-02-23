package familySearchModel.extensibleData.hypermediaEnabledData;


import familySearchModel.Link;
import familySearchModel.extensibleData.ExtensibleData;

import java.util.List;
import java.util.Map;
import com.google.gson.annotations.*;
import serialization.HypermediaLinksAdapter;

/**
 * An data type that supports hypermedia controls (i.e. links).
 */
public class HypermediaEnabledData extends ExtensibleData {

    @JsonAdapter(HypermediaLinksAdapter.class)
    private List<Map<String, List<Link>>> links;    // The list of hypermedia links. Links are not specified by GEDCOM X core, but as extension elements by GEDCOM X RS.

    public HypermediaEnabledData(){
        super();
        links = null;
    }

    public List<Map<String, List<Link>>> getLinks() {
        return links;
    }

    public void setLinks(List<Map<String, List<Link>>> links) {
        this.links = links;
    }
}
