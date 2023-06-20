package sg.edu.nus.iss.day21workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.day21workshop.model.Customer;
import sg.edu.nus.iss.day21workshop.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepo;

    public List<Customer> getAllCustomers(int offset, int limit) {
        return customerRepo.getAllCustomers(offset, limit);
    }
    
}
