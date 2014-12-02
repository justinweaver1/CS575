/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.drexel.cs575_jrw.medicalportal.web;

import edu.drexel.cs575_jrw.medicalportal.entity.PatientPrescription;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Justin
 */
@WebService(serviceName = "PatientPrescriptionService")
@Stateless()
public class PatientPrescriptionService {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "getApprovedPrescriptionRefills")
    public List<PatientPrescription> getApprovedPrescriptionRefills() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updatePrescriptionStatus")
    public Boolean updatePrescriptionStatus(@WebParam(name = "prescriptionId") int prescriptionId,
                                            @WebParam(name = "prescriptionStatus") String prescriptionStatus) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPatientPrescriptions")
    public List<PatientPrescription> getPatientPrescriptions(@WebParam(name = "patientId") int patientId) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "requestRefill")
    public Boolean requestRefill(@WebParam(name = "prescriptionId") int prescriptionId) {
        //TODO write your implementation code here:
        return null;
    }
}
