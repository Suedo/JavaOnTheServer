import com.pluralsight.repository.CustomerRepository;
import com.pluralsight.repository.HibernateCustomerRepositoryImpl;
import com.pluralsight.service.CustomerService;
import com.pluralsight.service.CustomerServiceImpl;
// ^^ not required

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;

@Configuration
@ComponentScan({"com.pluralsight"}) // for autowiring
@PropertySource("app.properties")
public class AppConfig {


    // Makes all the properties from the resource file available throughout the project
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    /*

    //Not Needed when @Service is used
    @Bean(name = "customerService")
    public CustomerService getCustomerService() {
        CustomerServiceImpl service = new CustomerServiceImpl();
        // CustomerServiceImpl service = new CustomerServiceImpl(getCustomerRepository()); // constructor injection, not method call
        // service.setCustomerRepository(getCustomerRepository()); // setter injection, not method call
        return service;
    }

    // Not needed when @Repository used
    @Bean(name = "customerRepository")
    public CustomerRepository getCustomerRepository() {
        return new HibernateCustomerRepositoryImpl();
    }

    */

}
