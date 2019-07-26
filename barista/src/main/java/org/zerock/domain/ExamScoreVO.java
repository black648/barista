package org.zerock.domain;

public class ExamScoreVO {
	private String exam_sn;
	private String apc_sn;
	private int section1;
	private int section2;
	private int section3;
	private int section4;
	private int section5;
	private int total;
	private double score;
	private String fail_yn;
	private String pass_yn;
	private String calculation_de;
	public String getExam_sn() {
		return exam_sn;
	}
	public void setExam_sn(String exam_sn) {
		this.exam_sn = exam_sn;
	}
	public String getApc_sn() {
		return apc_sn;
	}
	public void setApc_sn(String apc_sn) {
		this.apc_sn = apc_sn;
	}
	public int getSection1() {
		return section1;
	}
	public void setSection1(int section1) {
		this.section1 = section1;
	}
	public int getSection2() {
		return section2;
	}
	public void setSection2(int section2) {
		this.section2 = section2;
	}
	public int getSection3() {
		return section3;
	}
	public void setSection3(int section3) {
		this.section3 = section3;
	}
	public int getSection4() {
		return section4;
	}
	public void setSection4(int section4) {
		this.section4 = section4;
	}
	public int getSection5() {
		return section5;
	}
	public void setSection5(int section5) {
		this.section5 = section5;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getFail_yn() {
		return fail_yn;
	}
	public void setFail_yn(String fail_yn) {
		this.fail_yn = fail_yn;
	}
	public String getPass_yn() {
		return pass_yn;
	}
	public void setPass_yn(String pass_yn) {
		this.pass_yn = pass_yn;
	}
	public String getCalculation_de() {
		return calculation_de;
	}
	public void setCalculation_de(String calculation_de) {
		this.calculation_de = calculation_de;
	}
	
	
	
}
