package xroigmartin.analyzCorp.company_ticker.infrastructure.rest.secCompanyTicker.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SecCompanyTicker implements Serializable {

  @Serial
  private static final long serialVersionUID = 4520016786559062140L;

  private String ticker;
  private Long cik;
  private String title;
}
