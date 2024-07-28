package xroigmartin.analyzCorp.shared.infrastructure.domain.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import xroigmartin.analyzCorp.shared.infrastructure.domain.model.ApiResponse;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ResponseEntityHandler {
  public static <T> ResponseEntityHandlerBuilder<T> builder(){
    return new ResponseEntityHandlerBuilder<>();
  }

  public static class ResponseEntityHandlerBuilder<T>{

      ResponseEntityHandlerBuilder(){}

      public ResponseEntity<ApiResponse<T>> generate(ApiResponse<T> apiResponse, HttpStatus status){
        return new ResponseEntity<>(apiResponse, status);
      }

  }

}
