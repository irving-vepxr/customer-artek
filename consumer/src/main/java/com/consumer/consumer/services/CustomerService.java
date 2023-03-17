package com.consumer.consumer.services;

import com.consumer.consumer.entities.Customer;
import com.consumer.consumer.interfaces.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Iterable<Customer> GetCustomers(){
        return customerRepository.findAll();
    }

    public Object GetCustomer(Long id){
        return customerRepository.findById(id);
    }

    public Iterable<Customer> GetCustomerByLastName(String lastName){
        return customerRepository.findByLastName(lastName);
    }

    public Iterable<Customer> GetCustomerByFirstName(String firstName){
        return customerRepository.findByFirstName(firstName);
    }
    public Customer CreateCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer SaveOrUpdate(Customer customer){
        return customerRepository.save(customer);
    }

    public String DeleteCustomer(Long id){
        customerRepository.deleteById(id);
        return "Customer deleted";
    }
}
