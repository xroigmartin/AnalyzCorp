package xroigmartin.analyzCorp.company_ticker.interfaces.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xroigmartin.analyzCorp.company_ticker.application.service.CompanyTickerService;

@RestController
@RequestMapping("companies-tickers")
public class CompanyTickerRestController {

  private final CompanyTickerService companyTickerService;

  public CompanyTickerRestController(CompanyTickerService companyTickerService) {
    this.companyTickerService = companyTickerService;
  }

  @PostMapping("/synchronize")
  public ResponseEntity<Void> synchronizeCompaniesTickers(){
    this.companyTickerService.synchronizeCompaniesTickers();
    return ResponseEntity.ok().body(null);
  }

}
