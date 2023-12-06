package com.go.together.Mapper;

import com.go.together.Dto.ProductDto;
import com.go.together.Vo.CartVo;
import com.go.together.Vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

//    게시글 등록
    public int insertProduct(ProductDto productDto);

//    게시글 VIEW
    public List<ProductVo> selectProduct(Long productNumber);

//    게시글 리스트
    public List<ProductVo> selectAllProduct(ProductVo productVo);


    public int delete(Long productNumber);

    public void updateProduct(ProductDto productDto);

//    장바구니

//    장바구니 등록
    public int insertCart(CartVo cartVo);

//    장바구니 조회
    public List<CartVo> UserCart(CartVo cartVo);

//    장바구니 수량 증가
    public int addCart(CartVo cartVo);

//    장바구니 수량 변경
    public int updateCartPlus(CartVo cartVo);

//    장바구니 수량 감소
    public int minusCart(CartVo cartVo);

//    장바구니 상품 삭제
    public int deleteCart(Long cartNumber);





}
