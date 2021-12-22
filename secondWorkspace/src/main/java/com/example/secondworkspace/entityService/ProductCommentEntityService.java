package com.example.entityService;

import com.example.dao.ProductCommentDao;
import com.example.entity.ProductCommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
@Service
public class ProductCommentEntityService {
    @Autowired
    private ProductCommentDao productCommentDao;

    public Optional<List<ProductCommentEntity>> findUserCommentByUserName(String userName)
    {
        return  productCommentDao.findUserCommentByUserName(userName);
    }

    public Optional<List<ProductCommentEntity>> findProductCommentByProductId(Long productId)
    {
        return  productCommentDao.findProductCommentByProductId(productId);
    }
    public void Save(ProductCommentEntity productCommentEntity)
    {
        productCommentDao.save(productCommentEntity);
    }
    public void deleteCommentById(Long commentId)
    {
        productCommentDao.deleteById(commentId);
    }
}
