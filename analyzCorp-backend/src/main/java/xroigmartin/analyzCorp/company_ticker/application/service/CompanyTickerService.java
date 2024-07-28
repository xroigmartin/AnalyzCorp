package xroigmartin.analyzCorp.company_ticker.application.service;

import org.springframework.stereotype.Service;
import xroigmartin.analyzCorp.company_ticker.application.dto.CompanyTickerDTO;
import xroigmartin.analyzCorp.company_ticker.application.util.CompanyTickerServicUtils;
import xroigmartin.analyzCorp.company_ticker.domain.repository.CompanyTickerRepository;
import xroigmartin.analyzCorp.company_ticker.infrastructure.rest.secCompanyTicker.infrastructure.SecCompanyTickerRest;
import xroigmartin.analyzCorp.shared.infrastructure.domain.model.pagination.PageResponse;

import java.util.List;

@Service
public class CompanyTickerService {

  public final CompanyTickerRepository companyTickerRepository;
  public final SecCompanyTickerRest companyTickerRest;

  public CompanyTickerService(CompanyTickerRepository repository, SecCompanyTickerRest companyTickerRest) {
    this.companyTickerRepository = repository;
    this.companyTickerRest = companyTickerRest;
  }

  public void synchronizeCompaniesTickers(){

    var companiesTickers = companyTickerRest.getAllCompaniesTickers();

    this.companyTickerRepository.synchronizeCompaniesTickers(companiesTickers);
  }

  public PageResponse<List<CompanyTickerDTO>> findCompanies(int page, int size, String query){
    var companiesPage = this.companyTickerRepository.findCompanies(page, size, query);

    return PageResponse.<List<CompanyTickerDTO>>builder()
      .data(companiesPage.stream().map(CompanyTickerServicUtils::convertCompanyTickerToDTO).toList())
      .totalItems(companiesPage.getTotalElements())
      .totalPages(companiesPage.getTotalPages())
      .currentPage(page)
      .currentSize(size)
      .build();
  }

}
