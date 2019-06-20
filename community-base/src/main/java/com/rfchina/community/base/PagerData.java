package com.rfchina.community.base;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class PagerData<T> {
	long total;

	public PagerData(long total) {
		super();
		this.total = total;
	}

	int page = 1;
	int limit = 20;

	int totalPage;

	List<T> data;
	Object extData;

	public Object getExtData() {
		return extData;
	}

	public void setExtData(Object extData) {
		this.extData = extData;
	}

	public int getTotalPage() {
		return (int) (total / limit) + (total % limit == 0 ? 0 : 1);
	}

	public PagerData(int page, int limit) {
		super();
		this.page = page;
		this.limit = limit;
	}

	public PagerData(long total, int page, int limit) {
		super();
		this.page = page;
		this.limit = limit;
		this.total = total;

	}

	public RowBounds createRowBounds() {
		return new RowBounds(getOffset(), limit);
	}

	public PagerData() {
		super();

	}

	public int getOffset() {
		return (page - 1) * limit;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;

	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public boolean isFirstPage() {
		return page == 1;
	}

	public boolean isLastPage() {
		return page >= getTotalPage();
	}

}
