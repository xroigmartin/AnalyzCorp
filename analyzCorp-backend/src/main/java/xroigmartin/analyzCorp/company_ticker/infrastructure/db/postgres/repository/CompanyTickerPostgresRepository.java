package xroigmartin.analyzCorp.company_ticker.infrastructure.db.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import xroigmartin.analyzCorp.company_ticker.infrastructure.db.postgres.model.CompanyTickerPostgresEntity;

public interface CompanyTickerPostgresRepository extends JpaRepository<CompanyTickerPostgresEntity, String>, JpaSpecificationExecutor {
}
