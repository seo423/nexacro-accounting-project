package kr.co.seoulit.erp.account.posting.ledger.dto;

import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@Dataset(name = "ds_department")
@AllArgsConstructor
@NoArgsConstructor
//@RedisHash("deptlist")
public class DeptResDto implements Serializable {

	@Id
	private String deptName;

	private String deptCode;


}
