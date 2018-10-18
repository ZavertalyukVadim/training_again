package com.repository;

import com.entity.Customer;

import java.util.List;

//public interface CustomerRepository extends MongoRepository<Customer, String> {
public interface CustomerRepository {

    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);

}