package com.edgedo.bar.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class ConsInfoQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private ConsInfoView queryObj = new ConsInfoView();

	public ConsInfoView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(ConsInfoView queryObj) {
		this.queryObj = queryObj;
	}
}
