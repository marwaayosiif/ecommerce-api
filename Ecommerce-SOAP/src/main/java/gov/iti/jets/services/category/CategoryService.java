package gov.iti.jets.services.category;

import gov.iti.jets.services.category.dto.CategoryGetResponse;
import gov.iti.jets.services.category.dto.CategoryPostRequest;
import gov.iti.jets.services.category.dto.CategoryPutRequest;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface CategoryService {
    @WebMethod
    List<CategoryGetResponse> getAllCategory();
    @WebMethod
    String deleteAllCategory();
    @WebMethod
    CategoryGetResponse getCategoryById(int id);
    @WebMethod
    String deleteCategoryById( int id );
    @WebMethod
    String addCategory( CategoryPostRequest categoryPostRequest );
    @WebMethod
    CategoryGetResponse editCategory( CategoryPutRequest categoryPutRequest, int id );
}
