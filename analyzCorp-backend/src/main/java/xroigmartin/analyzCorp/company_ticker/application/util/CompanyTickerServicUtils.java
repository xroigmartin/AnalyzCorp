package xroigmartin.analyzCorp.company_ticker.application.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import xroigmartin.analyzCorp.company_ticker.application.dto.CompanyTickerDTO;
import xroigmartin.analyzCorp.company_ticker.domain.model.CompanyTicker;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CompanyTickerServicUtils {

  public static CompanyTickerDTO convertCompanyTickerToDTO(CompanyTicker companyTicker) {
    return CompanyTickerDTO.builder()
      .cik(companyTicker.getCik())
      .ticker(companyTicker.getTicker())
      .title(companyTicker.getTitle())
      .build();
  }
}
