package sg.edu.nus.iss.day21workshop.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.day21workshop.model.Customer;

@Repository
public class CustomerRepository {

    @Autowired
    JdbcTemplate template;

    private final String getAllSQL = "select * from customers limit ? offset ?";

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
    
}
