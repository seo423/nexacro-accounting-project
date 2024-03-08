package kr.co.seoulit.erp.account.budget.formulation.repository;

import kr.co.seoulit.erp.account.budget.formulation.entity.BudgetEntity;
import org.springframework.stereotype.Repository;

@Repository
public class BudgetCustomRepositoryImpl implements BudgetCustomRepository {

    @Override
    public BudgetEntity findByBudgetRequest(BudgetEntity budgetEntity) {

        return null;
    }
}
