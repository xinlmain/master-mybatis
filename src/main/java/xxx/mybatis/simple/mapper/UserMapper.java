package xxx.mybatis.simple.mapper;

import xxx.mybatis.simple.model.SysRole;
import xxx.mybatis.simple.model.SysUser;

import java.util.List;

public interface UserMapper {
    SysUser selectById(Long id);

    List<SysUser> selectAll();

    List<SysRole> selectRolesByUserId(Long userId);

    int insert(SysUser sysUser);
}
