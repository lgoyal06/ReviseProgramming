package com.lalit.convertors.test;

public class Addresses {

    private String location;

    public PhoneObj getPhone() {
        return phone;
    }

    public void setPhone(PhoneObj phone) {
        this.phone = phone;
    }

    private PhoneObj phone;

    public String[] getStreet() {
        return street;
    }

    private String[] street=new String[]{"df","Df3"};

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    private String pincode;
}
