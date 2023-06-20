package sg.edu.nus.iss.day21workshop.models;

public class Order {

    private Integer id;
    private Integer employeeID;
    private Integer customerID;
    private String orderDate;
    private String shippedDate;
    private Integer shipperID;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipStateProvince;
    private String shipZipPostalCode;
    private String shipCountryRegion;
    private String shippingFee;
    private String taxes;
    private String paymentType;
    private String paidDate;
    private String notes;
    private String taxRate;
    private Integer taxStatusID;
    private Integer statusID;

    public Order() {
    }

    public Order(Integer id, Integer employeeID, Integer customerID, String orderDate, String shippedDate,
            Integer shipperID, String shipName, String shipAddress, String shipCity, String shipStateProvince,
            String shipZipPostalCode, String shipCountryRegion, String shippingFee, String taxes, String paymentType,
            String paidDate, String notes, String taxRate, Integer taxStatusID, Integer statusID) {
        this.id = id;
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.shippedDate = shippedDate;
        this.shipperID = shipperID;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipStateProvince = shipStateProvince;
        this.shipZipPostalCode = shipZipPostalCode;
        this.shipCountryRegion = shipCountryRegion;
        this.shippingFee = shippingFee;
        this.taxes = taxes;
        this.paymentType = paymentType;
        this.paidDate = paidDate;
        this.notes = notes;
        this.taxRate = taxRate;
        this.taxStatusID = taxStatusID;
        this.statusID = statusID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Integer getShipperID() {
        return shipperID;
    }

    public void setShipperID(Integer shipperID) {
        this.shipperID = shipperID;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipStateProvince() {
        return shipStateProvince;
    }

    public void setShipStateProvince(String shipStateProvince) {
        this.shipStateProvince = shipStateProvince;
    }

    public String getShipZipPostalCode() {
        return shipZipPostalCode;
    }

    public void setShipZipPostalCode(String shipZipPostalCode) {
        this.shipZipPostalCode = shipZipPostalCode;
    }

    public String getShipCountryRegion() {
        return shipCountryRegion;
    }

    public void setShipCountryRegion(String shipCountryRegion) {
        this.shipCountryRegion = shipCountryRegion;
    }

    public String getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(String shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getTaxes() {
        return taxes;
    }

    public void setTaxes(String taxes) {
        this.taxes = taxes;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public Integer getTaxStatusID() {
        return taxStatusID;
    }

    public void setTaxStatusID(Integer taxStatusID) {
        this.taxStatusID = taxStatusID;
    }

    public Integer getStatusID() {
        return statusID;
    }

    public void setStatusID(Integer statusID) {
        this.statusID = statusID;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", employeeID=" + employeeID + ", customerID=" + customerID + ", orderDate="
                + orderDate + ", shippedDate=" + shippedDate + ", shipperID=" + shipperID + ", shipName=" + shipName
                + ", shipAddress=" + shipAddress + ", shipCity=" + shipCity + ", shipStateProvince=" + shipStateProvince
                + ", shipZipPostalCode=" + shipZipPostalCode + ", shipCountryRegion=" + shipCountryRegion
                + ", shippingFee=" + shippingFee + ", taxes=" + taxes + ", paymentType=" + paymentType + ", paidDate="
                + paidDate + ", notes=" + notes + ", taxRate=" + taxRate + ", taxStatusID=" + taxStatusID
                + ", statusID=" + statusID + "]";
    }

}
