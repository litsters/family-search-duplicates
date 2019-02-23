package familySearchModel;

/**
 * Information about a change.
 */
public class ChangeInfo {
    private String operation;               // The operation of the change.
    private String objectType;              // The type of the object to which the operation applies.
    private String objectModifier;          // An optional modifier for the object to which the operation applies. For example, if the object is a Fact, a modifier could be applied to indicate that fact applies to a person, couple, or child-and-parents relationship.
    private String reason;                  // The reason for the change.
    private ResourceReference parent;       // The parent change that triggered, caused, or included this change.
    private ResourceReference resulting;    // The subject representing the result of the change.
    private ResourceReference original;     // The subject representing the original value(s) that existed before the change.
    private ResourceReference removed;      // The subject representing the removed value(s) that existed before the change.

    public ChangeInfo(){
        operation = null;
        objectType = null;
        objectModifier = null;
        reason = null;
        parent = null;
        resulting = null;
        original = null;
        removed = null;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getObjectModifier() {
        return objectModifier;
    }

    public void setObjectModifier(String objectModifier) {
        this.objectModifier = objectModifier;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResourceReference getParent() {
        return parent;
    }

    public void setParent(ResourceReference parent) {
        this.parent = parent;
    }

    public ResourceReference getResulting() {
        return resulting;
    }

    public void setResulting(ResourceReference resulting) {
        this.resulting = resulting;
    }

    public ResourceReference getOriginal() {
        return original;
    }

    public void setOriginal(ResourceReference original) {
        this.original = original;
    }

    public ResourceReference getRemoved() {
        return removed;
    }

    public void setRemoved(ResourceReference removed) {
        this.removed = removed;
    }
}
