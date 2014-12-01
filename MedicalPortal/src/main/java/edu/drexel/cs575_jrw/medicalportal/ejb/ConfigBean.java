package edu.drexel.cs575_jrw.medicalportal.ejb;
import java.util.Date;
import java.time.Month;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class ConfigBean {

    @EJB
    private RequestBean request;

    @PostConstruct
    public void createData() {
        
        /* Appointment Creation */
        
        request.createDoctor(2, "John", "Smith", "123-456-7890", "JSMITH");
        request.createDoctor(5, "Jen", "Cruz", "432-143-5544", "JCRUZ");
        request.createDoctor(10, "Ben", "Billiard", "700-867-9878", "BBILLIARD");
        
        request.createPatient(6, "Justin", "Weaver", "123 Hawthorne Lane", "124-345-3344");
        request.createPatient(9, "Casey", "Jones", "123 Grateful Way", "666-546-8734");
        
        request.createAppointment(4, "JCRUZ", -1, "A", new Date(2015, 3, 14, 12, 30));
        request.createAppointment(11, "BBILLIARD", -1, "A", new Date(2015, 1, 3, 16, 30));
        request.createAppointment(16, "JSMITH", -1, "A", new Date(2014, 12, 28, 10, 30));
        request.createAppointment(20, "JSMITH", 6, "S", new Date(2014, 12, 29, 14, 00));

    }

    @PreDestroy
    public void deleteData() {
        
    }
}
