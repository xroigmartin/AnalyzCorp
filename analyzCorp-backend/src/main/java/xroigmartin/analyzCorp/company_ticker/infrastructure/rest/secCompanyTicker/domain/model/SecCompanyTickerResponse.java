package xroigmartin.analyzCorp.company_ticker.infrastructure.rest.secCompanyTicker.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SecCompanyTickerResponse implements Serializable {

  @Serial
  private static final long serialVersionUID = 3281635466695199107L;

  private Map<String, SecCompanyTicker> data;
}
