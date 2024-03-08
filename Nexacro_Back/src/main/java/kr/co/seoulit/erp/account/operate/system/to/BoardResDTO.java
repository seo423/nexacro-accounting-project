package kr.co.seoulit.erp.account.operate.system.to;


import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@Dataset(name="ds_board")
@NoArgsConstructor
@AllArgsConstructor

//toString은 테스트를 클래스에서 갑을 받기 위해서 입니다.
@ToString
public class BoardResDTO {


    //DB의 테이블에서 필요한 정보만 추출해온다.
    private String id;
    private String title;
    private String contents;
    private String writtenBy;
    private Date writeDate;
    private Date updateDateTime;


}
