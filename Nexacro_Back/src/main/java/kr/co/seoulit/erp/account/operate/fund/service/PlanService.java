package kr.co.seoulit.erp.account.operate.fund.service;

import kr.co.seoulit.erp.account.operate.fund.to.PlanBean;

import java.util.List;

public interface PlanService {

    // 자금계획 조회
    public List<PlanBean> findPlan(String startDate, String endDate) throws Exception;

    // 자금계획 추가
    public void insertPlan(PlanBean planBean) throws Exception;

    // 자금계획 수정
    public void updatePlan(PlanBean planBean) throws Exception;

    // 자금계획 삭제
    public void deletePlan(String planNo) throws Exception;
}
