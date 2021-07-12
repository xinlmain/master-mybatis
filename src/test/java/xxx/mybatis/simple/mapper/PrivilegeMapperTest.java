package xxx.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import xxx.mybatis.simple.model.SysPrivilege;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PrivilegeMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById() {
        try (SqlSession sqlSession = getSqlSession()) {
            PrivilegeMapper mapper = sqlSession.getMapper(PrivilegeMapper.class);
            SysPrivilege privilege = mapper.selectById(1L);

            assertNotNull(privilege);
            assertEquals("用户管理", privilege.getPrivilegeName());
        }
    }
}