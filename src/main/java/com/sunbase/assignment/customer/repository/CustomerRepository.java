package com.sunbase.assignment.customer.repository;

import com.sunbase.assignment.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is repository interface, which extends JPA repository.
 * JPA repository provide methods to implement CRUD and more advanced operations.
 * */



public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // jpa repository also implement paging and sor+ting repository internally
}
