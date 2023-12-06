package todo.p20231206pro;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;
@Data
public class InOut {
	// 필드
	private String inOutCode;
	private Date processDate; // 처리날짜
	private int count; // 수량
	private String trading; // 판매 or 구매
	
	// 생성자
	InOut(int count, String trading){
		this.processDate = new Date();
		this.count = count;
		this.trading = trading;
	}
	
	InOut(String inOutCode, Date processDate, int count, String trading){
		this.inOutCode = inOutCode;
		this.processDate = new Date();
		this.count = count;
		this.trading = trading;
	}
	
	public void showInOut() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(inOutCode + "  " + sdf.format(processDate)+ "  " + count + "  " + trading);
	}
	
	// toString 재정의
		@Override
		public String toString() {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return inOutCode + "  " + sdf.format(processDate) + "  " + count + "  " + trading;
		}
}
