package gov.iti.jets.services.product;

import gov.iti.jets.services.product.dto.ProductGetResponse;
import gov.iti.jets.services.product.dto.ProductPostRequest;
import gov.iti.jets.services.product.dto.ProductPutRequest;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface ProductService {
    @WebMethod
    List<ProductGetResponse> getAllProducts();
    @WebMethod
    ProductGetResponse getProductById( int id );
    @WebMethod
    String deleteAllProducts();
    @WebMethod
    String deleteProductById( int id );
    @WebMethod
    String addProduct( ProductPostRequest productPostRequest );
    @WebMethod
    ProductGetResponse editProduct( int id, ProductPutRequest productPutRequest );
}
