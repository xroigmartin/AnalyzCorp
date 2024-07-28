package xroigmartin.analyzCorp.shared.infrastructure.domain.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import xroigmartin.analyzCorp.shared.infrastructure.domain.model.ApiError;
import xroigmartin.analyzCorp.shared.infrastructure.domain.model.ApiResponse;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

   @ExceptionHandler({UnsupportedOperationException.class})
   public ResponseEntity<ApiResponse<ApiError>> unsupportedMethodException(Exception ex, WebRequest request){
    var apiResponse = ApiResponseHandler.builder().generateApiError(this.generateApiError("METHOD_NOT_ALLOWED", ex.getMessage(), request), HttpStatus.METHOD_NOT_ALLOWED.value());
    return ResponseEntityHandler.<ApiError>builder().generate(apiResponse, HttpStatus.METHOD_NOT_ALLOWED);
   }

  protected ApiError generateApiError(String errorCode, String detail, WebRequest request){
    return ApiError.builder()
    .errorCode(errorCode)
    .detail(detail)
    .build();
  }

}
