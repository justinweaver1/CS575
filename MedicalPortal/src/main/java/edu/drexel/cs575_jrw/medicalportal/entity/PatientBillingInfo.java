package edu.drexel.cs575_jrw.medicalportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="PATIENT_BILLING_INFORMATION")
@NamedQueries({
    @NamedQuery(
        name="findPatientBillingInfoById",
        query="SELECT DISTINCT p " +
              "FROM PatientBillingInfo p " +
              "WHERE p.patientId = :id "
    )
})
public class PatientBillingInfo implements java.io.Serializable {
    private static final long serialVersionUID = 2538111111598426330L;
    private int patientId;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    
    public PatientBillingInfo() {}
    
    public PatientBillingInfo(int inPatientId, 
            String inFirstName,
            String inLastName,
            String inAddress,  
            String inPhone) {
        this.patientId = inPatientId;
        this.firstName = inFirstName;
        this.lastName = inLastName;
        this.address = inAddress;
        this.phone = inPhone;
    }

    @Id
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int inPatientId) {
        this.patientId = inPatientId;
    }

    @Column(name="PATIENT_FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String inFirstName) {
        this.firstName = inFirstName;
    }
    
    @Column(name="PATIENT_LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String inLastName) {
        this.lastName = inLastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
