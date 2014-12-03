package edu.drexel.cs575_jrw.medicalportal.web;

import java.util.List;
import java.util.logging.Logger;
import edu.drexel.cs575_jrw.medicalportal.ejb.RequestBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.drexel.cs575_jrw.medicalportal.entity.PatientPrescription;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class PrescriptionManager implements Serializable{
    private static final long serialVersionUID = 214999915131765373L;
    @EJB
    private RequestBean request;
    private static final Logger logger = Logger.getLogger("medicalportal.web.PrescriptionManager");
    private List<PatientPrescription> prescriptions;
    
    public List<PatientPrescription> getPatientPrescriptions(Integer inPatientId)
    {
        try
        {
            this.prescriptions = request.getPrescriptionsByPatientId(inPatientId);
        }
        catch(Exception e)
        {
           logger.warning(String.format("Couldn't get bill items for patient Id {0}:{1}", inPatientId, e.getMessage())); 
        }
               
        return prescriptions;
    }

}
