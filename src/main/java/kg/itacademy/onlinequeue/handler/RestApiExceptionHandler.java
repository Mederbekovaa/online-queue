package kg.itacademy.onlinequeue.handler;

import kg.itacademy.onlinequeue.exceptions.UnknowException;
import kg.itacademy.onlinequeue.model.ErrorModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestApiExceptionHandler extends DefaultHandlerExceptionResolver {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        }

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(UnknowException.class)

    public ResponseEntity<ErrorModel> handleValidationExceptions(UnknowException ex) {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setMsg(ex.getMessage());
        errorModel.setExceptionClassName(UnknowException.class.toString());
        return ResponseEntity.status(ex.getStatus()).body(errorModel);
    }
}
