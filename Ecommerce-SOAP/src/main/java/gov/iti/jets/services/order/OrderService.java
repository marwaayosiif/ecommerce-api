package gov.iti.jets.services.order;

import gov.iti.jets.services.order.dto.OrderGetResponse;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface OrderService {
    @WebMethod
    List<OrderGetResponse> getAllOrders();
    @WebMethod
    OrderGetResponse getOrderById( int id );
    @WebMethod
    String deleteAllOrders();
    @WebMethod
    String deleteOrderById( int id );
}
