package kr.co.seoulit.erp.account.operate.fund.dao;

import kr.co.seoulit.erp.account.operate.fund.to.PlanBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlanDAO {

    // 당일 마지막 계획번호 조회
    public String getPlanMaxNo(String today);

    // 자금계획 조회
    public List<PlanBean> findPlan(String startDate, String endDate);

    // 자금계획 추가
    public void insertPlan(PlanBean planBean);

    // 자금계획 수정
    public void updatePlan(PlanBean planBean);

    // 자금계획 삭제
    public void deletePlan(String planNo);
}
