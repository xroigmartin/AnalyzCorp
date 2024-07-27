package xroigmartin.analyzCorp.company_ticker.infrastructure.db.postgres.service.utils;

import xroigmartin.analyzCorp.company_ticker.domain.model.CompanyTicker;
import xroigmartin.analyzCorp.company_ticker.infrastructure.db.postgres.domain.model.CompanyTickerPostgresEntity;

public final class CompanyTickerPostgresUtils {

  private CompanyTickerPostgresUtils() {}

  public static CompanyTickerPostgresEntity convertCompanyTickerToCompanyTickerPostgresEntity(CompanyTicker companyTicker) {
    return CompanyTickerPostgresEntity.builder()
      .ticker(companyTicker.getTitle())
      .title(companyTicker.getTitle())
      .cik(companyTicker.getCik())
      .build();
  }

}
