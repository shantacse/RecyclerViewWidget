package com.example.shantacse.recyclear_veiw_in_online.model;

public class employee {

    //-----intializing variable-----//
    private String image;
    private String name;
    private String designation;
    private String study;
    private String email;

    //-----Constructor----//
    public employee(String image, String name, String designation, String study, String email) {
        this.image = image;
        this.name = name;
        this.designation = designation;
        this.study = study;
        this.email = email;
    }

    //-------getter setter method-----///

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
