package com.edgedo.common.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

@ApiModel(
   value = "分页查询条件",
   description = "分页查询条件"
)
public class QueryObj implements Serializable {
   @ApiModelProperty(
      value = "第几页",
      example = "1,2,3,4,5"
   )
   private Integer page;
   @ApiModelProperty(
      value = "每页条数",
      example = "1,2,3,4,5"
   )
   private Integer limit;
   @ApiModelProperty(
      value = "分页从第几条开始取",
      example = "0,10,20,30,40,50"
   )
   private Integer start;
   @ApiModelProperty(
      hidden = true
   )
   private Integer end;
   @ApiModelProperty(
      hidden = true
   )
   private Integer totalCount;
   @ApiModelProperty(
      hidden = true
   )
   private Integer totalPage;
   private String orderBy;
   @ApiModelProperty(
      hidden = true
   )
   private List list;
   @ApiModelProperty(
      hidden = true
   )
   private Boolean success = true;

   public Integer getPage() {
      return this.page;
   }

   public void setPage(Integer page) {
      this.page = page;
      this.start = (page - 1) * this.limit;
   }

   public Integer getLimit() {
      return this.limit;
   }

   public void setLimit(Integer limit) {
      if (limit != null && limit > 100) {
         this.limit = 100;
      } else {
         this.limit = limit;
      }

   }

   public Integer getStart() {
      return this.start;
   }

   public void setStart(Integer start) {
      this.start = start;
   }

   public Integer getEnd() {
      return this.limit != null && this.start != null ? this.limit : null;
   }

   public void setEnd(Integer end) {
      this.end = end;
   }

   public Integer getTotalCount() {
      return this.totalCount;
   }

   public void setTotalCount(Integer totalCount) {
      if (totalCount != null && this.limit != null) {
         this.totalPage = totalCount / this.limit + (totalCount % this.limit > 0 ? 1 : 0);
      }

      this.totalCount = totalCount;
   }

   public List getList() {
      return this.list;
   }

   public void setList(List list) {
      this.list = list;
   }

   public Boolean getSuccess() {
      return this.success;
   }

   public void setSuccess(Boolean success) {
      this.success = success;
   }

   public String getOrderBy() {
      return this.orderBy;
   }

   public void setOrderBy(String orderBy) {
      this.orderBy = orderBy;
   }

   public String cacheKey() {
      String key = "start:" + this.start + "limit:" + this.limit;
      return key;
   }

   public Integer getTotalPage() {
      return this.totalPage;
   }

   public void setTotalPage(Integer totalPage) {
      this.totalPage = totalPage;
   }
}
