package Nithin.SplitWise.repository;

import Nithin.SplitWise.entity.SettlementTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SettlementTransactionRepository extends JpaRepository<SettlementTransaction, Integer> {
}
