package xroigmartin.analyzCorp.shared.infrastructure.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Builder
public class ApiResponse<T> implements Serializable {
  @Serial
  private static final long serialVersionUID = 845576710509329655L;

  private int statusCode;
  private String info;
  private String path;
  private boolean success;
  private ApiError error;
  private T data;
  private Instant timestamp;
}
