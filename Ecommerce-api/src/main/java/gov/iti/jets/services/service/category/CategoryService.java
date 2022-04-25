package gov.iti.jets.services.service.category;

import gov.iti.jets.persistence.entity.Category;
import gov.iti.jets.persistence.repository.category.CategoryRepository;
import gov.iti.jets.services.dto.category.CategoryGetResponse;
import gov.iti.jets.services.dto.category.CategoryPostRequest;
import gov.iti.jets.services.dto.category.CategoryPutRequest;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    CategoryRepository categoryRepository = new CategoryRepository();
    public List<CategoryGetResponse> getAllCategory() {
        List<Category> allCategory = categoryRepository.getAllCategory();
        List<CategoryGetResponse> categories = new ArrayList<>();
        for ( Category category: allCategory ) {
            categories.add( mapperFromCategoryToCategoryGetRes( category ) );
        }
        return categories;
    }

    public String deleteAllCategory() {
       return categoryRepository.deleteAllCategory();
    }

    public CategoryGetResponse getCategoryById( int id ) {
        Category category = categoryRepository.getCategoryById(id);
        return mapperFromCategoryToCategoryGetRes( category );
    }

    public String deleteCategoryById( int id ) {
        return categoryRepository.deleteCategoryById(id);
    }

    public String addCategory( CategoryPostRequest categoryPostRequest ) {
        return categoryRepository.addCategory(categoryPostRequest.getName());
    }

    public CategoryGetResponse editCategory( CategoryPutRequest categoryPutRequest, int id ) {
        Category category = categoryRepository.editCategory(categoryPutRequest , id);
        return mapperFromCategoryToCategoryGetRes( category );
    }

    private CategoryGetResponse mapperFromCategoryToCategoryGetRes(Category category){
        if(category == null){
            return null;
        }
        return new CategoryGetResponse( category.getId(), category.getName() , category.getProducts());
    }

}
