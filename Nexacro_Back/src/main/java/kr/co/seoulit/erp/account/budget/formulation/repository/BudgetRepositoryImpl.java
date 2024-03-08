package kr.co.seoulit.erp.account.budget.formulation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class BudgetRepositoryImpl{

    @Autowired
    EntityManager em;

    public BudgetRepositoryImpl(EntityManager em) {
        this.em = em;
    }


}
