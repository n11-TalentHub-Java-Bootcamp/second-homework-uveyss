package com.example.entityService;
import com.example.dao.CategoryDao;
import com.example.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;




@Service
public class CategoryEntityService {
@Autowired
    private CategoryDao categoryDao;

    public List<CategoryEntity> findAll()
    {
        return (List<CategoryEntity>) categoryDao.findAll();
    }

    public CategoryEntity findAllById(long id)
    {
        Optional<CategoryEntity> categoryEntity= categoryDao.findAllByCategoryId(id);
        if(categoryEntity.isPresent())
        {
            return categoryEntity.get();
        }
        return null;
    }
}
