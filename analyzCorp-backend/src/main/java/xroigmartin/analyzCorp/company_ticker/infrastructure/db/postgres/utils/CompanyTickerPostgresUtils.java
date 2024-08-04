package xroigmartin.analyzCorp.company_ticker.infrastructure.db.postgres.utils;

import xroigmartin.analyzCorp.company_ticker.domain.model.CompanyTicker;
import xroigmartin.analyzCorp.company_ticker.infrastructure.db.postgres.model.CompanyTickerPostgresEntity;

public final class CompanyTickerPostgresUtils {

  private CompanyTickerPostgresUtils() {}

  public static CompanyTickerPostgresEntity convertCompanyTickerToCompanyTickerPostgresEntity(CompanyTicker companyTicker) {
    return CompanyTickerPostgresEntity.builder()
      .ticker(companyTicker.getTicker())
      .title(companyTicker.getTitle())
      .cik(companyTicker.getCik())
      .build();
  }

  public static CompanyTicker convertCompanyTickerPostgresEntityToCompanyTicker(CompanyTickerPostgresEntity companyTicker) {
    return CompanyTicker.builder()
      .ticker(companyTicker.getTicker())
      .title(companyTicker.getTitle())
      .cik(companyTicker.getCik())
      .build();
  }

}
