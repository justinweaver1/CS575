package edu.drexel.cs575_jrw.medicalportal.ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.drexel.cs575_jrw.medicalportal.entity.Appointment;
import edu.drexel.cs575_jrw.medicalportal.entity.BillItem;
import edu.drexel.cs575_jrw.medicalportal.entity.Doctor;
import edu.drexel.cs575_jrw.medicalportal.entity.Patient;


@Stateful
public class RequestBean {
    
    @PersistenceContext
    private EntityManager em;

    private static final Logger logger = Logger.getLogger("order.ejb.RequestBean");
    
    public void createDoctor(int docId, String inFirstName,
            String inLastName, 
            String inPhone,
            String inHandle)
    {
        try
        {
            
          //  int id = this.getNextDoctorId();
            
          Doctor doc = new Doctor(docId, inFirstName, inLastName, inPhone, inHandle);
          
          em.persist(doc);
          
          logger.log(Level.INFO, "Created new Doctor object {0}", docId);
        }
        catch(Exception e)
        {
            logger.log(Level.WARNING, "Failure trying to create Doctor object");
            throw new EJBException(e.getMessage());
        }
               
    }
    
    public void createPatient(int patId, String inFirstName,
            String inLastName,
            String inAddress, 
            String inPhone)
    {
        try
        {
           //int id =  this.getNextPatientId();
            
          Patient pat = new Patient(patId, inFirstName, inLastName, inAddress, inPhone);
          
          em.persist(pat);
          
          logger.log(Level.INFO, "Created new Patient object {0}", patId);
        }
        catch(Exception e)
        {
            logger.log(Level.WARNING, "Failure creating new Patient object");
            throw new EJBException(e.getMessage());
        }
               
    }
    
    public void createAppointment(int apptId, String inDoctorHandle,
            int inPatientId,
            String inStatus,
            Date inApptDate)
    {
        try
        {
            
         //int id  = this.getNextAppointmentId();
            
          Appointment appt = new Appointment(apptId, inStatus, inApptDate, inDoctorHandle, inPatientId);
          
          em.persist(appt);
          
          logger.log(Level.INFO, "Created new Appointment object {0}", apptId);
        }
        catch(Exception e)
        {
            logger.log(Level.INFO, "Failure creating new Appointment object");
            throw new EJBException(e.getMessage());
        }
               
    }
    
    public int getNextDoctorId()
    {    
        return em.createNamedQuery("getMaxDoctorId").getFirstResult() + 1;
    }
    
    public int getNextPatientId()
    {
        return em.createNamedQuery("getMaxPatientId").getFirstResult() + 1;
    }
    
    public int getNextAppointmentId()
    {
        return em.createNamedQuery("getMaxAppointmentId").getFirstResult() + 1;
    }
    
    public List<Appointment> getAllAppointments() {
        List<Appointment> appts = (List<Appointment>) em.createNamedQuery("findAllAppointments").getResultList();
        return appts;
    }
    
    public List<Appointment> getAvailableAppointments() {
        List<Appointment> appts = (List<Appointment>) em.createNamedQuery("findAvailableAppointments").setParameter("inStatus", "A").getResultList();
        return appts;
    }
    
    public List<Appointment> getAppointmentsByPatientId(Integer inPatientId) {
        List<Appointment> appts = (List<Appointment>) em.createNamedQuery("findAppointmentsByPatientId").setParameter("inPatientId", inPatientId).getResultList();
        return appts;
    }
    
    public int cancelAppointment(Integer inApptId) {

        int returnCode = 0;
        
        try
        {
            
            Appointment cancelAppt = em.find(Appointment.class, inApptId);
            
            Date apptDate = cancelAppt.getAppointmentDate();
            Integer apptId = cancelAppt.getAppointmentId();
            String apptDoc = cancelAppt.getDoctorHandle();
            
            Appointment updatedAppt = new Appointment(apptId, "A", apptDate, apptDoc, -1);
            
            em.remove(cancelAppt);
            
            em.persist(updatedAppt);
            
            //returnCode = em.createNamedQuery("cancelAppointment").setParameter("inAvailableStatus", "A").setParameter("inAppointmentId", inApptId).executeUpdate();
        } 
        catch (EJBException e) {
            
            logger.log(Level.WARNING, "Couldn''t cancel appointment ID {0}. Return code: {1}", new Object[]{inApptId});
            throw new EJBException(e.getMessage());
        }   
         
        return returnCode;
    }
    
    public int bookAppointment(Integer inApptId, Integer inPatientId, Date inDate) {

        int returnCode = 0;
        
        try
        {
            returnCode = em.createNamedQuery("bookAppointment").setParameter("inAppointmentId", inApptId).setParameter("inPatientId", inPatientId).setParameter("inDate", inDate).executeUpdate();
        } 
        catch (EJBException e) {
            
            logger.log(Level.WARNING, "Couldn''t book appointment ID {0}. Return code: {1}", new Object[]{inApptId});
            throw new EJBException(e.getMessage());
        }   
         
        return returnCode;
    }
    
    public void createBillItem(Integer inBillItemId, String inStatus,
                    Integer inPatientId, Date inPaymentDueDate,
                    double inAmount, String inDescription)
    {
        try
        {
        BillItem newBillItem = new BillItem(inBillItemId, inStatus, inPatientId, inPaymentDueDate, inAmount, inDescription);
        
        em.persist(newBillItem);
        
        }
        catch(Exception e)
        {
            logger.log(Level.WARNING, "Couldn''t create new Bill Item: {0}", e.getMessage());
        }
    }
    
    public List<BillItem> getOutstandingBillItemsByPatientId(Integer inPatientId)
    {
        List<BillItem> billItems = (List<BillItem>) em.createNamedQuery("findAllBillItemsByPatientId").setParameter("inPatientId", inPatientId).getResultList();
        
        return billItems;
    }

}
