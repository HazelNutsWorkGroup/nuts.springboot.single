package org.hazulnut.admin.service;

import org.hazulnut.admin.entity.UserPO;

import java.util.List;

/**
 * User Service interface.
 *
 * <p>User Service interface
 *
 * @author <a href="https://blog.csdn.net/yidichaxiang" target="_blank">Sleeber</a>
 * @since 1.3.0
 *
 * <p><b>Note:</b>
 * <p>2020/11/16 16:55: created.<br>
 */
public interface UserService {

    List<UserPO> getList();
}
