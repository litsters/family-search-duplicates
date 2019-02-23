package familySearchModel.extensibleData.hypermediaEnabledData.conclusion.reservation;

import familySearchModel.ResourceReference;
import familySearchModel.extensibleData.hypermediaEnabledData.conclusion.Conclusion;

/**
 * An ordinance reservation.
 */
public class Reservation extends Conclusion {
    private String ordinanceType;       // No information online.
    private String type;                // gets the type of ordinance
    private String status;              // gets the status of this ordinance
    private ResourceReference spouse;   // The spouse associated with the ordinance, if the ordinance type is sealing-to-spouse.
    private ResourceReference father;   // The father associated with the ordinance, if the ordinance type is sealing-to-parents.
    private ResourceReference mother;   // The mother associated with the ordinance, if the ordinance type is sealing-to-parents.
    private ResourceReference asignee;  // The user or entity assigned to fulfill the ordinance work for this reservation. If no assignee is provided, the assignee is assumed to be the owner of the reservation.

    public Reservation(){
        super();
        ordinanceType = null;
        type = null;
        status = null;
        spouse = null;
        father = null;
        mother = null;
        asignee = null;
    }

    public String getOrdinanceType() {
        return ordinanceType;
    }

    public void setOrdinanceType(String ordinanceType) {
        this.ordinanceType = ordinanceType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResourceReference getSpouse() {
        return spouse;
    }

    public void setSpouse(ResourceReference spouse) {
        this.spouse = spouse;
    }

    public ResourceReference getFather() {
        return father;
    }

    public void setFather(ResourceReference father) {
        this.father = father;
    }

    public ResourceReference getMother() {
        return mother;
    }

    public void setMother(ResourceReference mother) {
        this.mother = mother;
    }

    public ResourceReference getAsignee() {
        return asignee;
    }

    public void setAsignee(ResourceReference asignee) {
        this.asignee = asignee;
    }
}
