package familySearchModel.extensibleData;

/**
 * An address.
 */
public class Address extends ExtensibleData {
    private String city;            // The city.
    private String country;         // The country.
    private String postalCode;      // The postal code.
    private String stateOrProvince; // The state or province.
    private String street;          // The street.
    private String street2;         // Additional street information.
    private String street3;         // Additional street information.
    private String street4;         // Additional street information.
    private String street5;         // Additional street information.
    private String street6;         // Additional street information.
    private String value;           // The value of the property, if it can be expressed as a string.

    public Address(){
        super();
        city = null;
        country = null;
        postalCode = null;
        stateOrProvince = null;
        street = null;
        street2 = null;
        street3 = null;
        street4 = null;
        street5 = null;
        street6 = null;
        value = null;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getStreet3() {
        return street3;
    }

    public void setStreet3(String street3) {
        this.street3 = street3;
    }

    public String getStreet4() {
        return street4;
    }

    public void setStreet4(String street4) {
        this.street4 = street4;
    }

    public String getStreet5() {
        return street5;
    }

    public void setStreet5(String street5) {
        this.street5 = street5;
    }

    public String getStreet6() {
        return street6;
    }

    public void setStreet6(String street6) {
        this.street6 = street6;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
