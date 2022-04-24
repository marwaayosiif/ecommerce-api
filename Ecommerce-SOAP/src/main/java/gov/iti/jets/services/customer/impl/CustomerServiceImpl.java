package gov.iti.jets.services.customer.impl;

import gov.iti.jets.persistence.entity.Customer;
import gov.iti.jets.persistence.entity.Order;
import gov.iti.jets.persistence.repository.customer.CustomerRepository;
import gov.iti.jets.services.customer.CustomerService;
import gov.iti.jets.services.customer.dto.CustomerGetResponse;
import gov.iti.jets.services.customer.dto.CustomerOrderGetResponse;
import gov.iti.jets.services.customer.dto.CustomerOrderPostRequest;
import gov.iti.jets.services.customer.dto.CustomerPostRequest;
import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "gov.iti.jets.services.customer.CustomerService")
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<CustomerGetResponse> getAllCustomers() {
        List<Customer> customers = customerRepository.getAllCustomers();
        List<CustomerGetResponse> listCustomers = new ArrayList<>();
        for ( Customer customer :
                customers ) {
            listCustomers.add( mapperFromCustomerToCustomerGetResponse(customer) );
        }
        return listCustomers;
    }

    @Override
    public CustomerGetResponse getCustomerById( int id ) {
        return mapperFromCustomerToCustomerGetResponse( customerRepository.getCustomerById(id) );
    }

    @Override
    public List<CustomerOrderGetResponse> getOrdersOfCustomer( int id ) {
        List<Order> orderList = customerRepository.getOrdersOfCustomer(id);
        List<CustomerOrderGetResponse> orders = new ArrayList<>();
        for ( Order order: orderList ) {
            orders.add( mapperFromOrderToCustomerOrderGetResponse( order ) );
        }
        return  orders;
    }

    @Override
    public Object getOrderByIdOfCustomer( int id, int oid ) {
        return mapperFromOrderToCustomerOrderGetResponse( customerRepository.getOrderByIdOfCustomer(id,oid) );
    }

    @Override
    public String deleteAllCustomers() {
        return customerRepository.deleteAllCustomers();
    }

    @Override
    public String deleteCustomerById( int id ) {
        return customerRepository.deleteCustomerById(id);
    }

    @Override
    public String addCustomer( CustomerPostRequest customerPostRequest ) {
        return customerRepository.addCustomer(customerPostRequest);
    }

    @Override
    public String addOrderToCustomer( CustomerOrderPostRequest customerOrderPostRequest, int id ) {
        return customerRepository.addOrderToCustomer(customerOrderPostRequest , id ) ;
    }

    @Override
    public CustomerGetResponse editCustomer( CustomerPostRequest customerPostRequest, int id ) {
        return mapperFromCustomerToCustomerGetResponse( customerRepository.editCustomer(customerPostRequest,id) );
    }

    @Override
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
