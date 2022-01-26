package com.edgedo.sys.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class SysMeunQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private SysMeunView queryObj = new SysMeunView();

	public SysMeunView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(SysMeunView queryObj) {
		this.queryObj = queryObj;
	}
}
