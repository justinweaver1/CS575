package edu.drexel.cs575_jrw.medicalportal.web;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.drexel.cs575_jrw.medicalportal.ejb.RequestBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;

import edu.drexel.cs575_jrw.medicalportal.entity.Appointment;

@ManagedBean
@SessionScoped
public class AppointmentManager implements Serializable{
    private static final long serialVersionUID = 2149999151318489373L;
    @EJB
    private RequestBean request;
    private static final Logger logger = Logger.getLogger("medicalportal.web.AppointmentManager");
    private List<Appointment> appointments;

    /**
     * @return the orders
     */
    public List<Appointment> getAllAppointments() {
        try {
            this.appointments = request.getAllAppointments();
        } catch (Exception e) {
            logger.warning("Couldn't get all appointments.");
        }
        return appointments;
    }
    
    public List<Appointment> getAvailableAppointments() {
        try {
            this.appointments = request.getAvailableAppointments();
        } catch (Exception e) {
            logger.warning("Couldn't get available appointments.");
        }
        return appointments;
    }
    
    public List<Appointment> getMyAppointments() {
        
        int patientId = -1;
        
        try {
            
            patientId = 6;
            
            this.appointments = request.getAppointmentsByPatientId(patientId);
        } catch (Exception e) {
            logger.warning(String.format("Couldn't get appointments for patient Id %d.", patientId));
        }
        return appointments;
    }

    public void cancelAppointment(ActionEvent event) {
        
        Integer inApptId = 0;
        
        try {
            
            UIParameter param = (UIParameter) event.getComponent().findComponent("cancelAppointmentId");
            inApptId = Integer.parseInt(param.getValue().toString());
            
            int returnCode = request.cancelAppointment(inApptId);
            
            if(returnCode == 0)
            {
             logger.log(Level.INFO, "Cancelled appointment {0}.", inApptId);
            }
            else
            {
                logger.log(Level.WARNING, String.format( "Error when cancelling appointment {0}. Return code: {1}", inApptId, returnCode));
            }
         
        }
        catch (Exception e) {
            
            logger.log(Level.WARNING, String.format( "Exception when cancelling appointment {0}: {1}", inApptId, e.getMessage()));
        }
    }

    

    public void bookAppointment(Integer inApptId, Integer inPatientId, Date inDate) {
        try {
            
            int returnCode = request.bookAppointment(inApptId, inPatientId, inDate);
            
            if(returnCode == 0)
            {
                logger.log(Level.INFO, "Booked appointment ID {0}, patient {1}, and Date {2}.", 
                        new Object[]{inApptId, inPatientId, inDate});
            }
            else
            {
                logger.log(Level.WARNING, String.format( "Error when booking appointment {0}. Return code: {1}", inApptId, returnCode));
            }
        }
        catch (Exception e) {
            logger.warning(String.format("Problem booking appointment id %d: %s", inApptId, e.getMessage()));
        }
    }

}
