package xroigmartin.analyzCorp.company_ticker.infrastructure.db.postgres.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import xroigmartin.analyzCorp.company_ticker.domain.model.CompanyTicker;
import xroigmartin.analyzCorp.company_ticker.domain.repository.CompanyTickerRepository;
import xroigmartin.analyzCorp.company_ticker.infrastructure.db.postgres.model.CompanyTickerPostgresEntity;
import xroigmartin.analyzCorp.company_ticker.infrastructure.db.postgres.repository.CompanyTickerPostgresRepository;
import xroigmartin.analyzCorp.company_ticker.infrastructure.db.postgres.specification.CompanyTickerSpecification;
import xroigmartin.analyzCorp.company_ticker.infrastructure.db.postgres.utils.CompanyTickerPostgresUtils;

import java.util.List;

@Component
@Transactional
public class CompanyTickerPostgresService implements CompanyTickerRepository {

  private final CompanyTickerPostgresRepository companyTickerPostgresRepository;

  public CompanyTickerPostgresService(CompanyTickerPostgresRepository companyTickerPostgresRepository) {
    this.companyTickerPostgresRepository = companyTickerPostgresRepository;
  }

  @Override
  public void synchronizeCompaniesTickers(List<CompanyTicker> companiesTickers) {

    var companiesTickersPostgres = companiesTickers.stream()
      .map(CompanyTickerPostgresUtils::convertCompanyTickerToCompanyTickerPostgresEntity)
      .toList();

    this.companyTickerPostgresRepository.saveAll(companiesTickersPostgres);
  }

  @Override
  public Page<CompanyTicker> findCompanies(int page, int size, String filter) {

   var pageable = PageRequest.of(page, size,Sort.by(Sort.Direction.ASC, "title"));

    Specification<CompanyTickerPostgresEntity> spec = CompanyTickerSpecification.findCompanies(filter);

    Page<CompanyTickerPostgresEntity> companiesPostgresPage = this.companyTickerPostgresRepository.findAll(spec, pageable);

    return companiesPostgresPage.map(CompanyTickerPostgresUtils::convertCompanyTickerPostgresEntityToCompanyTicker);

  }


}
