package kr.co.seoulit.erp.account.posting.business.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import kr.co.seoulit.erp.account.posting.business.dto.*;
import kr.co.seoulit.erp.account.posting.business.mapstruct.*;
import kr.co.seoulit.erp.account.posting.business.entity.JournalDetailEntity;
import kr.co.seoulit.erp.account.posting.business.entity.JournalEntity;
import kr.co.seoulit.erp.account.posting.business.entity.SlipEntity;
import kr.co.seoulit.erp.account.posting.business.dao.JournalMapper;
import kr.co.seoulit.erp.account.posting.business.dao.SlipApprovalAndReturnMapper;
import kr.co.seoulit.erp.account.posting.business.dao.SlipMapper;
import kr.co.seoulit.erp.account.sys.common.mapstruct.EntityReqMapper;
import org.springframework.stereotype.Service;

import kr.co.seoulit.erp.account.posting.business.repository.JournalDetailRepository;
import kr.co.seoulit.erp.account.posting.business.repository.SlipRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BusinessServiceImpl implements BusinessService {

    private final JournalMapper journalDAO;
    private final SlipMapper slipDAO;
    private final SlipApprovalAndReturnMapper slipApprovalAndReturnDAO;
    private final JournalDetailRepository journalDetailRepository;
    private final SlipRepository slipRepository;
    private final SlipResMapstruct slipResmapstruct;
    private final SlipReqMapstruct slipReqMapstruct;
    private final JournalReqMapstruct journalReqMapstruct;
    private final JournalResMapstruct journalResMapstruct;
    private final JournalDetailReqMapstruct journalDetailReqMapstruct;

    //전표 조회
    @Override
    public ArrayList<SlipresDto> findRangedSlipList(HashMap<String, Object> params) {
        List<SlipEntity> slipEntityList = slipDAO.selectRangedSlipList(params);
        return (ArrayList< SlipresDto>) slipResmapstruct.toDto(slipEntityList);
    }


    //전표추가
    public void addSlip(SlipEntity slipObj, ArrayList<JournalEntity> journalBeans, ArrayList<JournalDetailEntity> journalDetail) {

        StringBuffer slipNo = new StringBuffer();
        String slipNoDate = slipObj.getReportingDate().replace("-", "");

        // 전표번호 생성
        slipNo.append(slipNoDate); //20200118
        slipNo.append("SLIP"); // 20200118SLIP

        slipNoDate = "%"+slipNoDate+"%";
        String code = "0000" + (slipRepository.countByDate(slipNoDate) + 1) + ""; // 00001 //오늘 작성한 전표의 카운터 +1

        slipNo.append(code.substring(code.length() - 5));   // 00001 - 5자리로 맞춰줌
        String slipNum = slipNo.toString();

        slipObj.setSlipNo(slipNum); //20200118SLIP00001
        slipRepository.persistSlip(slipObj); // slipBean 저장!

        String journalNo = journalDAO.selectJournalName(slipNum);
        // 20180401SLIP00001JOURNAL0 분개일련번호 생성. 저장된 분개가 있을 경우 +1을 한 숫자, 없을 경우 0을 반환한다.

        int jnum =  Integer.parseInt(journalNo.substring(24)); // 끝 번호를 가져옴


        for (JournalEntity journalBean : journalBeans) {
            String journalNum = slipNum +"JOURNAL"+ jnum++;

            journalBean.setJournalNo(journalNum);
            journalBean.setSlipNo(slipNum);
            journalDAO.insertJournal(journalBean);

            for(JournalDetailEntity journalDetailBean : journalDetail) {
                if(Objects.equals(journalBean.getAccountName(), journalDetailBean.getAccountName())) {
                    journalDetailBean.setJournalNo(journalNum);
                    journalDAO.insertJournalDetailList(journalDetailBean);
                }
                }
        }
    }

    //전표수정
    @Override
    public String modifySlip(SlipreqDto slipreqdtos, ArrayList<JournalreqDto> journalreqdtos, ArrayList<JournalDetailreqDto> journaldetailreqdtos) {
        SlipEntity slipEntity = slipReqMapstruct.toEntity(slipreqdtos);
        slipRepository.mergeSlip(slipEntity);
        System.out.println("journalreqdtos💕💕💕 = " + journalreqdtos);
        System.out.println("journaldetailreqdtos💕💕💕 = " + journaldetailreqdtos);

        for (JournalreqDto journalreqDto : journalreqdtos) {
            JournalEntity journalEntity = journalReqMapstruct.toEntity(journalreqDto);
            journalDAO.updateJournal(journalEntity);
        }

        for(JournalDetailreqDto journaldetailreqDto : journaldetailreqdtos) {
            JournalDetailEntity journaldetailEntity = journalDetailReqMapstruct.toEntity(journaldetailreqDto);
            journalDAO.updateJournalDetail(journaldetailEntity);
        }

        return slipEntity.getSlipNo();
    }

    @Override
    public String modifyJournalDetail(JournalDetailEntity journalDetailEntity) {

        String dName=null;
        boolean findSelect;
        boolean findSearch;

        String journalDetailNo = journalDetailEntity.getJournalDetailNo();
        String accountControlType = journalDetailEntity.getAccountControlType();
        // "==" 비교 연산자는 주소값을 비교하고
        // equals() 메소드는 내용 자체 즉 데이터 값을 비교한다
        findSelect = accountControlType.equals("SELECT");
        findSearch = accountControlType.equals("SEARCH");

        System.out.println("accountControlType: "+accountControlType);
        System.out.println("findSelect: "+findSelect);


        System.out.println("findSearch: "+findSearch);

        journalDAO.updateJournalDetail(journalDetailEntity); //분개번호로 내용만 업데이트함
        if(findSelect || findSearch)
            dName = journalDAO.selectJournalDetailDescriptionName(journalDetailNo);

        return dName;
    }

    @Override
    public ArrayList<JournalDetailresDto> findJournalDetailList(String fromDate, String toDate) {
        return journalDAO.selectJournalDetailList(fromDate, toDate);
    }

    public ArrayList<JournalDetailEntity> detailAccountList(String accountCode){

        ArrayList<JournalDetailEntity> List = journalDAO.detailAccountList(accountCode);

        return List;
    }
    @Override
    public ArrayList<JournalEntity> findSingleJournalList(String slipNo) {

        ArrayList<JournalEntity> journalList = null;
        journalList = journalDAO.selectJournalList(slipNo);

        return journalList;
    }
    @Override
    public ArrayList<JournalresDto> findRangedJournalList(String fromDate, String toDate) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("fromDate", fromDate);
        map.put("toDate", toDate);
        List<JournalEntity> journalentitylist = journalDAO.selectRangedJournalList(map);

        return (ArrayList<JournalresDto>) journalResMapstruct.toDto(journalentitylist);
    }
    @Override
    public void removeJournal(String journalNo) {

        journalDAO.deleteJournal(journalNo);
        journalDAO.deleteJournalDetailByJournalNo(journalNo);
    }

    @Override
    public void modifyJournal(String slipNo, ArrayList<JournalEntity> journalBeanList) {

        for (JournalEntity journalEntity : journalBeanList) {
            System.out.println("journal status:"+journalEntity.getStatus());
            if (journalEntity.getStatus().equals("insert"))
                journalDAO.insertJournal(journalEntity);
            else if (journalEntity.getStatus().equals("update")) {
                boolean isChangeAccountCode = journalDAO.updateJournal(journalEntity);  // boolean 반환형 필요없음. 항상 false 반환됨. 예전코드에서 수정된듯(dong)

                /* 항상 false로 불필요 , 전표에 분개가없을경우 분개삭제하는 코드임, 업데이트 부분이기때문에 이걸처리하고싶다면 따른데서 처리되어야됨 (dong)
                 *
                 * if (isChangeAccountCode) {
                 * journalDetailDAO.deleteJournalDetailByJournalNo(journalBean.getJournalNo());
                 * for(JournalDetailBean journalDetailBean: journalBean.getJournalDetailList())
                 * { journalDetailBean.setJournalNo(journalBean.getJournalNo());
                 * journalDetailDAO.insertJournalDetailList(journalDetailBean); }
                 *
                 * }
                 */
            }
        }
    }

    @Override
    public void registerSlip(SlipreqDto slipreqDto, ArrayList<JournalreqDto> journalEntities) {
        System.out.println("AppServiceImpl_addSlip 시작");
        SlipEntity slipEntity = slipReqMapstruct.toEntity(slipreqDto);
        StringBuffer slipNo = new StringBuffer();
        int sum = 0;

        String slipNoDate = slipEntity.getReportingDate().replace("-", ""); // 2021-10-27 -> 20211027
        System.out.println("AppServiceImpl_addSlip 시작");
        //처음에 빈값
        slipNo.append(slipNoDate); //20200118
        slipNo.append("SLIP"); // 20200118SLIP
        String code = "0000" + (slipDAO.selectSlipCount(slipNoDate) + 1) + ""; // 00001 //오늘 작성한 전표의 카운터 +1
        slipNo.append(code.substring(code.length() - 5)); // 00001 10이상 넘어가는숫자들 처리
        System.out.println("slipNo: "+slipNo.toString());
        slipEntity.setSlipNo(slipNo.toString()); //20200118SLIP00001
        slipDAO.insertSlip(slipEntity);
        for (JournalreqDto journalreqDto : journalEntities) {
            JournalEntity journalEntity = journalReqMapstruct.toEntity(journalreqDto);
            String journalNo = journalDAO.selectJournalName(slipEntity.getSlipNo());
            journalEntity.setJournalNo(journalNo);
            journalDAO.insertJournal(journalEntity);

            if(journalEntity.getJournalDetailList()!=null)
                for(JournalDetailEntity journalDetailEntity: journalEntity.getJournalDetailList()) { //분개상세항목들
                    journalDetailEntity.setJournalNo(journalNo); //분개번호
                    journalDAO.insertJournalDetailList(journalDetailEntity);
                }
        }
    }

    @Override
    public void removeSlip(String slipNo) {

        ArrayList<JournalEntity> list = journalDAO.selectJournalList(slipNo);
        for(JournalEntity journal : list) {

            System.out.println("removeSlip@@@@ :" + journal.getJournalNo());}
        slipDAO.deleteSlip(slipNo);
        journalDAO.deleteJournalAll(slipNo);
        for(JournalEntity journal : list) {
            journalDAO.deleteJournalDetail(journal.getJournalNo());
        }

    }




    @Override
    public void approveSlip(ArrayList<SlipreqDto> slipDtos) {
        ArrayList<SlipEntity> slipEntities = (ArrayList<SlipEntity>) slipReqMapstruct.toEntity(slipDtos);

        for (SlipEntity entity : slipEntities) {
            if (entity.getSlipStatus().equals("승인완료")) {
                //메뉴-전표승인 : 승인요청 -> "승인완료"로 update하는 로직
                slipApprovalAndReturnDAO.updateapproveSlip(entity);
            } else {
                //메뉴-일반전표 : 작성중 -> "승인요청"으로 update하는 로직
                slipApprovalAndReturnDAO.updateapproveSlip2(entity);
            }
        }
    }


    @Override
    public ArrayList<SlipEntity> findDisApprovalSlipList() {

        ArrayList<SlipEntity> disApprovalSlipList = null;
        disApprovalSlipList = slipApprovalAndReturnDAO.selectDisApprovalSlipList();

        return disApprovalSlipList;
    }

    @Override
    public ArrayList<SlipEntity> findSlipDataList(String slipDate) {

        ArrayList<SlipEntity> slipList = null;
        slipList = slipDAO.selectSlipDataList(slipDate);

        return slipList;
    }

    @Override
    public HashMap<String, Object> findAccountingSettlementStatus(HashMap<String, Object> params) {
        // TODO Auto-generated method stub

        return slipDAO.selectAccountingSettlementStatus(params);

    }

    @Override
    public ArrayList<SlipEntity> findSlip(String slipNo) {

        ArrayList<SlipEntity> slip = null;
        slip = slipDAO.selectSlip(slipNo);

        return slip;
    }
}