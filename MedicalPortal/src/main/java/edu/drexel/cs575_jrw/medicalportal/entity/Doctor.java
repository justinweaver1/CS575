package edu.drexel.cs575_jrw.medicalportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="DOCTOR_INFORMATION")
@NamedQueries({
    @NamedQuery(
        name="findDoctorByFirstName",
        query="SELECT di " +
              "FROM Doctor di " +
              "WHERE di.firstName = :firstName"
    ),
    @NamedQuery(
        name="findDoctorByLastName",
        query="SELECT di " +
              "FROM Doctor di " +
              "WHERE di.lastName = :lastName"
    ),
    @NamedQuery(
        name="findDoctorById",
        query="SELECT d " +
              "FROM Doctor d " +
              "WHERE d.doctorId = :id"
    ),
    @NamedQuery(
        name="getMaxDoctorId",
        query="SELECT MAX(d.doctorId)" +
              "FROM Doctor d"
    )    
})
public class Doctor implements java.io.Serializable {
    private static final long serialVersionUID = 7778635007598426330L;
    private int doctorId;
    private String firstName;
    private String lastName;
    private String phone;
    private String handle;
    
    public Doctor() {}
    
    public Doctor(int inDoctorId, 
            String inFirstName,
            String inLastName, 
            String inPhone,
            String inHandle) {
        this.doctorId = inDoctorId;
        this.firstName = inFirstName;
        this.firstName = inLastName;
        this.phone = inPhone;
        this.handle = inHandle;
    }

    @Id
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int inPatientId) {
        this.doctorId = inPatientId;
    }

    @Column(name="DOCTOR_FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String inFirstName) {
        this.firstName = inFirstName;
    }

    @Column(name="DOCTOR_LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String inLastName) {
        this.lastName = inLastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getHandle() {
        return handle;
    }

    public void setHandle(String inHandle) {
        this.handle = inHandle;
    }
}
