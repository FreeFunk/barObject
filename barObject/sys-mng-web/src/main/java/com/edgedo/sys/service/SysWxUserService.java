package com.edgedo.sys.service;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.SysWxUser;
import com.edgedo.sys.mapper.SysWxUserMapper;
import com.edgedo.sys.queryvo.SysWxUserQuery;
import com.edgedo.sys.queryvo.SysWxUserView;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(
   propagation = Propagation.REQUIRED,
   rollbackFor = {Exception.class}
)
public class SysWxUserService {
   @Autowired
   private SysWxUserMapper sysWxUserMapper;

   public List<SysWxUserView> listPage(SysWxUserQuery sysWxUserQuery) {
      List list = this.sysWxUserMapper.listPage(sysWxUserQuery);
      sysWxUserQuery.setList(list);
      return list;
   }

   @Transactional(
      propagation = Propagation.REQUIRED,
      rollbackFor = {Exception.class}
   )
   public String insert(SysWxUser sysWxUser) {
      String id = sysWxUser.getId();
      if (id == null || id.length() == 0) {
         sysWxUser.setId(Guid.guid());
      }

      this.sysWxUserMapper.insert(sysWxUser);
      return "";
   }

   @Transactional(
      propagation = Propagation.REQUIRED,
      rollbackFor = {Exception.class}
   )
   public String update(SysWxUser sysWxUser) {
      this.sysWxUserMapper.updateById(sysWxUser);
      return "";
   }

   @Transactional(
      propagation = Propagation.REQUIRED,
      rollbackFor = {Exception.class}
   )
   public String updateAll(SysWxUser sysWxUser) {
      this.sysWxUserMapper.updateAllColumnById(sysWxUser);
      return "";
   }

   @Transactional(
      propagation = Propagation.REQUIRED,
      rollbackFor = {Exception.class}
   )
   public int delete(String id) {
      return this.sysWxUserMapper.deleteById(id);
   }

   @Transactional(
      propagation = Propagation.REQUIRED,
      rollbackFor = {Exception.class}
   )
   public int deleteByIds(List<String> ids) {
      return this.sysWxUserMapper.deleteBatchIds(ids);
   }

   public SysWxUser loadById(String id) {
      return (SysWxUser)this.sysWxUserMapper.selectById(id);
   }

}
