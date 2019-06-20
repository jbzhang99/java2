package com.rfchina.community.openstore.entity;

import java.util.List;

public class AreaVO {
    private Integer id;

    private String name;

    private Integer parentId;
    
    private List<AreaVO> children;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List<AreaVO> getChildren() {
		return children;
	}

	public void setChildren(List<AreaVO> children) {
		this.children = children;
	}
    
    
  
}