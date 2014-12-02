package edu.drexel.cs575_jrw.medicalportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;

@Entity
@Table(name="PATIENT_PRESCRIPTION_INFORMATION")
@NamedQueries({
    @NamedQuery(
        name="findPrescriptionsByPatientId",
        query="SELECT DISTINCT p " +
              "FROM PatientPrescription p " +
              "WHERE p.patientId = :id "
    )
})
public class PatientPrescription implements java.io.Serializable {
    private static final long serialVersionUID = 2531234999598426330L;
    private int prescriptionId;
    private int patientId;
    private String prescriptionName;
    private String status;
    private Date lastRefilled;
    private boolean eligableForRefill;
    
    public PatientPrescription() {}
    
    public PatientPrescription(int inPrescriptionId,
            int inPatientId, 
            String inPrescriptionName,
            String inStatus,
            Date inLastRefilled,  
            boolean inEligableForRefill) {
        this.prescriptionId = inPrescriptionId;
        this.patientId = inPatientId;
        this.prescriptionName = inPrescriptionName;
        this.status = inStatus;
        this.lastRefilled = inLastRefilled;
        this.eligableForRefill = inEligableForRefill;
    }

    @Id
    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int inPrescriptionId) {
        this.prescriptionId = inPrescriptionId;
    }
    
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int inPatientId) {
        this.patientId = inPatientId;
    }

    @Column(name="PRESCRIPTION_NAME")
    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String inPrescriptionName) {
        this.prescriptionName = inPrescriptionName;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String inStatus) {
        this.status = inStatus;
    }

    @Temporal(TIMESTAMP)
    public Date getLastRefilled() {
        return lastRefilled;
    }

    public void setLastRefilled(Date inLastRefilled) {
        this.lastRefilled = inLastRefilled;
    }

    public boolean getEligableForRefill() {
        return eligableForRefill;
    }

    public void setEligableForRefill(boolean inEligableForRefill) {
        this.eligableForRefill = inEligableForRefill;
    }
}
