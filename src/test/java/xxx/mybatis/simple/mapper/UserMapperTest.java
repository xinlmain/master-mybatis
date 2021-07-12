package xxx.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import xxx.mybatis.simple.model.SysRole;
import xxx.mybatis.simple.model.SysUser;

import java.util.Date;
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

    @Test
    public void testSelectRolesByUserId() {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            List<SysRole> sysRoles = mapper.selectRolesByUserId(1L);

            Assert.assertNotNull(sysRoles);
            Assert.assertTrue(sysRoles.size() > 1);

            System.out.println(sysRoles);
        }
    }

    @Test
    public void testInsert() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("jadjf@jfid.com");
            user.setUserInfo("gfrwer nnnn");
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());

            int result = mapper.insert(user);

            Assert.assertEquals(1, result);
            Assert.assertNull(user.getId());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateById() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            SysUser user = mapper.selectById(1L);

            Assert.assertEquals("admin", user.getUserName());

            user.setUserName("test1");
            user.setUserEmail("jadjf@jfid.com");

            int result = mapper.updateById(user);

            Assert.assertEquals(1, result);

            user = mapper.selectById(1L);
            Assert.assertEquals("test1", user.getUserName());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}
