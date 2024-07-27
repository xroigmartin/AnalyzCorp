package xroigmartin.analyzCorp.company_ticker.domain.repository;

import xroigmartin.analyzCorp.company_ticker.domain.model.CompanyTicker;

import java.util.List;

public interface CompanyTickerRepository {

  void synchronizeCompaniesTickers(List<CompanyTicker> companiesTickers);
}
