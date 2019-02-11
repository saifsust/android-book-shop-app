package org.waodec.activities.entities;

public class RegisterClient {

    private int registerClientId;
    private String firstName, lastName, location, email, phone_num, imageLink;
    private int zelaId, divisionId, thanaId, postOfficeCodeId;


    public RegisterClient() {
    }

    public RegisterClient(int registerClientId, String firstName, String lastName, String location, String email, String phone_num, String imageLink, int zelaId, int divisionId, int thanaId, int postOfficeCodeId) {
        this.registerClientId = registerClientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.email = email;
        this.phone_num = phone_num;
        this.imageLink = imageLink;
        this.zelaId = zelaId;
        this.divisionId = divisionId;
        this.thanaId = thanaId;
        this.postOfficeCodeId = postOfficeCodeId;
    }

    public RegisterClient(String firstName, String lastName, String location, String email, String phone_num, String imageLink, int zelaId, int divisionId, int thanaId, int postOfficeCodeId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.email = email;
        this.phone_num = phone_num;
        this.imageLink = imageLink;
        this.zelaId = zelaId;
        this.divisionId = divisionId;
        this.thanaId = thanaId;
        this.postOfficeCodeId = postOfficeCodeId;
    }

    public int getRegisterClientId() {
        return registerClientId;
    }

    public void setRegisterClientId(int registerClientId) {
        this.registerClientId = registerClientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public int getZelaId() {
        return zelaId;
    }

    public void setZelaId(int zelaId) {
        this.zelaId = zelaId;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public int getThanaId() {
        return thanaId;
    }

    public void setThanaId(int thanaId) {
        this.thanaId = thanaId;
    }

    public int getPostOfficeCodeId() {
        return postOfficeCodeId;
    }

    public void setPostOfficeCodeId(int postOfficeCodeId) {
        this.postOfficeCodeId = postOfficeCodeId;
    }

    @Override
    public String toString() {
        return "RegisterClient{" +
                "registerClientId=" + registerClientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", phone_num='" + phone_num + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", zelaId=" + zelaId +
                ", divisionId=" + divisionId +
                ", thanaId=" + thanaId +
                ", postOfficeCodeId=" + postOfficeCodeId +
                '}';
    }
}
