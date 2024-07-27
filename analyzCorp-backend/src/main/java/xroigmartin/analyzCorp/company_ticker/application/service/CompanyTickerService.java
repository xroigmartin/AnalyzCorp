package xroigmartin.analyzCorp.company_ticker.application.service;

import org.springframework.stereotype.Service;
import xroigmartin.analyzCorp.company_ticker.domain.repository.CompanyTickerRepository;
import xroigmartin.analyzCorp.company_ticker.infrastructure.rest.secCompanyTicker.infrastructure.SecCompanyTickerRest;

@Service
public class CompanyTickerService {

  public final CompanyTickerRepository repository;
  public final SecCompanyTickerRest companyTickerRest;

  public CompanyTickerService(CompanyTickerRepository repository, SecCompanyTickerRest companyTickerRest) {
    this.repository = repository;
    this.companyTickerRest = companyTickerRest;
  }

  public void synchronizeCompaniesTickers(){

    var companiesTickers = companyTickerRest.getAllCompaniesTickers();

    companiesTickers.forEach(System.out::println);
    //this.repository.synchronizeCompaniesTickers(companiesTickers);
  }
}
