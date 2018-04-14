package dto;

import java.sql.*;
import java.text.*;

public class BoardDTO {
	private int bId = 0;
	private String bTitle = "";
	private String bContent = "";
	private String bName = "";
	private Timestamp bDate = null;
	private int bHit = 0;

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbDate() {
		String s = new SimpleDateFormat("yyyy/MM/dd").format(bDate);
		return s;
	}

	public String getbDateTime() {
		String s = new SimpleDateFormat("HH:mm:ss").format(bDate);
		return s;
	}
	public Timestamp getTimestamp() {
		return bDate;
	}
	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
}
