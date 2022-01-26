package com.edgedo.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.SysWxUser;
import com.edgedo.sys.queryvo.SysWxUserQuery;
import com.edgedo.sys.queryvo.SysWxUserView;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysWxUserMapper extends BaseMapper<SysWxUser> {
   List<SysWxUserView> listPage(SysWxUserQuery query);

   List<SysWxUserView> listByObj(SysWxUserQuery query);
}
