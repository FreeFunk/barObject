package com.edgedo.barwxqt.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class UserMoneyQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private UserMoneyView queryObj = new UserMoneyView();

	public UserMoneyView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(UserMoneyView queryObj) {
		this.queryObj = queryObj;
	}
}
