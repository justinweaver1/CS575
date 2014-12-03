package edu.drexel.cs575_jrw.medicalportal.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;

/**
 *
 * @author Justin
 */
@Entity
@Table(name="PATIENT_BILL_ITEMS")
@NamedQueries({
    @NamedQuery(
        name="findAllBillItems",
        query="SELECT bi FROM BillItem bi " +
              "ORDER BY bi.billItemId"
    ),
    @NamedQuery(
        name="findAllBillItemsByPatientId",
        query="SELECT bi FROM BillItem bi " +
              "WHERE bi.patientId = :inPatientId"
    ),
    @NamedQuery(
        name="findOutstandingBillItemsByPatientId",
        query="SELECT bi FROM BillItem bi " +
              "WHERE bi.patientId = :inPatientId " +
                "AND bi.status = 'O'"
    )
})
public class BillItem implements Serializable {
    private static final long serialVersionUID = 188765544356765L;
    private Integer billItemId;
    private String status; //P=Paid; O=Outstanding
    private Integer patientId;
    private Date paymentDueDate;
    private Date paidDate;
    private double amount;
    private String description;
    
    public BillItem()
    {}
    
    public BillItem(Integer inBillItemId, String inStatus,
                    Integer inPatientId, Date inPaymentDueDate,
                    double inAmount, String inDescription)
    {
        this.billItemId = inBillItemId;
        this.status = inStatus;
        this.patientId = inPatientId;
        this.paymentDueDate = inPaymentDueDate;
        this.amount = inAmount;
        this.description = inDescription;
        this.paidDate = new Date();
    }
    
    @Id
    public Integer getBillItemId()
    {
        return this.billItemId;
    }
    
    public void setBillItemId(Integer inId)
    {
        this.billItemId = inId;
    }
    
    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String inStatus)
    {
        this.status = inStatus;
    }

    public Integer getPatientId()
    {
        return this.patientId;
    }

    public void setPatientId(Integer inPatId)
    {
        this.patientId = inPatId;
    }

    @Temporal(TIMESTAMP)
    public Date getPaymentDueDate()
    {
        return this.paymentDueDate;
    }

    public void setPaymentDueDate(Date inPaymentDueDate)
    {
        this.paymentDueDate = inPaymentDueDate;
    }

    public double getAmount()
    {
        return this.amount;
    }

    public void setAmount(double inAmount)
    {
        this.amount = inAmount;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String inDescription)
    {
        this.description = inDescription;
    }
    
    @Temporal(TIMESTAMP)
    public Date getPaidDate()
    {
        return this.paidDate;
    }
    
    public void setPaidDate(Date inPaidDate)
    {
        this.paidDate = inPaidDate;
    }

}
