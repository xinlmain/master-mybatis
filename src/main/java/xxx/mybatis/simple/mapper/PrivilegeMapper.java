package xxx.mybatis.simple.mapper;

import org.apache.ibatis.annotations.SelectProvider;
import xxx.mybatis.simple.model.SysPrivilege;
import xxx.mybatis.simple.provider.PrivilegeProvider;

public interface PrivilegeMapper {
    @SelectProvider(type = PrivilegeProvider.class, method = "selectById")
    SysPrivilege selectById(final Long id);
}
