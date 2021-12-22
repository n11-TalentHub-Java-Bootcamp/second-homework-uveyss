package com.example.entity;

import java.time.LocalDateTime;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "ProductComment")
@SequenceGenerator(schema = "public",name = "generator", sequenceName = "productcomment_id_seq")

public class ProductCommentEntity implements Serializable{

    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "CommentId", nullable = false)
    private long commentId;
    @Column(name = "Comment", nullable = false)
    private String comment;
    @Column(name = "CommentDate", nullable = false)
    private LocalDateTime commentDate;

    @ManyToOne
    @JoinColumn(name = "ProductId")
    private ProductEntity product;
    @ManyToOne
    @JoinColumn(name = "UserId")
    private UserEntity user;
    @Column(name = "Point", nullable = false)
    private int productPoint;

    public ProductCommentEntity() {
    }

    public ProductCommentEntity(long commentId, String comment, LocalDateTime commentDate, ProductEntity product, UserEntity user, int productPoint) {
        this.commentId = commentId;
        this.comment = comment;
        this.commentDate = commentDate;
        this.product = product;
        this.user = user;
        this.productPoint = productPoint;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDateTime commentDate) {
        this.commentDate = commentDate;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public int getProductPoint() {
        return productPoint;
    }

    public void setProductPoint(int productPoint) {
        this.productPoint = productPoint;
    }
}
