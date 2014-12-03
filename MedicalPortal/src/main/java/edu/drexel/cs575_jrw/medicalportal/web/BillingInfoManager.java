package edu.drexel.cs575_jrw.medicalportal.web;

import java.util.List;
import java.util.logging.Logger;
import edu.drexel.cs575_jrw.medicalportal.ejb.RequestBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.drexel.cs575_jrw.medicalportal.entity.BillItem;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class BillingInfoManager implements Serializable{
    private static final long serialVersionUID = 214999543318489373L;
    @EJB
    private RequestBean request;
    private static final Logger logger = Logger.getLogger("medicalportal.web.BillingInfoManager");
    private List<BillItem> billItems;
    
    public List<BillItem> getOutstandingBillItemsForPatient(Integer inPatientId)
    {
        try
        {
            this.billItems = request.getOutstandingBillItemsByPatientId(inPatientId);
        }
        catch(Exception e)
        {
           logger.warning(String.format("Couldn't get bill items for patient Id {0}:{1}", inPatientId, e.getMessage())); 
        }
               
        return billItems;
    }
    
    public double getOutstandingBillItemsTotalForPatient(Integer inPatientId)
    {
        double total = 0;
        
        try
        {
            this.billItems = request.getOutstandingBillItemsByPatientId(inPatientId);
            
            for (BillItem billItem : billItems) {
                
                total += billItem.getAmount();
                
            }
        }
        catch(Exception e)
        {
           logger.warning(String.format("Couldn't get bill items for patient Id {0}:{1}", inPatientId, e.getMessage())); 
        }
               
        return total;
    }

}
