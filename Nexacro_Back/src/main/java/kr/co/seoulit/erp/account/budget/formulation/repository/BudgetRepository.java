package kr.co.seoulit.erp.account.budget.formulation.repository;

import kr.co.seoulit.erp.account.budget.formulation.entity.BudgetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface BudgetRepository extends JpaRepository<BudgetEntity, String>, BudgetCustomRepository{

    @Override
    BudgetEntity findByBudgetRequest(@Param("budgetEntity") BudgetEntity budgetEntity);
}
