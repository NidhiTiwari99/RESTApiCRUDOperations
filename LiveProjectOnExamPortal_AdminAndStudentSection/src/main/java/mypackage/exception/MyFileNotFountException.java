package mypackage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyFileNotFountException extends RuntimeException {

	 public MyFileNotFountException (String message) {
	        super(message);
	    }

	    public MyFileNotFountException (String message, Throwable cause) {
	        super(message, cause);
	    }
}
