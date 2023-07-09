package Tuan2._LeNguyenDinhNguyen.service;

import Tuan2._LeNguyenDinhNguyen.entity.Category;
import Tuan2._LeNguyenDinhNguyen.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
    public Category getCateoryById( Long id){
        return categoryRepository.findById(id).orElseThrow(null);
    }
    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}