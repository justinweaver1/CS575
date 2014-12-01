package edu.drexel.cs575_jrw.medicalportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="PATIENT_INFORMATION")
@NamedQueries({
    @NamedQuery(
        name="findPatientByFirstName",
        query="SELECT pi " +
              "FROM Patient pi " +
              "WHERE LOCATE(:first_name, pi.firstName) > 0"
    ),
    @NamedQuery(
        name="findPatientByLastName",
        query="SELECT pi " +
              "FROM Patient pi " +
              "WHERE LOCATE(:last_name, pi.lastName) > 0"
    ),
    @NamedQuery(
        name="findPatientById",
        query="SELECT DISTINCT p " +
              "FROM Patient p " +
              "WHERE p.patientId = :id "
    ),
    @NamedQuery(
        name="getMaxPatientId",
        query="SELECT MAX(p.patientId) " +
              "FROM Patient p"
    )
})
public class Patient implements java.io.Serializable {
    private static final long serialVersionUID = 2538444007598426330L;
    private int patientId;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    
    public Patient() {}
    
    public Patient(int inPatientId, 
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
