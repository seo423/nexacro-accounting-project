package kr.co.seoulit.erp.account.operate.system.entity;

import kr.co.seoulit.erp.account.sys.base.to.BaseBean;
import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name="BOARD")
@Dataset(name="ds_board")
@Data
@ToString
public class BoardEntity extends BaseBean {

	@Id
	//DB의 테이블에서 필요한 정보만 추출해온다.
	private String id;
	private String title;
	private String contents;
	private String writtenBy;
	private Date writeDate;
	private Date updateDateTime;

	//아래의 코드는 과제를 위한 생성자 DB에서 데이터를 생성자로 가져오기 위함입니다.
	public BoardEntity(String id,
					   String title,
					   String contents,
					   String writtenBy,
					   Date writeDate,
					   Date updateDateTime) {
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.writtenBy = writtenBy;
		this.writeDate = writeDate;
		this.updateDateTime = updateDateTime;
	}
}
