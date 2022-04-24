package gov.iti.jets.services.service.customer;

import gov.iti.jets.persistence.entity.Customer;
import gov.iti.jets.persistence.entity.Order;
import gov.iti.jets.persistence.repository.customer.CustomerRepository;
import gov.iti.jets.services.dto.customer.CustomerGetResponse;
import gov.iti.jets.services.dto.customer.CustomerOrderGetResponse;
import gov.iti.jets.services.dto.customer.CustomerOrderPostRequest;
import gov.iti.jets.services.dto.customer.CustomerPostRequest;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    CustomerRepository customerRepository = new CustomerRepository();

    public List<CustomerGetResponse> getAllCustomers() {
        List<Customer> customers = customerRepository.getAllCustomers();
        List<CustomerGetResponse> listCustomers = new ArrayList<>();
        for ( Customer customer :
                customers ) {
            listCustomers.add( mapperFromCustomerToCustomerGetResponse(customer) );
        }
        return listCustomers;
    }

    public CustomerGetResponse getCustomerById( int id ) {
        return mapperFromCustomerToCustomerGetResponse( customerRepository.getCustomerById(id) );
    }

    public List<CustomerOrderGetResponse> getOrdersOfCustomer( int id ) {
        List<Order> orderList = customerRepository.getOrdersOfCustomer(id);
        List<CustomerOrderGetResponse> orders = new ArrayList<>();
        for ( Order order: orderList ) {
            orders.add( mapperFromOrderToCustomerOrderGetResponse( order ) );
        }
        return  orders;
    }

    public Object getOrderByIdOfCustomer( int id, int oid ) {
        return mapperFromOrderToCustomerOrderGetResponse( customerRepository.getOrderByIdOfCustomer(id,oid) );
    }

    public String deleteAllCustomers() {
        return customerRepository.deleteAllCustomers();
    }

    public String deleteCustomerById( int id ) {
        return customerRepository.deleteCustomerById(id);
    }

    public String addCustomer( CustomerPostRequest customerPostRequest ) {
        return customerRepository.addCustomer(customerPostRequest);
    }

    public String addOrderToCustomer( CustomerOrderPostRequest customerOrderPostRequest , int id) {
        return customerRepository.addOrderToCustomer(customerOrderPostRequest , id ) ;
    }

    public CustomerGetResponse editCustomer( CustomerPostRequest customerPostRequest, int id ) {
        return mapperFromCustomerToCustomerGetResponse( customerRepository.editCustomer(customerPostRequest,id) );
    }

    public CustomerOrderGetResponse editOrderToCustomer( CustomerOrderPostRequest customerOrderPostRequest, int id, int oid ) {
        return mapperFromOrderToCustomerOrderGetResponse( customerRepository.editOrderToCustomer(customerOrderPostRequest,id,oid) );
    }

    private CustomerGetResponse mapperFromCustomerToCustomerGetResponse( Customer customer ) {
        return new CustomerGetResponse(customer.getId() , customer.getName(), customer.getEmail(), customer.getPhone() );
    }
    private CustomerOrderGetResponse mapperFromOrderToCustomerOrderGetResponse( Order order ) {

        return new CustomerOrderGetResponse(order.getId() , order.getTotalPrice() );
    }

}
