package com.edgedo.common.shiro;

public interface IUserTokenSign {
   String sign(String userInfo);

   User getTokenUser(String token);
}
