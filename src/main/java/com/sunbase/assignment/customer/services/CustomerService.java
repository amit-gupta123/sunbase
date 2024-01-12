package com.sunbase.assignment.customer.services;


import com.sunbase.assignment.customer.model.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * A service layer interface which defines, all methods to be implemented.
 * */

public interface CustomerService  {

    /***
     * This method define signature to save an entity into database.
     */
    Customer saveCustomer(Customer customer);

    /***
     * This method define signature to get an entity from database using Id.
     */
    Customer getCustomerById(Long id);

    /***
     * This method define signature to get all Customers from database using.
     */
    List<Customer> getAllCustomer();

    /**
     * This method is used to update an existing customer in db.
     * */
    Customer updateCustomer(Customer customer,Long id);

    /**
     * this method is used to delete customers from db, based on their id.
     * */
    void deleteCustomerById(Long id);

    /**
     * This method lets us do pagination and sorting.
     * pageNo- page no to start from-> by default jpa start it from 0.
     * pageSize- How many rows/entity we want on a single page.
     * sortBasis- On what field sorting is to be applied.
     * sortingOrder- ascending or descending (Asc by default)
     * */
    Page<Customer> getPages(int pageNo, int pageSize,String sortBasis, String sortingOrder);



}
