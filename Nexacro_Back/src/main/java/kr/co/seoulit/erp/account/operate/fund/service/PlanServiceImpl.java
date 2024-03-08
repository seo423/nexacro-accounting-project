package kr.co.seoulit.erp.account.operate.fund.service;

import kr.co.seoulit.erp.account.operate.fund.dao.PlanDAO;
import kr.co.seoulit.erp.account.operate.fund.to.PlanBean;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService{

    @Autowired
    private PlanDAO planDAO;

    // 자금계획 조회
    @Override
    public List<PlanBean> findPlan(String startDate, String endDate) throws Exception {

        List<PlanBean> selectPlanList = planDAO.findPlan(startDate, endDate);
        return selectPlanList;
    }

    // 자금계획 추가
    @Override
    public void insertPlan(PlanBean planBean) throws Exception {
        System.out.println("자금계획 추가 " + planBean);

        StringBuffer planNo = new StringBuffer();
        String planNoDate = planBean.getPlanDate();
        planNo.append(planNoDate);
        planNo.append("PLAN"); // 20240123PLAN

        String lastNo = planDAO.getPlanMaxNo(planNoDate);
        if (lastNo == null){
            lastNo = "00000";
        }
        int length = lastNo.length();

        String code = "0000" + (Integer.parseInt(lastNo.substring(length - 5)) + 1) + "";
        planNo.append(code.substring(code.length() - 5)); // 20231116SLIP00001
        planBean.setPlanNo(planNo.toString());

        String plandate = planBean.getPlanDate();
        SimpleDateFormat dtFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date formatDate = dtFormat.parse(plandate);
        // Date타입의 변수를 새롭게 지정한 포맷으로 변환
        String strNewDtFormat = newDtFormat.format(formatDate);
        System.out.println(strNewDtFormat);

        planBean.setPlanDate(strNewDtFormat);

        planDAO.insertPlan(planBean);
    }

    // 자금계획 수정
    @Override
    public void updatePlan(PlanBean planBean) throws Exception {
        planDAO.updatePlan(planBean);
    }

    // 자금계획 삭제
    @Override
    public void deletePlan(String planNo) throws Exception {
        planDAO.deletePlan(planNo);
    }
}
