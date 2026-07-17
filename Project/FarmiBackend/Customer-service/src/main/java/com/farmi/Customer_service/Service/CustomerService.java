package com.farmi.Customer_service.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmi.Customer_service.Entity.Customers;
import com.farmi.Customer_service.Repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Create Customer
    public Customers createCustomer(Customers customer) {
        return customerRepository.save(customer);
    }

    // Get All Customers
    public List<Customers> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get Customer By Id
    public Customers getCustomerById(Long id) {
        Optional<Customers> customer = customerRepository.findById(id);

        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new RuntimeException("Customer not found with id: " + id);
        }
    }

    // Update Customer
    public Customers updateCustomer(Long id, Customers customerDetails) {

        Customers existingCustomer = getCustomerById(id);

        existingCustomer.setName(customerDetails.getName());
        existingCustomer.setEmail(customerDetails.getEmail());
        existingCustomer.setPhoneNumber(customerDetails.getPhoneNumber());
        existingCustomer.setAddress(customerDetails.getAddress());
        existingCustomer.setCity(customerDetails.getCity());
        existingCustomer.setPincode(customerDetails.getPincode());

        return customerRepository.save(existingCustomer);
    }

    // Delete Customer
    public void deleteCustomer(Long id) {

        Customers customer = getCustomerById(id);

        customerRepository.delete(customer);
    }
}