package com.go.together.Vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Data
@Slf4j
@NoArgsConstructor
public class CartVo {

    private long cartNumber;
    private int userNumber;
    private String userId;
    private long productNumber;
    private int cartCount;
    private String productName;
    private String productColor;
    private String productSize;
    private int productQuantity;
    private Double productPrice;
    private Double totalPrice;
    private Double totalCount;
    private String fileName;
    private String fileUploadPath;
    private String fileUuid;

}