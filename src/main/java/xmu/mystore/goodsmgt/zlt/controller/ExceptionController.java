package xmu.mystore.goodsmgt.zlt.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import xmu.mystore.goodsmgt.zlt.exception.MyException;

@ControllerAdvice
public class ExceptionController {
	
	 @ExceptionHandler(value={MyException.class})  
	 public String pageError(){
		return "/zlt/allError";		 
	 }
	 @ExceptionHandler(value={MySQLIntegrityConstraintViolationException.class})  
	 public String sqlError(){
		return "/zlt/serical_code_duplicate";		 
	 }
	 
}
