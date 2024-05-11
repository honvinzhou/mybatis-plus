package com.itheima.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.mp.domain.dto.PageDTO;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.query.UserQuery;
import com.itheima.mp.domain.vo.UserVO;

import java.util.List;

/**
 * @ClassName: UserService
 * @Date: 2024/5/10 20:52
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
public interface UserService extends IService<User> {

    /**
     * 扣减用户余额接口
     * @param id
     * @param money
     */
    void deductBalance(Long id, Integer money);

    /**
     * 根据复杂条件查询用户接口
     * @param name
     * @param status
     * @param minBalance
     * @param maxBalance
     * @return
     */
    List<User> queryUsers(String name, Integer status, Integer minBalance, Integer maxBalance);

    UserVO queryUserAndAddressById(Long id);

    List<UserVO> queryUserAndAddressByIds(List<Long> ids);

    PageDTO<UserVO> queryUsersPage(UserQuery query);
}
