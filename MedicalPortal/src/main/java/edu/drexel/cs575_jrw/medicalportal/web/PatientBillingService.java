package edu.drexel.cs575_jrw.medicalportal.web;

import edu.drexel.cs575_jrw.medicalportal.ejb.RequestBean;
import edu.drexel.cs575_jrw.medicalportal.entity.BillItem;
import edu.drexel.cs575_jrw.medicalportal.entity.PatientBillingInfo;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

@WebService(serviceName = "PatientBillingService")
@Stateless()
public class PatientBillingService {


    @EJB
    private RequestBean request;
    
    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getOutstandingPatientBillingItems")
    public List<BillItem> getOutstandingPatientBillingItems(@WebParam(name = "patientId") int patientId) {
        
        List<BillItem> oustandingBillItems = request.getOutstandingBillItemsByPatientId(patientId);
        
        return oustandingBillItems;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllPatientBillingItems")
    public List<BillItem> getAllPatientBillingItems(@WebParam(name = "patientId") int patientId) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPatientsWithOutstandingBillingItems")
    public List<Integer> getPatientsWithOutstandingBillingItems() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPatientBillingInfo")
    public PatientBillingInfo getPatientBillingInfo(@WebParam(name = "patientId") int patientId) {
        //TODO write your implementation code here:
        return null;
    }
}
