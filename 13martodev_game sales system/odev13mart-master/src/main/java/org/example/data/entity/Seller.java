package org.example.data.entity;

public class Seller extends User{
    private String companyName;
    private String taxNumber;

    public Seller() {
    }

    public Seller(int id, String email, String password, String companyName, String taxNumber) {
        super(id, email, password);
        this.companyName = companyName;
        this.taxNumber = taxNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }
}
