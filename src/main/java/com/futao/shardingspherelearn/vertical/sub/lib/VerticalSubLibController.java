package com.futao.shardingspherelearn.vertical.sub.lib;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.futao.shardingspherelearn.entity.OrderEntity;
import com.futao.shardingspherelearn.entity.OrderMapper;
import com.futao.shardingspherelearn.entity.UserEntity;
import com.futao.shardingspherelearn.entity.UserMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 垂直分库
 *
 * @author futao
 * @since 2022/11/18
 */
@Slf4j
@RestController
@RequestMapping("/vertical-sub-lib")
public class VerticalSubLibController {
    @Resource
    private UserMapper userMapper;

    @Resource
    private OrderMapper orderMapper;

    @PostMapping
    public Map<String, List<?>> saveAndList(@RequestBody Combine combine) {
        userMapper.insert(combine.user);
        orderMapper.insert(combine.order);

        Map<String, List<?>> resultMap = new HashMap<>();
        resultMap.put("user", userMapper.selectList(Wrappers.lambdaQuery()));
        resultMap.put("order", orderMapper.selectList(Wrappers.lambdaQuery()));
        return resultMap;
    }


    @Getter
    @Setter
    public static class Combine {
        private UserEntity user;
        private OrderEntity order;
    }
}
