package xroigmartin.analyzCorp.company_ticker.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyTicker {

  private String ticker;
  private Long cik;
  private String title;
}
