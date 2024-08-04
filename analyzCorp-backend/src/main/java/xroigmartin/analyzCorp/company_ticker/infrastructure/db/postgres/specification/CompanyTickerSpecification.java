package xroigmartin.analyzCorp.company_ticker.infrastructure.db.postgres.specification;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import xroigmartin.analyzCorp.company_ticker.infrastructure.db.postgres.model.CompanyTickerPostgresEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CompanyTickerSpecification {

  public static Specification<CompanyTickerPostgresEntity> findCompanies(String filter){
    return (root, query, criteriaBuilder) -> {
      String likeFilter = "%" + filter.toUpperCase() + "%";

      return criteriaBuilder.or(
        criteriaBuilder.like(criteriaBuilder.upper(root.get("ticker")), likeFilter),
        criteriaBuilder.like(criteriaBuilder.upper(root.get("title")), likeFilter)
      );

    };
  }
}
