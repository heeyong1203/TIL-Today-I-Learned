package com.sinse.mall.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sinse.mall.exception.CartException;

//각 컨트롤러에 명시된 예외처리 어노테이션인 @ExceptionHandler를 이 클래스에서 공통적으로 처리한다.
//이를 위해 @ControllerAdvice를 이용하면 된다.
//Controller, RestController (모든 메서드에 @ResponseBody)
@ControllerAdvice
public class ShopGlobalExceptionHandler {
		
	//장바구니 등록관련 실패처리
	@ExceptionHandler({CartException.class})
	public ResponseEntity<Map<String, Object>> handle(CartException e){
		
		Map<String, Object> result = new HashMap<>();
		result.put("msg", e.getMessage());
		
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
}
