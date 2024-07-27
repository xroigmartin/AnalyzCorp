package xroigmartin.analyzCorp.company_ticker.infrastructure.db.postgres.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "company_ticker")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyTickerPostgresEntity implements Serializable {

  @Serial
  private static final long serialVersionUID = 5902573817618278295L;

  @Id
  private String ticker;
  private Long cik;
  private String title;
}
