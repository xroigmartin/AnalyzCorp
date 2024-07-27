package xroigmartin.analyzCorp.company_ticker.infrastructure.db.postgres.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xroigmartin.analyzCorp.company_ticker.infrastructure.db.postgres.domain.model.CompanyTickerPostgresEntity;

public interface CompanyTickerPostgresRepository extends JpaRepository<CompanyTickerPostgresEntity, String> {
}
