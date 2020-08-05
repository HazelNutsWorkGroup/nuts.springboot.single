package org.hazulnut.admin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.hazulnut.admin.entity.UserPO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * user mapper interface.
 *
 * <p>user mapping interface
 *
 * @author <a href="https://blog.csdn.net/yidichaxiang" target="_blank">Sleeber</a>
 * @since 1.3.0
 *
 * <p><b>Note:</b>
 * <p>2020/7/28 16:56: created.<br>
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    List<UserPO> selectAllUser();

    /**
     * 分页查询所有用户
     *
     * @return 用户列表
     */
    IPage<UserPO> selectPageUser(Page<?> page);

//    /**
//     * 根据id查询用户
//     *
//     * @param id 主键id
//     * @return 当前id的用户，不存在则是 {@code null}
//     */
//    UserPO selectUserById(@Param("id") Long id);
//
//    /**
//     * 保存用户
//     *
//     * @param user 用户
//     * @return 成功 - {@code 1} 失败 - {@code 0}
//     */
//    int saveUser(@Param("user") UserPO user);
//
//    /**
//     * 删除用户
//     *
//     * @param id 主键id
//     * @return 成功 - {@code 1} 失败 - {@code 0}
//     */
//    int deleteById(@Param("id") Long id);

}

