package familySearchModel;

/**
 * Information about a name form.
 */
public class NameFormInfo {
    private String order;   // The ordering of the name form.

    public NameFormInfo(){
        order = null;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString(){
        return "{ order: " + order + "}\n";
    }
}
