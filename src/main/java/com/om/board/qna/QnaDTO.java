package com.om.board.qna;

import java.sql.Date;

import com.om.board.BoardDTO;


public class QnaDTO extends BoardDTO {
	
	private int ref;
	private int step;
	private int depth;
	
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	@Override
	public int getNum() {
		// TODO Auto-generated method stub
		return super.getNum();
	}
	@Override
	public void setNum(int num) {
		// TODO Auto-generated method stub
		super.setNum(num);
	}
	@Override
	public String getWriter() {
		// TODO Auto-generated method stub
		return super.getWriter();
	}
	@Override
	public void setWriter(String writer) {
		// TODO Auto-generated method stub
		super.setWriter(writer);
	}
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return super.getTitle();
	}
	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		super.setTitle(title);
	}
	@Override
	public String getContents() {
		// TODO Auto-generated method stub
		return super.getContents();
	}
	@Override
	public void setContents(String contents) {
		// TODO Auto-generated method stub
		super.setContents(contents);
	}
	@Override
	public Date getReg_date() {
		// TODO Auto-generated method stub
		return super.getReg_date();
	}
	@Override
	public void setReg_date(Date reg_date) {
		// TODO Auto-generated method stub
		super.setReg_date(reg_date);
	}
	@Override
	public int getHit() {
		// TODO Auto-generated method stub
		return super.getHit();
	}
	@Override
	public void setHit(int hit) {
		// TODO Auto-generated method stub
		super.setHit(hit);
	}
	
	
	

}
