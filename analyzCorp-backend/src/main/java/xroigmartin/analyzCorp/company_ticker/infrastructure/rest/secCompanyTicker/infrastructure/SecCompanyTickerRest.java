package xroigmartin.analyzCorp.company_ticker.infrastructure.rest.secCompanyTicker.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import xroigmartin.analyzCorp.company_ticker.domain.model.CompanyTicker;
import xroigmartin.analyzCorp.company_ticker.infrastructure.rest.secCompanyTicker.domain.SecCompanyTicker;
import xroigmartin.analyzCorp.company_ticker.infrastructure.rest.secCompanyTicker.infrastructure.utils.SecCompanyTickerRestUtils;

import java.util.List;
import java.util.Map;

@Component
public class SecCompanyTickerRest {

  private static final String companiesTickersUrl = "https://www.sec.gov/files/company_tickers.json";

  private final ObjectMapper objectMapper;
  private final RestTemplate restTemplate;

  private final HttpHeaders httpHeaders;


  public SecCompanyTickerRest(ObjectMapper objectMapper, RestTemplate restTemplate) {
    this.objectMapper = objectMapper;
    this.restTemplate = restTemplate;
    this.httpHeaders = new HttpHeaders();
  }

  public List<CompanyTicker> getAllCompaniesTickers(){
    this.setHeaders();

    HttpEntity<String> entity = new HttpEntity<>(this.httpHeaders);

    ResponseEntity<String> response = this.restTemplate.exchange(companiesTickersUrl, HttpMethod.GET, entity, String.class);

    Map<String, SecCompanyTicker> secResponse;
    try {
      secResponse = objectMapper.readValue(response.getBody(), new TypeReference<>() {
      });
    }catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    return SecCompanyTickerRestUtils.convertListOfSecCompaneiesTickersToListOfCompanyTickers(secResponse.values().stream().toList());

  }

  private void setHeaders(){
    this.httpHeaders.add("User-Agent", "xroigmartin@gmail.com");
  }
}
