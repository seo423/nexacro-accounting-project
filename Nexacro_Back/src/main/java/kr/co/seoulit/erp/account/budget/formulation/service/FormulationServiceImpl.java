package kr.co.seoulit.erp.account.budget.formulation.service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.account.budget.formulation.entity.BudgetEntity;
import kr.co.seoulit.erp.account.budget.formulation.repository.BudgetRepository;
import kr.co.seoulit.erp.account.budget.formulation.to.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.seoulit.erp.account.budget.formulation.dao.FormulationMapper;

import javax.persistence.EntityManager;

@Service
@Transactional
public class FormulationServiceImpl implements FormulationService {


	private FormulationMapper formulationDAO;

	private BudgetRepository budgetRepository;

	private EntityManager em;


	public FormulationServiceImpl(FormulationMapper formulationDAO, BudgetRepository budgetRepository, EntityManager em) {
		this.formulationDAO = formulationDAO;
		this.budgetRepository = budgetRepository;
		this.em = em;
	}


	@Override
	public BudgetBean findBudget(BudgetBean bean) {

			bean = formulationDAO.selectBudget(bean);
		System.out.println("나옴");
		return bean;
	}

	@Override
	public ArrayList<BudgetBean>  findBudgetList(HashMap<String,String> map) {

		System.out.println("나옴1");
			return formulationDAO.selectBudgetList(map);

	}

	@Override
	public BudgetRequest budgetListForComp(HashMap<String, String> budgetMap) {

		BudgetRequest budgetRequest =  formulationDAO.findBudget(budgetMap);

		return budgetRequest;
	}

	@Override
	public BudgetRequestForRecon budgetRequestForRecon(BudgetRequestForRecon budgetRequestForRecon) {
		BudgetEntity budgetEntity = budgetRequestForRecon.toEntity();
		BudgetEntity findBudgetEntity = budgetRepository.findByBudgetRequest(budgetEntity);
		System.out.println("나옴3");
		return BudgetRequestForRecon.fromEntity(findBudgetEntity);
	}

	@Override
	public void compBudget(BudgetRequest updateRequest) {

		BudgetEntity updateEntity = updateRequest.toEntity();

		BudgetEntity findEmEntity = em.find(updateEntity.getClass(), updateEntity.budgetPK);

		System.out.println("나옴4");

		if (findEmEntity != null) {
			ModelMapper modelMapper = new ModelMapper();
			modelMapper.map(updateEntity, findEmEntity);
			em.persist(findEmEntity);
		}
		else {
			em.persist(updateEntity);
		}
	}

	@Override
	public void reconBudget(BudgetRequestForRecon updateRequest) {
		BudgetEntity updateEntity = updateRequest.toEntity();

		BudgetEntity findEmEntity = em.find(updateEntity.getClass(), updateEntity.budgetPK);
		System.out.println("나옴5");

		if (findEmEntity != null) {
			ModelMapper modelMapper = new ModelMapper();
			modelMapper.map(updateEntity, findEmEntity);
			em.persist(findEmEntity);
		}
		else {
			em.persist(updateEntity);
		}
	}

	public void batchBudgetCode(BudgetBean obj) {

		System.out.println("나옴7");
//		obj.getAccountInnerCode()
		formulationDAO.batchBudgetCode(obj);
	}

	public ArrayList<BudgetBean>  formationBudget(HashMap<String, String> map) {

		formulationDAO.formationBudget(map);
		System.out.println("나옴8");
		return formulationDAO.selectBudgetList(map);
	}

	@Override
	public ArrayList<BudgetStatusBean> findBudgetStatus(BudgetBean bean) {
		// TODO Auto-generated method stub

		HashMap<String, Object> map = new HashMap<>();
		map.put("accountPeriodNo", bean.getAccountPeriodNo());
		map.put("deptCode", bean.getDeptCode());
		map.put("workplaceCode", bean.getWorkplaceCode());
		formulationDAO.selectBudgetStatus(map);
		ArrayList<BudgetStatusBean> result = (ArrayList<BudgetStatusBean>) map.get("RESULT");
		System.out.println("나옴9");
		return result;
	}

	@Override
	public ArrayList<BudgetComparisonBean> findBudgetComparison(BudgetBean bean) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("accountPeriodNo", bean.getAccountPeriodNo());
		map.put("deptCode", bean.getDeptCode());
		map.put("workplaceCode", bean.getWorkplaceCode());
		map.put("accountInnerCode", bean.getAccountInnerCode());

		formulationDAO.selectComparisonBudget(map);
		ArrayList<BudgetComparisonBean> result = (ArrayList<BudgetComparisonBean>) map.get("RESULT");
		System.out.println("나옴10");
		return result;
	}

	@Override
	public ArrayList<BudgetBean> findBudgetAppl(BudgetBean bean) {
		// TODO Auto-generated method stub
		System.out.println("나옴11");
			return formulationDAO.selectBudgetAppl(bean);

	}
}
