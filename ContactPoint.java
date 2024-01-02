package org.example;

public class ContactPoint {
    private ContactType contactType;
    private String data;

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ContactType getContactType() {
        return this.contactType;
    }
    public String getData() {
        return this.data;
    }

}
