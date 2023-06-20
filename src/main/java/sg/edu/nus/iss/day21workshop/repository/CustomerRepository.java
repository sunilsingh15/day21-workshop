package sg.edu.nus.iss.day21workshop.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.day21workshop.models.Customer;
import sg.edu.nus.iss.day21workshop.models.Order;

@Repository
public class CustomerRepository {

    @Autowired
    JdbcTemplate template;

    private final String getAllSQL = "select * from customers limit ? offset ?";
    private final String getCustomerByID = "select * from customers where id = ?";
    private final String checkIfCustomerExists = "select id from customers where id = ?";
    private final String getOrderByCustomerID = "select * from orders where customer_id = ?";

    public List<Customer> getAllCustomers(int offset, int limit) {
        List<Customer> customerList = new ArrayList<>();

        SqlRowSet rs = template.queryForRowSet(getAllSQL, limit, offset);

        while (rs.next()) {
            Customer customer = new Customer();
            customer.setId(rs.getString("id"));
            customer.setCompany(rs.getString("company"));
            customer.setLastName(rs.getString("last_name"));
            customer.setFirstName(rs.getString("first_name"));
            customer.setEmailAddress(rs.getString("email_address"));
            customer.setJobTitle(rs.getString("job_title"));
            customer.setBusinessPhone(rs.getString("business_phone"));
            customer.setHomePhone(rs.getString("home_phone"));
            customer.setMobilePhone(rs.getString("mobile_phone"));
            customer.setFaxNumber(rs.getString("fax_number"));
            customer.setAddress(rs.getString("address"));
            customer.setCity(rs.getString("city"));
            customer.setStateProvince(rs.getString("state_province"));
            customer.setZipPostalCode(rs.getString("zip_postal_code"));
            customer.setCountryRegion(rs.getString("country_region"));
            customer.setWebPage(rs.getString("web_page"));
            customer.setNotes(rs.getString("notes"));
            customer.setAttachments(rs.getString("attachments"));

            customerList.add(customer);
        }

        return Collections.unmodifiableList(customerList);
    }

    public Customer findCustomerByID(int id) {
        Customer customer = new Customer();

        try {
            customer = template.queryForObject(getCustomerByID, BeanPropertyRowMapper.newInstance(Customer.class), id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchElementException("Customer not found with ID: " + id);
        }

        return customer;
    }

    public List<Order> findOrdersByCustomerID(int id) {

        List<Order> orderList = new ArrayList<>();
        SqlRowSet check = template.queryForRowSet(checkIfCustomerExists, id);

        if (!check.next()) {
            throw new NoSuchElementException("Customer with ID " + id + " does not exist!");
        } else {
            try {
                SqlRowSet rs = template.queryForRowSet(getOrderByCustomerID, id);

                while (rs.next()) {
                    Order order = new Order();
                    order.setId(rs.getInt("id"));
                    order.setEmployeeID(rs.getInt("employee_id"));
                    order.setCustomerID(rs.getInt("customer_id"));
                    order.setOrderDate(rs.getString("order_date"));
                    order.setShippedDate(rs.getString("shipped_date"));
                    order.setShipperID(rs.getInt("shipper_id"));
                    order.setShipName(rs.getString("ship_name"));
                    order.setShipAddress(rs.getString("ship_address"));
                    order.setShipCity(rs.getString("ship_city"));
                    order.setShipStateProvince(rs.getString("ship_state_province"));
                    order.setShipZipPostalCode(rs.getString("ship_zip_postal_code"));
                    order.setShipCountryRegion(rs.getString("ship_country_region"));
                    order.setShippingFee(rs.getString("shipping_fee"));
                    order.setTaxes(rs.getString("taxes"));
                    order.setPaymentType(rs.getString("payment_type"));
                    order.setPaidDate(rs.getString("paid_date"));
                    order.setNotes(rs.getString("notes"));
                    order.setTaxRate(rs.getString("tax_rate"));
                    order.setTaxStatusID(rs.getInt("tax_status_id"));
                    order.setStatusID(rs.getInt("status_id"));

                    orderList.add(order);
                }

            } catch (EmptyResultDataAccessException e) {
                throw new NoSuchElementException("No orders found with customer ID:" + id);
            }

        }

        return orderList;
    }

}
