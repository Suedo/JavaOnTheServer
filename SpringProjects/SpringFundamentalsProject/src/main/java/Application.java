import com.pluralsight.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerService customerService = appContext.getBean("customerService", CustomerService.class);


        /* Singleton Test : both with print same address when @Scope("singleton") used in CustomerServiceImpl

        System.out.println(customerService);    // com.pluralsight.service.CustomerServiceImpl@35fc6dc4
        CustomerService customerService2 = appContext.getBean("customerService", CustomerService.class);
        System.out.println(customerService2);   // com.pluralsight.service.CustomerServiceImpl@35fc6dc4

        */

        // Prototype Test : difference address when @Scope("prototype") used in CustomerServiceImpl
        System.out.println(customerService);    // 35fc6dc4
        CustomerService customerService2 = appContext.getBean("customerService", CustomerService.class);
        System.out.println(customerService2);   // 7fe8ea47

        System.out.println(customerService.findAll().get(0).getFirstName());
    }
}
