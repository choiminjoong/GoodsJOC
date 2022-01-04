package k5.goodsjoc.dto;

public class Level {
	
	private String levelNum;
	private String levelName;
	private String note;

	@Override
	public String toString() {
		return "SystemLevel [levelNum=" + levelNum + ", levelName=" + levelName + ", note=" + note + "]";
	}
	public String getLevelNum() {
		return levelNum;
	}
	public void setLevelNum(String levelNum) {
		this.levelNum = levelNum;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
