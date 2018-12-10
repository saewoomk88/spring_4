package com.om.util;

public class Pager {
	
	//page number
	private int curPage;
	
	//perPage
	private int perPage;
	//perBlock
	private int perBlock;
	
	//DAO rownum 으로 사용하기 위함
	private int startRow;
	private int lastRow;
	
	//search하기 위함
	private String kind;
	private String search;
	
	//pageing 
	private int startNum;
	private int lastNum;
	private int curBlock;
	private int totalBlock;
	
	public Pager() {
		this.perPage=10;
		this.perBlock=5;
	}
	
	public int getCurPage() {
		if(curPage==0) {
			curPage=1;
		}
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPerPage() {
		if(perPage==0) {
			perPage=10;
		}
		return perPage;
	}

	public void setPerPage(int perPage) {
		if(perPage==0) {
			this.perPage=10;
		}else {
			this.perPage = perPage;
		}
	}

	public int getPerBlock() {
		if(perBlock==0) {
			perBlock=5;
		}
		return perBlock;
	}

	public void setPerBlock(int perBlock) {
		this.perBlock = perBlock;
		if(this.perBlock==0) {
			this.perBlock=5;
		}
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getLastRow() {
		return lastRow;
	}

	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}

	public String getKind() {
		if(this.kind==null || this.kind.equals("")) {
			kind="title";
		}
		return kind;
	}

	public void setKind(String kind) {
		if(this.kind==null || this.kind.equals("")) {
			this.kind = "title";
		}
	}

	public String getSearch() {
		if(search==null) {
			search="";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
		if(this.search==null) {
			this.search="";
		}
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getLastNum() {
		return lastNum;
	}

	public void setLastNum(int lastNum) {
		this.lastNum = lastNum;
	}

	public int getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}

	public int getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}

	//스타트로우와 라스트로우를 계산하기위한 메서드(게시판에 목록이 몇개가 보여줄건지)
	public void makeRow() {
		this.startRow = (getCurPage()-1)*getPerPage()+1;
		this.lastRow = getCurPage()*getPerPage();
	}
	
	//
	public void makePage(int totalCount) {
		//1.totalPage(전체 페이지의 쪽수)
		int totalPage = totalCount/perPage;
		if(totalCount%perPage !=0) {
			totalPage++;
		}
		//2.totalBlock(페이지가 5개씩이면 그 블럭의 전체 수)
		this.totalBlock = totalPage/perBlock;
		if(totalPage%perBlock !=0) {
			totalBlock++;
		}
		//3. curPage로 curBlock 를 찾기
		this.curBlock=curPage/perBlock;
		if(curPage%perBlock !=0) {
			curBlock++;
		}
		//4. curBlock으로 스타트넘, 라스트넘 찾기
		this.startNum=(curBlock-1)*perBlock+1;
		this.lastNum=curBlock*perBlock;
		//5.curBlock 마지막 block 일때
		if(curBlock== totalBlock) {
			this.lastNum=totalPage;
		}
	}

}
