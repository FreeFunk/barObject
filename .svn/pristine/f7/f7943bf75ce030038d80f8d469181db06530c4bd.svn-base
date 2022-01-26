package com.edgedo.common.base;

public class BusinessException extends RuntimeException {
   String errCode = null;

   public String getErrCode() {
      return this.errCode;
   }

   public void setErrCode(String errCode) {
      this.errCode = errCode;
   }

   public BusinessException(String errmsg, String errCode) {
      super(errmsg);
      this.errCode = errCode;
   }

   public BusinessException() {
   }

   public BusinessException(String errmsg) {
      super(errmsg);
   }

   public BusinessException(String message, Throwable cause) {
      super(message, cause);
   }

   public BusinessException(Throwable cause) {
      super(cause);
   }
}
