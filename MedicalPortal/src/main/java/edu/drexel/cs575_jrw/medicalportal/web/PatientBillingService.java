package edu.drexel.cs575_jrw.medicalportal.web;

import edu.drexel.cs575_jrw.medicalportal.ejb.RequestBean;
import edu.drexel.cs575_jrw.medicalportal.entity.BillItem;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Justin
 */
@WebService(serviceName = "PatientBillingService")
@Stateless()
public class PatientBillingService {


    @EJB
    private RequestBean request;
    
    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getOutstandingBillingItems")
    public List<BillItem> getOutstandingBillingItems(@WebParam(name = "patientId") int patientId) {
        
        List<BillItem> oustandingBillItems = request.getOutstandingBillItemsByPatientId(patientId);
        
        return oustandingBillItems;
    }
}
