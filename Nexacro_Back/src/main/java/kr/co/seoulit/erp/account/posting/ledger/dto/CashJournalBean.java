package kr.co.seoulit.erp.account.posting.ledger.dto;

import kr.co.seoulit.erp.account.sys.common.annotation.Dataset;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

@Dataset(name="ds_cashJournal")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Schema(description = "현금출납장 Dto")
public class CashJournalBean {
	private String monthReportingDate;
	private String reportingDate;
	private String expenseReport;

	@Schema(description = "거래처코드" )
	private String customerCode;

	@Schema(description = "거래처명" )
	private String customerName;
	private int deposit;
	private int withdrawal;
	private int balance;
	
	
	
}