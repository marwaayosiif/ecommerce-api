package gov.iti.jets.services.service.product;

import gov.iti.jets.persistence.entity.Product;
import gov.iti.jets.persistence.repository.product.ProductRepository;
import gov.iti.jets.services.dto.product.ProductGetResponse;
import gov.iti.jets.services.dto.product.ProductPostRequest;
import gov.iti.jets.services.dto.product.ProductPutRequest;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    ProductRepository productRepository = new ProductRepository();
    public List<ProductGetResponse> getAllProducts() {
        List<ProductGetResponse> productList =  new ArrayList<>();
        List<Product> products = productRepository.getAllProducts();
        for ( Product product : products ) {
            productList.add( mapperFromProductToProductGetRes( product ) );
        }
        return productList;
    }

    public ProductGetResponse getProductById( int id ) {
        return mapperFromProductToProductGetRes( productRepository.getProductById(id) );
    }

    public String deleteAllProducts() {
        return productRepository.deleteAllProducts();
    }

    public String deleteProductById( int id ) {
        return productRepository.deleteProductById(id);
    }


    public String addProduct( ProductPostRequest productPostRequest ) {
        return productRepository.addProduct(productPostRequest);
    }

    public ProductGetResponse editProduct( int id, ProductPutRequest productPutRequest ) {
        Product product = productRepository.editProduct(id,productPutRequest);
        return mapperFromProductToProductGetRes( product );
    }

    private ProductGetResponse mapperFromProductToProductGetRes( Product product){
        if(product == null){
            return null;
        }
        return new ProductGetResponse(product.getId(), product.getDescription() , product.getName() , product.getPrice() , product.getCategories());
    }

}
