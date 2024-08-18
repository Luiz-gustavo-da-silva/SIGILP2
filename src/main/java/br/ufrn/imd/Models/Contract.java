package br.ufrn.imd.Models;

import java.util.Date;

public class Contract {
    private int nContract;
    private String tenantName;
    private String tenantEmail;
    private String tenantPhoneNumber;
    private int Kitnet;
    private Date startDate;
    private Date endDate;
    private double rentAmount;
    private double adjustment;
    private String status;

    public Contract(int nContract, String tenantName, String tenantEmail, String tenantPhoneNumber, int kitnet, Date startDate, Date endDate, double rentAmount, double adjustment, String status) {
        this.nContract = nContract;
        this.tenantName = tenantName;
        this.tenantEmail = tenantEmail;
        this.tenantPhoneNumber = tenantPhoneNumber;
        Kitnet = kitnet;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentAmount = rentAmount;
        this.adjustment = adjustment;
        this.status = status;
    }
}
