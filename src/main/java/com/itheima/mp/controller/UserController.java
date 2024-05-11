package com.itheima.mp.controller;

import cn.hutool.core.bean.BeanUtil;
import com.itheima.mp.domain.dto.PageDTO;
import com.itheima.mp.domain.dto.UserFormDTO;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.query.UserQuery;
import com.itheima.mp.domain.vo.UserVO;
import com.itheima.mp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: UserController
 * @Date: 2024/5/10 21:13
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@Api(tags = "用户管理接口")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 新增用户接口
     *
     * @param userDTO
     */
    @ApiOperation("新增用户接口")
    @PostMapping
    public void saveUser(@RequestBody UserFormDTO userDTO) {
        // 1. 把DTO拷贝到PO
        User user = BeanUtil.copyProperties(userDTO, User.class);
        // 2. 新增
        userService.save(user);
    }

    /**
     * 根据id删除用户接口
     *
     * @param id
     */
    @ApiOperation("根据id删除用户接口")
    @DeleteMapping("/{id}")
    public void deleteUserById(@ApiParam("用户id") @PathVariable("id") Long id) {
        userService.removeById(id);
    }

    /**
     * 根据id查询用户接口
     *
     * @param id
     * @return
     */
    @ApiOperation("根据id查询用户接口")
    @GetMapping("/{id}")
    public UserVO queryUserById(@ApiParam("用户id") @PathVariable("id") Long id) {
        return userService.queryUserAndAddressById(id);
    }

    /**
     * 根据id批量查询用户接口
     *
     * @param ids
     * @return
     */
    @ApiOperation("根据id批量查询用户接口")
    @GetMapping
    public List<UserVO> queryUserByIds(@ApiParam("用户id集合") @RequestParam("ids") List<Long> ids) {
        return userService.queryUserAndAddressByIds(ids);
    }

    /**
     * 扣减用户余额接口
     *
     * @param id
     * @param money
     */
    @ApiOperation("扣减用户余额接口")
    @PutMapping("/{id}/deduction/{money}")
    public void deductBalance(@ApiParam("用户id") @PathVariable("id") Long id, @ApiParam("扣减金额") @PathVariable("money") Integer money) {
        userService.deductBalance(id, money);
    }

    /**
     * 根据复杂条件查询用户接口
     * @param query
     * @return
     */
    @ApiOperation("根据复杂条件查询用户接口")
    @GetMapping("/list")
    public List<UserVO> queryUsers(UserQuery query) {
        // 1. 查询用户PO
        List<User> users = userService.queryUsers(query.getName(), query.getStatus(), query.getMinBalance(), query.getMaxBalance());
        // 2. 将PO拷贝到VO
        return BeanUtil.copyToList(users, UserVO.class);
    }

    /**
     * 根据条件分页查询用户接口
     * @param query
     * @return
     */
    @ApiOperation("根据条件分页查询用户接口")
    @GetMapping("/page")
    public PageDTO<UserVO> queryUsersPage(UserQuery query) {
        return userService.queryUsersPage(query);
    }
}
