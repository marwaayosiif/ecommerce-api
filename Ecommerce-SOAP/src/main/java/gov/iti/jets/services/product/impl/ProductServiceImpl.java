package gov.iti.jets.services.product.impl;

import gov.iti.jets.persistence.entity.Product;
import gov.iti.jets.persistence.repository.product.ProductRepository;
import gov.iti.jets.services.product.ProductService;
import gov.iti.jets.services.product.dto.ProductGetResponse;
import gov.iti.jets.services.product.dto.ProductPostRequest;
import gov.iti.jets.services.product.dto.ProductPutRequest;
import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "gov.iti.jets.services.product.ProductService")
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository = new ProductRepository();

    @Override
    public List<ProductGetResponse> getAllProducts() {
        List<ProductGetResponse> productList =  new ArrayList<>();
        List<Product> products = productRepository.getAllProducts();
        for ( Product product : products ) {
            productList.add( mapperFromProductToProductGetRes( product ) );
        }
        return productList;
    }

    @Override
    public ProductGetResponse getProductById( int id ) {
        return mapperFromProductToProductGetRes( productRepository.getProductById(id) );
    }

    @Override
    public String deleteAllProducts() {
        return productRepository.deleteAllProducts();
    }

    @Override
    public String deleteProductById( int id ) {
        return productRepository.deleteProductById(id);
    }

    @Override
    public String addProduct( ProductPostRequest productPostRequest ) {
        return productRepository.addProduct(productPostRequest);
    }

    @Override
    public ProductGetResponse editProduct( int id, ProductPutRequest productPutRequest ) {
        Product product = productRepository.editProduct(id,productPutRequest);
        return mapperFromProductToProductGetRes( product );
    }

    private ProductGetResponse mapperFromProductToProductGetRes( Product product){
        return new ProductGetResponse(product.getId(), product.getDescription() , product.getName() , product.getPrice() , product.getCategories());
    }
}
