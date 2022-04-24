package gov.iti.jets.services.customer;

import gov.iti.jets.services.customer.dto.CustomerGetResponse;
import gov.iti.jets.services.customer.dto.CustomerOrderGetResponse;
import gov.iti.jets.services.customer.dto.CustomerOrderPostRequest;
import gov.iti.jets.services.customer.dto.CustomerPostRequest;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface CustomerService {
    @WebMethod
    List<CustomerGetResponse> getAllCustomers();
    @WebMethod
    CustomerGetResponse getCustomerById( int id );
    @WebMethod
    List<CustomerOrderGetResponse> getOrdersOfCustomer( int id );
    @WebMethod
    Object getOrderByIdOfCustomer( int id, int oid );
    @WebMethod
    String deleteAllCustomers();
    @WebMethod
    String deleteCustomerById( int id );
    @WebMethod
    String addCustomer( CustomerPostRequest customerPostRequest );
    @WebMethod
    String addOrderToCustomer( CustomerOrderPostRequest customerOrderPostRequest , int id);
    @WebMethod
    CustomerGetResponse editCustomer( CustomerPostRequest customerPostRequest, int id );
    @WebMethod
    CustomerOrderGetResponse editOrderToCustomer( CustomerOrderPostRequest customerOrderPostRequest, int id, int oid );
}
