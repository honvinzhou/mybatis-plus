package com.itheima.mp.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * @ClassName: UserStatus
 * @Date: 2024/5/11 17:42
 * @Author: Honvin
 * @Software: IntelliJ IDEA
 * @Description:
 **/
@Getter
public enum UserStatus {
    NORMAL(1, "正常"),
    FROZEN(2, "冻结"),
    ;

    @EnumValue  // 给枚举中的与数据库对应的value值添加@EnumValue注解
    @JsonValue  // 加在哪个字段上给前端返回哪个
    private final int value;
    private final String desc;

    UserStatus(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
