package com.example.dao;

import com.example.entity.ProductCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductCommentDao extends JpaRepository<ProductCommentEntity,Long> {

    @Query("Select pc.user.userName,pc.comment,pc.commentDate from ProductCommentEntity pc join UserEntity user on pc.user.userName=user.userName")
    Optional<List<ProductCommentEntity>> findUserCommentByUserName(String userName);
    @Query("Select product.productName,pc.comment,pc.commentDate from ProductCommentEntity pc join ProductEntity product on pc.product.productId=product.productId")
    Optional<List<ProductCommentEntity>> findProductCommentByProductId(Long productId);
}
