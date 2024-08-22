package br.ufrn.imd.Models;

import java.util.Date;
import java.util.UUID;

public class Contract {
    private UUID nContractUUID;
    private String tenantName;
    private String tenantEmail;
    private String tenantPhoneNumber;
    private UUID nKitnetUUID;
    private Date startDate;
    private Date endDate;
    private double rentAmount;
    private double adjustment;
    private String status;

    public Contract(String tenantName, String tenantEmail, String tenantPhoneNumber, UUID nKitnetUUID, Date startDate, Date endDate, double rentAmount, double adjustment, String status) {
        this.nContractUUID = UUID.randomUUID();
        this.tenantName = tenantName;
        this.tenantEmail = tenantEmail;
        this.tenantPhoneNumber = tenantPhoneNumber;
        this.nKitnetUUID = nKitnetUUID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentAmount = rentAmount;
        this.adjustment = adjustment;
        this.status = status;
    }

    public void updateContract(UUID nContractUUID, String tenantName, String tenantEmail, String tenantPhoneNumber, UUID nKitnetUUID, Date startDate, Date endDate, double rentAmount, double adjustment, String status) {
        this.nContractUUID = nContractUUID;
        this.tenantName = tenantName;
        this.tenantEmail = tenantEmail;
        this.tenantPhoneNumber = tenantPhoneNumber;
        this.nKitnetUUID = nKitnetUUID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentAmount = rentAmount;
        this.adjustment = adjustment;
        this.status = status;
    }

    public UUID getnContractUUID() {
        return nContractUUID;
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

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public void setTenantEmail(String tenantEmail) {
        this.tenantEmail = tenantEmail;
    }

    public void setTenantPhoneNumber(String tenantPhoneNumber) {
        this.tenantPhoneNumber = tenantPhoneNumber;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getnKitnetUUID() {
        return nKitnetUUID;
    }

}
