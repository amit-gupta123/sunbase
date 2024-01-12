package com.sunbase.assignment.customer.services;

import com.sunbase.assignment.customer.model.Customer;
import com.sunbase.assignment.customer.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService{

    /**
     * dependency injection using constructor injection.
     *
     * */
    private final CustomerRepository customerRepository;
    public CustomerServiceImplementation(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * saves given entity to db.
     * */
    @Override
    public Customer saveCustomer(@RequestBody Customer customer) {
       return customerRepository.save(customer);
    }

    /**
     * fetches given customer bases on id.
     * */
    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
       Customer customer = null;
       if(existingCustomer.isPresent()){
            customer = existingCustomer.get();
       }else throw new RuntimeException("Employee with id : "+id+" not found");
       return customer;
    }

    /**
     *fetches all customer from database
     * */
    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    /**
     * Update customers existing in database
     * */
    @Override
    public Customer updateCustomer(Customer customer,Long id) {
        Optional<Customer> customer1 = customerRepository.findById(id);
        Customer exist = null;
        if(customer1.isPresent()){
            exist = customer1.get();
            exist = customer;
        }
        customerRepository.save(exist);
        return exist;
    }

    /**
     * deletes customer from db
     * */
    @Override
    public void deleteCustomerById(Long id) {
         customerRepository.deleteById(id);
    }

    /**
     * provides pagination and sorting.
     * */
    @Override
    public Page<Customer> getPages(int pageNo, int pageSize,String sortBasis, String sortingOrder) {
        // jpa count pages from 0 and user count from 1,
        Sort sort = sortingOrder.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBasis).ascending():
                Sort.by(sortBasis).descending();
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,sort); // need to pass sort here if we have to
        return customerRepository.findAll(pageable);
    }


}
