package sg.edu.nus.iss.day21workshop.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.day21workshop.models.Customer;
import sg.edu.nus.iss.day21workshop.models.Order;
import sg.edu.nus.iss.day21workshop.service.CustomerService;

@RestController
@RequestMapping(path = "/api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(required = false, defaultValue = "0") int offset,
            @RequestParam(required = false, defaultValue = "5") int limit) {
        return ResponseEntity.ok().body(customerService.getAllCustomers(offset, limit));
    }

    @GetMapping(path = "{customerID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCustomerByID(@PathVariable("customerID") int id) {
        try {
            Customer customer = customerService.getCustomerByID(id);
            return ResponseEntity.ok().body(customer);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping(path = "{customerID}/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCustomerOrdersByID(@PathVariable("customerID") int id) {

        try {
            return ResponseEntity.ok().body(customerService.getOrdersByCustomerID(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

}
