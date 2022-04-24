package gov.iti.jets.services.category.impl;

import gov.iti.jets.persistence.entity.Category;
import gov.iti.jets.persistence.repository.category.CategoryRepository;
import gov.iti.jets.services.category.CategoryService;
import gov.iti.jets.services.category.dto.CategoryGetResponse;
import gov.iti.jets.services.category.dto.CategoryPostRequest;
import gov.iti.jets.services.category.dto.CategoryPutRequest;
import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "gov.iti.jets.services.category.CategoryService")
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository = new CategoryRepository();

    @Override
    public List<CategoryGetResponse> getAllCategory() {
        List<Category> allCategory = categoryRepository.getAllCategory();
        List<CategoryGetResponse> categories = new ArrayList<>();
        for ( Category category: allCategory ) {
            categories.add( mapperFromCategoryToCategoryGetRes( category ) );
        }
        return categories;
    }

    @Override
    public String deleteAllCategory() {
        return categoryRepository.deleteAllCategory();
    }

    @Override
    public CategoryGetResponse getCategoryById( int id ) {
        Category category = categoryRepository.getCategoryById(id);
        return mapperFromCategoryToCategoryGetRes( category );
    }

    @Override
    public String deleteCategoryById( int id ) {
        return categoryRepository.deleteCategoryById(id);
    }

    @Override
    public String addCategory( CategoryPostRequest categoryPostRequest ) {
        return categoryRepository.addCategory(categoryPostRequest.getName());
    }

    @Override
    public CategoryGetResponse editCategory( CategoryPutRequest categoryPutRequest, int id ) {
        Category category = categoryRepository.editCategory(categoryPutRequest , id);
        return mapperFromCategoryToCategoryGetRes( category );
    }

    private CategoryGetResponse mapperFromCategoryToCategoryGetRes(Category category){
        return new CategoryGetResponse( category.getId(), category.getName() , category.getProducts());
    }
}
