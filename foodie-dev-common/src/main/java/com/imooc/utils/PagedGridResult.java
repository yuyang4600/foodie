package com.imooc.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 
 * @Title: PagedGridResult.java
 * @Package com.imooc.utils
 * @Description: 用来返回分页Grid的数据格式
 * Copyright: Copyright (c) 2019
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagedGridResult {
	
	private int page;			// 当前页数
	private int total;			// 总页数	
	private long records;		// 总记录数
	private List<?> rows;		// 每行显示的内容

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public long getRecords() {
		return records;
	}
	public void setRecords(long records) {
		this.records = records;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}
