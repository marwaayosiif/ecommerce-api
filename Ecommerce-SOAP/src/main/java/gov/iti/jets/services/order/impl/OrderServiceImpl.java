package gov.iti.jets.services.order.impl;

import gov.iti.jets.persistence.entity.Order;
import gov.iti.jets.persistence.repository.order.OrderRepository;
import gov.iti.jets.services.order.OrderService;
import gov.iti.jets.services.order.dto.OrderGetResponse;
import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "gov.iti.jets.services.order.OrderService")
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository = new OrderRepository();

    @Override
    public List<OrderGetResponse> getAllOrders() {
        List<Order> orders = orderRepository.getAllOrders();
        List<OrderGetResponse> orderList = new ArrayList<>();
        for ( Order order :
                orders ) {
            orderList.add( mapperFromOrderToOrderGetResponse(order) );
        }
        return orderList;
    }

    @Override
    public OrderGetResponse getOrderById( int id ) {
        return mapperFromOrderToOrderGetResponse( orderRepository.getOrderById(id) );
    }

    @Override
    public String deleteAllOrders() {
        return orderRepository.deleteAllOrders();
    }

    @Override
    public String deleteOrderById( int id ) {
        return orderRepository.deleteOrderById(id);
    }

    private OrderGetResponse mapperFromOrderToOrderGetResponse( Order order ) {
        return new OrderGetResponse(order.getId() , order.getCustomer() , order.getTotalPrice() , order.getProducts());
    }
}
