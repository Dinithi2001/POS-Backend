package com.springbootacademy.batch8.pos.entity;
import jakarta.persistence.*;

@Entity
@Table(name ="customer")
public class Customer {
    @Id  //initialize customerId as primary key
    @Column(name = "Customer_id",length = 45)//database eke column ek hadenn ona nama
    private int customerId;

    @Column(name = "customer_name",length=100,nullable = false)
    private String customerName;

    @Column(name="customer_address",length = 255)
    private String customerAddress;

    @Column(name="contact_numbers",length = 20)
    private String contactNumber;

    @Column(name = "customer_salary")
    private double customerSalary;

    @Column(name = "nic")
    private String nic;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean active;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerAddress, String contactNumber, double customerSalary, String nic, boolean active) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.contactNumber = contactNumber;
        this.customerSalary = customerSalary;
        this.nic = nic;
        this.active = active;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public String getNic() {
        return nic;
    }

    public boolean isActive() {
        return active;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", customerSalary=" + customerSalary +
                ", nic='" + nic + '\'' +
                ", active=" + active +
                '}';
    }
}
