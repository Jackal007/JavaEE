package xmu.mystore.goodsmgt.zlt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="it is a test")
public class MyException extends RuntimeException{

}
