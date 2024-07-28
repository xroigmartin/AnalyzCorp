package xroigmartin.analyzCorp.company_ticker.domain.repository;

import org.springframework.data.domain.Page;
import xroigmartin.analyzCorp.company_ticker.domain.model.CompanyTicker;

import java.util.List;

public interface CompanyTickerRepository {

  void synchronizeCompaniesTickers(List<CompanyTicker> companiesTickers);

  Page<CompanyTicker> findCompanies(int page, int size, String filter);
}
