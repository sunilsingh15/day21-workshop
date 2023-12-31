package sg.edu.nus.iss.day21workshop.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.day21workshop.models.Customer;
import sg.edu.nus.iss.day21workshop.models.Order;
import sg.edu.nus.iss.day21workshop.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepo;

    public List<Customer> getAllCustomers(int offset, int limit) {
        return customerRepo.getAllCustomers(offset, limit);
    }

    public Customer getCustomerByID(int id) {

        try {
            Customer customer = customerRepo.findCustomerByID(id);
            return customer;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Customer not found with ID: " + id);
        }

    }

    public List<Order> getOrdersByCustomerID(int id) {

        try {
            return customerRepo.findOrdersByCustomerID(id);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Customer with ID " + id + " does not exist!");
        }
        
    }

}
