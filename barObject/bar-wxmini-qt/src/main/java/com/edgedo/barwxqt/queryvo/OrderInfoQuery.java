package com.edgedo.barwxqt.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class OrderInfoQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private OrderInfoView queryObj = new OrderInfoView();

	public OrderInfoView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(OrderInfoView queryObj) {
		this.queryObj = queryObj;
	}
}
