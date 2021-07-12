package xxx.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import xxx.mybatis.simple.model.SysRole;

import java.util.List;

import static org.junit.Assert.*;

public class RoleMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById() {
        try (SqlSession sqlSession = getSqlSession()) {
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            SysRole role = mapper.selectById(1L);

            assertNotNull(role);
            assertEquals("管理员", role.getRoleName());

            role = mapper.selectById2(1L);
            assertNotNull(role);
            assertEquals("管理员", role.getRoleName());

            List<SysRole> sysRoles = mapper.selectAll();
            assertTrue(sysRoles.size() > 0);
        }
    }
}