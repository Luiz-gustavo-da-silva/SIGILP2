package br.ufrn.imd.Models;

import java.util.Date;

public class Contract {
    private int nContract;
    private String tenantName;
    private String tenantEmail;
    private String tenantPhoneNumber;
    private Kitnet kitnet;
    private Date startDate;
    private Date endDate;
    private double rentAmount;
    private double adjustment;
    private String status;

    public Contract(int nContract, String tenantName, String tenantEmail, String tenantPhoneNumber, Kitnet kitnet, Date startDate, Date endDate, double rentAmount, double adjustment, String status) {
        this.nContract = nContract;
        this.tenantName = tenantName;
        this.tenantEmail = tenantEmail;
        this.tenantPhoneNumber = tenantPhoneNumber;
        this.kitnet = kitnet;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentAmount = rentAmount;
        this.adjustment = adjustment;
        this.status = status;
    }

    public int getnContract() {
        return nContract;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getTenantEmail() {
        return tenantEmail;
    }

    public String getTenantPhoneNumber() {
        return tenantPhoneNumber;
    }

    public Kitnet getKitnet() {
        return kitnet;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public double getAdjustment() {
        return adjustment;
    }

    public String getStatus() {
        return status;
    }

    public void setnContract(int nContract) {
        this.nContract = nContract;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public void setTenantEmail(String tenantEmail) {
        this.tenantEmail = tenantEmail;
    }

    public void setTenantPhoneNumber(String tenantPhoneNumber) {
        this.tenantPhoneNumber = tenantPhoneNumber;
    }

    public void setKitnet(Kitnet kitnet) {
        this.kitnet = kitnet;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public void setAdjustment(double adjustment) {
        this.adjustment = adjustment;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
