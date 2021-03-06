package com.edgedo.bar.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class OrderDetailsInfoQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private OrderDetailsInfoView queryObj = new OrderDetailsInfoView();

	public OrderDetailsInfoView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(OrderDetailsInfoView queryObj) {
		this.queryObj = queryObj;
	}
}
