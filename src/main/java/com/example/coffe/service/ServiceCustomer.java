package com.example.coffe.service;

import com.example.coffe.model.entity.Customer;
import com.example.coffe.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceCustomer {

    private CustomerRepository customerRepository;

    public ServiceCustomer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Integer isCustomerPresent(Customer customer){
        Customer customer1 = customerRepository.getCustomerByAlamatAndNameAndNotelp(customer.getAlamat(),customer.getName(), customer.getNotelp());
        return customer1!=null ? customer1.getId(): null ;
    }
}