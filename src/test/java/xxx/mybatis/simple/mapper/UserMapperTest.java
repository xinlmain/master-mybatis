package xxx.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import xxx.mybatis.simple.model.SysUser;

import java.util.List;

public class UserMapperTest extends BaseMapperTest{

    @Test
    public void testSelectById() {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            SysUser sysUser = mapper.selectById(1L);

            Assert.assertNotNull(sysUser);
            Assert.assertEquals("admin", sysUser.getUserName());

            System.out.println(sysUser);
        }
    }

    @Test
    public void testSelectAll() {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            List<SysUser> sysUser = mapper.selectAll();

            Assert.assertNotNull(sysUser);
            Assert.assertTrue(sysUser.size() > 1);

            System.out.println(sysUser);
        }
    }
}
