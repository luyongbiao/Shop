package org.bqj.shopping.entity;

public class Admin {
    private Integer adminId;

    private String adminName;

    private String adminPassword;

<<<<<<< HEAD
    private String adminGender;
=======
    private String adminGendar;
>>>>>>> origin/master

    private String adminMobilePhone;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

<<<<<<< HEAD
    public String getAdminGender() {
        return adminGender;
    }

    public void setAdminGender(String adminGender) {
        this.adminGender = adminGender == null ? null : adminGender.trim();
=======
    public String getAdminGendar() {
        return adminGendar;
    }

    public void setAdminGendar(String adminGendar) {
        this.adminGendar = adminGendar == null ? null : adminGendar.trim();
>>>>>>> origin/master
    }

    public String getAdminMobilePhone() {
        return adminMobilePhone;
    }

    public void setAdminMobilePhone(String adminMobilePhone) {
        this.adminMobilePhone = adminMobilePhone == null ? null : adminMobilePhone.trim();
    }
}