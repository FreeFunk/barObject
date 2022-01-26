package com.edgedo.common.base;

public class TreeObj {
   private String text;
   private String id;
   private boolean leaf;
   private String isLeaf;
   private String parentId;
   private String iconCls;

   public TreeObj() {
   }

   public TreeObj(String text, String id, boolean leaf) {
      this.text = text;
      this.id = id;
      this.leaf = leaf;
   }

   public String getIsLeaf() {
      return this.isLeaf;
   }

   public void setIsLeaf(String isLeaf) {
      this.isLeaf = isLeaf;
   }

   public String getText() {
      return this.text;
   }

   public void setText(String text) {
      this.text = text;
   }

   public String getId() {
      return this.id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public boolean isLeaf() {
      return this.isLeaf != null && this.isLeaf.equals("1");
   }

   public void setLeaf(boolean leaf) {
      this.leaf = leaf;
   }

   public String getParentId() {
      return this.parentId;
   }

   public void setParentId(String parentId) {
      this.parentId = parentId;
   }

   public String getIconCls() {
      if (this.iconCls != null && this.iconCls.length() != 0) {
         return this.iconCls;
      } else {
         return this.isLeaf() ? "x-fa fa-sitemap" : "x-fa fa-leaf";
      }
   }

   public void setIconCls(String iconCls) {
      this.iconCls = iconCls;
   }
}
