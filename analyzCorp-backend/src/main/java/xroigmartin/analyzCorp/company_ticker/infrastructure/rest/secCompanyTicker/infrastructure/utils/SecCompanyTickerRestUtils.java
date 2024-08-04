package xroigmartin.analyzCorp.company_ticker.infrastructure.rest.secCompanyTicker.infrastructure.utils;

import xroigmartin.analyzCorp.company_ticker.domain.model.CompanyTicker;
import xroigmartin.analyzCorp.company_ticker.infrastructure.rest.secCompanyTicker.domain.model.SecCompanyTicker;

import java.util.List;

public final class SecCompanyTickerRestUtils {

  private SecCompanyTickerRestUtils() {}

  public static CompanyTicker convertSecCompanyTickerToCompanyTicker(SecCompanyTicker secCompanyTicker){
    return CompanyTicker.builder()
      .cik(secCompanyTicker.getCik_str())
      .ticker(secCompanyTicker.getTicker())
      .title(secCompanyTicker.getTitle())
      .build();
  }

  public static List<CompanyTicker> convertListOfSecCompaneiesTickersToListOfCompanyTickers(List<SecCompanyTicker> secResponse) {
    return secResponse.stream()
      .map(SecCompanyTickerRestUtils::convertSecCompanyTickerToCompanyTicker)
      .toList();
  }
}
