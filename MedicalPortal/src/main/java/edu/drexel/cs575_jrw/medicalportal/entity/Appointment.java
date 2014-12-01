package edu.drexel.cs575_jrw.medicalportal.entity;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;

@Entity
@Table(name="PATIENT_APPOINTMENT")
@NamedQueries({
    @NamedQuery(
        name="findAllAppointments",
        query="SELECT pa FROM Appointment pa " +
              "ORDER BY pa.appointmentId"
    ),
    @NamedQuery(
        name="findAvailableAppointments",
        query="SELECT pa FROM Appointment pa " +
              "WHERE pa.status = :inStatus"
    ),
    @NamedQuery(
        name="findAppointmentsByPatientId",
        query="SELECT pa FROM Appointment pa " +
              "WHERE pa.patientId = :inPatientId"
    ),
    @NamedQuery(
        name="cancelAppointmentById",
        query="UPDATE Appointment SET status = 'A' WHERE appointmentId = :inAppointmentId"
    ),
    @NamedQuery(
        name="bookAppointmentById",
        query="UPDATE Appointment a " +
              "SET a.status = 'S', " +
                  "a.patientId = :inPatientId, " +
                  "a.appointmentDate = :inDate " +
              "WHERE a.appointmentId = :inAppointmentId"
    ),
    @NamedQuery(
        name="getMaxAppointmentId",
        query="SELECT MAX(pa.appointmentId) " +
              "FROM Appointment pa "
    )
})
public class Appointment implements java.io.Serializable {
    private static final long serialVersionUID = 6580105465066674695L;
    private Integer appointmentId;
    private String status; //A=Available, S=Scheduled, C=Complete
    private Date appointmentDate;
    private Date lastUpdated;
    private String doctorHandle;
    private int patientId;
    
    public Appointment() {
        this.lastUpdated = new Date();
    }
    
    public Appointment(Integer inApptId, String inStatus, Date inApptDate, 
            String inDoctorHandle, int inPatientId) {
        this.appointmentId = inApptId;
        this.status = inStatus;
        this.appointmentDate = inApptDate;
        this.doctorHandle = inDoctorHandle;
        this.patientId = inPatientId;
        this.lastUpdated = new Date();
    }
    
    @Id
    public Integer getAppointmentId() {
        return appointmentId;
    }
    
    public void setAppointmentId(Integer inAppointmentId) {
        this.appointmentId = inAppointmentId;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Temporal(TIMESTAMP)
    public Date getLastUpdate() {
        return lastUpdated;
    }
    
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdated = lastUpdate;
    }
    
    public String getDoctorHandle() {
        return doctorHandle;
    }
    
    public void setDoctorHandle(String inDoctorHandle) {
        this.doctorHandle = inDoctorHandle;
    }
    
    public int getPatientId() {
        return patientId;
    }
    
    public void setPatientId(int inPatientId) {
        this.patientId = inPatientId;
    }
    
    @Temporal(TIMESTAMP)
    public Date getAppointmentDate() {
        return appointmentDate;
    }
    
    public void setAppointmentDate(Date inApptDate) {
        this.appointmentDate = inApptDate;
    }

}
