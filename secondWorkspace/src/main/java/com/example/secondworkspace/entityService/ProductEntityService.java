package com.example.entityService;
import com.example.dao.ProductDao;
import com.example.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductEntityService {
    @Autowired
    private ProductDao productDao;

    public List<ProductEntity> findAllProduct()
    {
        return productDao.findAll();
    }
    public ProductEntity findProductById(long productId)
    {
        Optional<ProductEntity> productEntity = Optional.ofNullable(productDao.findAllByProductId(productId));
        if(productEntity.isPresent())
        {
            return  productEntity.get();
        }
        return  null;
    }
}
