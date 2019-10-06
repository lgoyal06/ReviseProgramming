package com.lalit.convertors.test;

public class PhoneObj {

    public PhoneObj(String fax, String mobile) {
        this.fax = fax;
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public String getMobile() {
        return mobile;
    }

    private String fax;
    private String mobile;
}
