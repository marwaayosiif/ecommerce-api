package gov.iti.jets.services.service.order;

import gov.iti.jets.persistence.entity.Order;
import gov.iti.jets.persistence.repository.order.OrderRepository;
import gov.iti.jets.services.dto.order.OrderGetResponse;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    OrderRepository orderRepository = new OrderRepository();

    public List<OrderGetResponse> getAllOrders() {
        List<Order> orders = orderRepository.getAllOrders();
        List<OrderGetResponse> orderList = new ArrayList<>();
        for ( Order order :
                orders ) {
            orderList.add( mapperFromOrderToOrderGetResponse(order) );
        }
        return orderList;
    }

    public OrderGetResponse getOrderById( int id ) {
        return mapperFromOrderToOrderGetResponse( orderRepository.getOrderById(id) );
    }

    public String deleteAllOrders() {
        return orderRepository.deleteAllOrders();
    }

    public String deleteOrderById( int id ) {
        return orderRepository.deleteOrderById(id);
    }

    private OrderGetResponse mapperFromOrderToOrderGetResponse( Order order ) {
        return new OrderGetResponse(order.getId() , order.getCustomer() , order.getTotalPrice() , order.getProducts());
    }

}
