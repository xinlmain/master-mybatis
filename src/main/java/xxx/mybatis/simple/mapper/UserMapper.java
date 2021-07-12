package xxx.mybatis.simple.mapper;

import xxx.mybatis.simple.model.SysRole;
import xxx.mybatis.simple.model.SysUser;

import java.util.List;

public interface UserMapper {
    SysUser selectById(Long id);

    List<SysUser> selectAll();

    List<SysRole> selectRolesByUserId(Long userId);

    List<SysUser> selectByUser(SysUser sysUser);

    int insert(SysUser sysUser);

    int updateById(SysUser sysUser);

    int updateByIdSelective(SysUser sysUser);

    int deleteById(Long id);
}
