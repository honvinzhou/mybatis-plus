package com.itheima.mp.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName: IAddressServiceTest
 * @Date: 2024/5/11 17:33
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@SpringBootTest
class IAddressServiceTest {

    @Resource
    private IAddressService addressService;

    @Test
    void testLogicDelete() {
        addressService.removeById(59L);
    }
}