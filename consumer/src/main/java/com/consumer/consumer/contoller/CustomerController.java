package com.consumer.consumer.contoller;

import com.consumer.consumer.entities.Customer;
import com.consumer.consumer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    @ResponseBody
    public Iterable<Customer> GetCustomers(){
        return customerService.GetCustomers();
    }

    @GetMapping("/customer/{id}")
    @ResponseBody
    public Object GetCustomer(@PathVariable String id){
        return customerService.GetCustomer(Long.parseLong(id));
    }

    @GetMapping("/customerByName/{name}")
    @ResponseBody
    public Object GetCustomerName(@PathVariable String name){
        return customerService.GetCustomerByFirstName(name);
    }

    @GetMapping("/customerByLastName/{lastName}")
    @ResponseBody
    public Object GetCustomerLastName(@PathVariable String lastName){
        return customerService.GetCustomerByLastName(lastName);
    }

    @PostMapping("/add")
    @ResponseBody
    public Customer CreateCustomer(@RequestBody Customer customer){
        return customerService.CreateCustomer(customer);
    }

    @PostMapping("/addtest")
    @ResponseBody
    public Customer CreateCustomer(){
        //Esto es un hardcode
        Customer test = new Customer("a","a");
        return customerService.CreateCustomer(test);
    }

    @PutMapping("/update")
    public Customer UpdateCustomer(@RequestBody Customer customer){
        return customerService.SaveOrUpdate(customer);
    }

    @DeleteMapping("/delete/{id}")
    public String DeleteCustomer(@PathVariable String id){
        return customerService.DeleteCustomer(Long.parseLong(id));
    }
}
