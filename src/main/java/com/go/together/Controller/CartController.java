package com.go.together.Controller;


import com.go.together.Mapper.CartMapper;
import com.go.together.Service.CartService;
import com.go.together.Service.FileService;
import com.go.together.Vo.CartVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor


public class CartController {
    private final CartService cartService;
    private final FileService fileService;
    private final CartMapper cartMapper;


    @PostMapping("/addCart")
    public int addCart(@RequestBody CartVo cartVo) {
        int result = cartService.registerCart(cartVo);

        System.out.println(result + "장바구니 추가 결과값?");

        return result;
    }

    @PostMapping("/userCart")
    public List<CartVo> userCartList(@RequestBody CartVo cartvo) {
        Integer userNumber = cartvo.getUserNumber();

        List<CartVo> userCartInfo = cartService.userCartList(userNumber);
        System.out.println(userCartInfo + " 결과값 ~@!@!@!@!@");
        return userCartInfo;

    }


    @PostMapping("/getAllPrice")
    public CartVo getAllPrice(@RequestBody CartVo cartvo) {
        Integer userNumber = cartvo.getUserNumber();
        CartVo totalPrice = cartService.cartAllPrice(userNumber);
        return totalPrice;
    }


    @PostMapping("/plusCount")
    public int plusCount(@RequestBody CartVo cartVo) {
        Long cartNumber = cartVo.getCartNumber();
        int result = cartService.upCount(cartNumber);
        return result;
    }


    //수량변경
    @PostMapping("/changeCount")
    public int changeCount(@RequestBody CartVo cartVo) {
        int result = cartService.updateCount(cartVo);
        return result;
    }


    //   장바구니 사이즈와 색상변경
    @PostMapping("/cartChangeOption")
    public int cartChangeOption(@RequestBody CartVo cartVo) {
        int result = cartMapper.changeSizeColor(cartVo);
        return result;
    }


    //장바구니 카트 삭제
// 장바구니 카트 삭제
    @PostMapping("/deleteCart")
    public int deleteCart(@RequestBody Map<String, List<Long>> ArrayCartNumber) {
        List<Long> cartNumbers = ArrayCartNumber.get("cartNumber");

        int result = 0; // 초기화

        for (Long cartNumber : cartNumbers) {
            result = cartMapper.deleteCart(cartNumber);
            // 만약 deleteCart 메서드가 실패할 경우, 이후 반복문은 계속 진행됩니다.
        }

        System.out.println(result + "@@@@@@@@@@@@@@@@결과값 ??????");

        return result; // 마지막에 최종적으로 deleteCart 메서드의 결과 반환
    }


    //장바구니에서 결제제창 넘어갈때 원하는 장바구니 물품 골라서 결제창으로 넘어가는 URI
//    @PostMapping("/pickCart")
//    public List<CartVo> pickCart(@RequestBody Map<String, Object> requestBody) {
//        List<Object> cartNumbers = (List<Object>) requestBody.get("cartNumber");
//        List<Long> convertedCartNumbers = new ArrayList<>();
//
//        for (Object cartNumberObject : cartNumbers) {
//            if (cartNumberObject instanceof Long) {
//                convertedCartNumbers.add((Long) cartNumberObject);
//            } else if (cartNumberObject instanceof Integer) {
//                convertedCartNumbers.add(((Integer) cartNumberObject).longValue());
//            }
//            // 다른 타입에 대한 처리 추가 가능
//        }
//
//        Integer userNumber = Integer.parseInt(String.valueOf(requestBody.get("userNumber")));
//        System.out.println(userNumber+"pickCart 유저넘버 !!!!!!!");
//
//        List<CartVo> results = new ArrayList<>();
//        double totalCartPrice = 0.0;
//
//
//        for (Long cartNumber : convertedCartNumbers) {
//            List<CartVo> result = cartService.pickCartAll(cartNumber, userNumber);
//
//            // 각 장바구니 항목의 총 금액을 계산하고 결과 리스트에 추가
//            for (CartVo cart : result) {
//                cart.setTotalPrice(cart.getProductPrice() * cart.getCartCount());
//                totalCartPrice += cart.getTotalPrice(); // 총 금액 누적
//                cart.setTotalCartPrice(totalCartPrice); // totalCartPrice 설정
//
//            }
//
//            results.addAll(result);
//        }
//
//
//        System.out.println("총 장바구니 합계: " + totalCartPrice);
//
//        System.out.println(results+"결과값@#@#@!#@!#");
//        return results;
//    }

    @PostMapping("/pickCart")
    public List<CartVo> pickCart(@RequestBody Map<String, List<Long>> ArrayCartNumber) {
        List<Long> cartNumbers = ArrayCartNumber.get("cartNumber");

        List<CartVo> result = new ArrayList<>();


        for (Long cartNumber : cartNumbers) {
            List<CartVo> cartItems = cartService.pickCartAll(cartNumber);
            result.addAll(cartItems); // Add all items for the current cartNumber to the result list
        }

        System.out.println(result + "뽑은 장바구니 결과값 !!!!");
        return result;
    }
}