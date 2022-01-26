package com.edgedo.bar.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class SeatInfoQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private SeatInfoView queryObj = new SeatInfoView();

	public SeatInfoView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(SeatInfoView queryObj) {
		this.queryObj = queryObj;
	}
}
