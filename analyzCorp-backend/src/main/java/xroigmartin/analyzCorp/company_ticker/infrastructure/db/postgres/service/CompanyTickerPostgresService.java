package xroigmartin.analyzCorp.company_ticker.infrastructure.db.postgres.service;

import org.springframework.stereotype.Component;
import xroigmartin.analyzCorp.company_ticker.domain.model.CompanyTicker;
import xroigmartin.analyzCorp.company_ticker.domain.repository.CompanyTickerRepository;
import xroigmartin.analyzCorp.company_ticker.infrastructure.db.postgres.service.utils.CompanyTickerPostgresUtils;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyTickerPostgresService implements CompanyTickerRepository {

  /*private final CompanyTickerPostgresRepository companyTickerPostgresRepository;

  public CompanyTickerPostgresService(CompanyTickerPostgresRepository companyTickerPostgresRepository) {
    this.companyTickerPostgresRepository = companyTickerPostgresRepository;
  }*/

  @Override
  public void synchronizeCompaniesTickers(List<CompanyTicker> companiesTickers) {

    var companiesTickersPostgres = companiesTickers.stream()
      .map(CompanyTickerPostgresUtils::convertCompanyTickerToCompanyTickerPostgresEntity)
      .collect(Collectors.toSet());

    //this.companyTickerPostgresRepository.saveAll(companiesTickersPostgres);
  }
}
