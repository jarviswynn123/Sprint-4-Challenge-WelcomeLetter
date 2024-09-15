package com.bloomtech.welcomeletter.models;

public class Company {
    private static int maxId = 1;
    private int id;

    private String companyname;
    private String country;

    //TODO: Replace with Builder Constructor

    public static CompanyBuilder builder() {
        return new CompanyBuilder();
    }
    private Company(CompanyBuilder builder) {
        this.companyname = builder.companyname;
        this.country = builder.country;
    }

    public static final class CompanyBuilder {
        //TODO: Implement Builder Pattern
        private static int maxId = 1;
        private int id;

        private String companyname;
        private String country;
        public CompanyBuilder() {
            id = maxId;
            maxId++;
        }
        public CompanyBuilder withCompanyname(String companynameToUse) {
            this.companyname = companynameToUse;
            return this;
        }
        public CompanyBuilder withCountry(String countryToUse) {
            this.country = countryToUse;
            return this;
        }

        public Company build() {
            return new Company(this);
        }
    }


    public int getId() {
        return id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public String getCountry() {
        return country;
    }
}