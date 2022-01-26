package com.edgedo.sys.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class SysMeunUserQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private SysMeunUserView queryObj = new SysMeunUserView();

	public SysMeunUserView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(SysMeunUserView queryObj) {
		this.queryObj = queryObj;
	}
}
