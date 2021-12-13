package sample;

public class OrganizatsiyaRecipient {
    private String id_recipient;
    private String name_recipient;
    private String city_recipient;
    private String street_recipient;
    private String type_organization;

    public OrganizatsiyaRecipient(String id_recipient, String name_recipient,
                                  String city_recipient, String street_recipient, String type_organization) {
        this.id_recipient = id_recipient;
        this.name_recipient = name_recipient;
        this.city_recipient = city_recipient;
        this.street_recipient = street_recipient;
        this.type_organization = type_organization;
    }

    public OrganizatsiyaRecipient() {
    }

    public String getId_recipient() {
        return id_recipient;
    }

    public void setId_recipient(String id_recipient) {
        this.id_recipient = id_recipient;
    }

    public String getName_recipient() {
        return name_recipient;
    }

    public void setName_recipient(String name_recipient) {
        this.name_recipient = name_recipient;
    }

    public String getCity_recipient() {
        return city_recipient;
    }

    public void setCity_recipient(String city_recipient) {
        this.city_recipient = city_recipient;
    }

    public String getStreet_recipient() {
        return street_recipient;
    }

    public void setStreet_recipient(String street_recipient) {
        this.street_recipient = street_recipient;
    }

    public String getType_organization() {
        return type_organization;
    }

    public void setType_organization(String type_organization) {
        this.type_organization = type_organization;
    }
}
