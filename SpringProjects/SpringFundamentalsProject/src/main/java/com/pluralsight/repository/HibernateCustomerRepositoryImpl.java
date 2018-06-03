package com.pluralsight.repository;

import com.pluralsight.model.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("customerRepository")
public class HibernateCustomerRepositoryImpl implements CustomerRepository {

    @Value("${dbUsername}")
    private String dbUser;

    public List<Customer> findAll(){
        List<Customer> customers = new ArrayList<Customer>();
        Customer customer = new Customer();
        // customer.setFirstName("Somjit");
        customer.setFirstName(dbUser);  // get from "dbUsername" property in app.properties file
        customer.setLastName("Nag");
        customers.add(customer);
        return customers;
    }

}
