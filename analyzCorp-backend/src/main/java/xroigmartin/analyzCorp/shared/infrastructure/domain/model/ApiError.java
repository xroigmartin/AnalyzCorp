package xroigmartin.analyzCorp.shared.infrastructure.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Builder
public class ApiError implements Serializable {

  @Serial
  private static final long serialVersionUID = -4626162815253857937L;

  private String errorCode;
  private String detail;

}
