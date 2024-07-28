package xroigmartin.analyzCorp.company_ticker.interfaces.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xroigmartin.analyzCorp.company_ticker.application.dto.CompanyTickerDTO;
import xroigmartin.analyzCorp.company_ticker.application.service.CompanyTickerService;
import xroigmartin.analyzCorp.shared.infrastructure.domain.model.ApiResponse;
import xroigmartin.analyzCorp.shared.infrastructure.domain.model.pagination.PageResponse;
import xroigmartin.analyzCorp.shared.infrastructure.domain.utils.ApiResponseHandler;
import xroigmartin.analyzCorp.shared.infrastructure.domain.utils.ResponseEntityHandler;

import java.util.List;

@RestController
@RequestMapping("companies-tickers")
public class CompanyTickerRestController {

    private final CompanyTickerService companyTickerService;

    public CompanyTickerRestController(CompanyTickerService companyTickerService) {
      this.companyTickerService = companyTickerService;
    }

    @PostMapping("/synchronize")
    public ResponseEntity<Void> synchronizeCompaniesTickers() {
      this.companyTickerService.synchronizeCompaniesTickers();
      return ResponseEntity.ok().body(null);
    }

    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<PageResponse<List<CompanyTickerDTO>>>> findCompanyTickers(@RequestParam(name="page", defaultValue = "0") int page,
                                                                                          @RequestParam(name="size", defaultValue = "10") int size,
                                                                                          @RequestParam(name = "q") String query){
      var pageResponse = this.companyTickerService.findCompanies(page, size, query);

      var apiResponse = ApiResponseHandler.<PageResponse<List<CompanyTickerDTO>>>builder().generate(pageResponse, "RETURN_COMPANIES_TICKERS", HttpStatus.OK.value());

      return ResponseEntityHandler.<PageResponse<List<CompanyTickerDTO>>>builder().generate(apiResponse, HttpStatus.OK);
    }

}
