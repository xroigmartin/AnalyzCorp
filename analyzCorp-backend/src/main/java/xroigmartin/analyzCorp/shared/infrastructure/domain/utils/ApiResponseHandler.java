package xroigmartin.analyzCorp.shared.infrastructure.domain.utils;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import xroigmartin.analyzCorp.shared.infrastructure.domain.model.ApiError;
import xroigmartin.analyzCorp.shared.infrastructure.domain.model.ApiResponse;

import java.time.Instant;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiResponseHandler {

  public static <T> ApiResponseHandler.ApiResponseHandlerBuilder<T> builder() {
    return new ApiResponseHandler.ApiResponseHandlerBuilder<>();
  }

  public static class ApiResponseHandlerBuilder<T> {

    ApiResponseHandlerBuilder() {
    }

    public ApiResponse<T> generate(T data, String infoMessage, int statusCode) {

      HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

      return ApiResponse.<T>builder()
        .info(infoMessage)
        .data(data)
        .path(request.getRequestURI())
        .success(Boolean.TRUE)
        .statusCode(statusCode)
        .timestamp(Instant.now())
        .build();
    }

    public ApiResponse<ApiError> generateApiError(ApiError apiError, int statusCode) {
      HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
      return ApiResponse.<ApiError>builder()
        .info("REQUEST_ERROR")
        .error(apiError)
        .data(null)
        .path(request.getRequestURI())
        .success(Boolean.FALSE)
        .statusCode(statusCode)
        .timestamp(Instant.now())
        .build();
    }

  }
}
