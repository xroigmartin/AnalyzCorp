package xroigmartin.analyzCorp.company_ticker.application.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CompanyTickerDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = -1852038292552753447L;

  private final String ticker;
  private final Long cik;
  private final String title;

}
