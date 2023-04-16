package kodlama.io.rentacar.core.configuration;

import jakarta.servlet.http.HttpServletRequest;
import kodlama.io.rentacar.core.exceptions.BusinessException;
import kodlama.io.rentacar.core.exceptions.EntityAlreadyExistsException;
import kodlama.io.rentacar.core.exceptions.EntityNotFoundException;
import kodlama.io.rentacar.core.utils.ExceptionResult;
import kodlama.io.rentacar.core.utils.ValidExceptionResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResult entityNotFoundExceptionHandler(EntityNotFoundException e, HttpServletRequest request){
        return getExceptionResponse(e, request,HttpStatus.NOT_FOUND.toString());
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResult entityAlreadyExistsExceptionHandler(EntityAlreadyExistsException e, HttpServletRequest request){
        return getExceptionResponse(e, request,HttpStatus.ALREADY_REPORTED.toString());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionResult validExceptionHandler(MethodArgumentNotValidException e, HttpServletRequest request){
        ValidExceptionResult result = new ValidExceptionResult(HttpStatus.BAD_REQUEST.toString(),
                "Valid Exception Error",
                request.getServletPath(),
                LocalDateTime.now());

        result.setErrors(e.getBindingResult());

        return result;
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResult entityNotFoundExceptionHandler(BusinessException e, HttpServletRequest request){
        return getExceptionResponse(e, request,HttpStatus.NOT_FOUND.toString());
    }

    private ExceptionResult getExceptionResponse(RuntimeException e,
                                                 HttpServletRequest request,
                                                 String status){
        return new ExceptionResult(status,e.getMessage(),request.getServletPath(),LocalDateTime.now());
    }
}
