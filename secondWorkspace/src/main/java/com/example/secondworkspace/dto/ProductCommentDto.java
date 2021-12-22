package com.example.dto;

import java.util.Date;

public class ProductCommentDto {

    private String userName;
    private Long productId;
    private Long userId;
    private String comment;
    private Date commenDate;
    private int productPoint;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommenDate() {
        return commenDate;
    }

    public void setCommenDate(Date commenDate) {
        this.commenDate = commenDate;
    }

    public int getProductPoint() {
        return productPoint;
    }

    public void setProductPoint(int productPoint) {
        this.productPoint = productPoint;
    }


}
