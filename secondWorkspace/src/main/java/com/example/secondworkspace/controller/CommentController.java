package com.example.controller;

import com.example.converter.CommentConverter;
import com.example.converter.UserConverter;
import com.example.dto.ProductCommentDto;
import com.example.entity.ProductCommentEntity;
import com.example.entity.UserEntity;
import com.example.entityService.ProductCommentEntityService;
import com.example.exceptionHandler.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

  @Autowired
    private ProductCommentEntityService  productCommentEntityService;

    @GetMapping("/{userName}")
    public List<ProductCommentDto> findUserComment(@PathVariable String userName)
    {
        Optional<List<ProductCommentEntity>> productCommentEntityList = productCommentEntityService.findUserCommentByUserName(userName);
        if(!productCommentEntityList.isPresent() || productCommentEntityList.get().size()<=0)
        {
            throw new UserNotFoundException(userName+" Kullanıcısı henüz bir yorum yazmamıştır.");
        }
        return  CommentConverter.INSTANCE.convertProductCommentEntityListToProductCommentDtoList(productCommentEntityList.get());
    }


    @GetMapping("/product/{productId}")
    public List<ProductCommentDto> findUserComment(@PathVariable Long productId)
    {
        Optional<List<ProductCommentEntity>> productCommentEntityList = productCommentEntityService.findProductCommentByProductId(productId);
        if(!productCommentEntityList.isPresent() || productCommentEntityList.get().size()<=0)
        {
            throw new UserNotFoundException(productId.toString()+" ürününe henüz bir yorum yazılmamıştır.");
        }
        return  CommentConverter.INSTANCE.convertProductCommentEntityListToProductCommentDtoList(productCommentEntityList.get());
    }

    @PostMapping()
    public void saveComment(@RequestBody ProductCommentDto productCommentDto)
    {
        ProductCommentEntity productCommentEntity =CommentConverter.INSTANCE.convertProductCommentDtoToProductCommentEntity(productCommentDto);
        productCommentEntityService.Save(productCommentEntity);
    }

    @DeleteMapping()
    public void deleteCommentById(@PathVariable Long commentId)
    {
        productCommentEntityService.deleteCommentById(commentId);
    }
}
