package com.futao.shardingspherelearn.read.write.splitting;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.futao.shardingspherelearn.entity.UserEntity;
import com.futao.shardingspherelearn.entity.UserMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author futao
 * @since 2022/11/18
 */
@RestController
@RequestMapping("/read-write-splitting")
public class ReadWriteSplittingController {

    @Resource
    private UserMapper userMapper;

    @PostMapping
    public boolean save(@RequestBody UserEntity userEntity) {
        return userMapper.insert(userEntity) > 0;
    }


    @PostMapping("/transaction")
    @Transactional(rollbackFor = Exception.class)
    public List<UserEntity> transaction(@RequestBody UserEntity userEntity) {
        userMapper.insert(userEntity);
        return userMapper.selectList(Wrappers.lambdaQuery());
    }

    @GetMapping("/list")
    public List<UserEntity> list() {
        return userMapper.selectList(Wrappers.lambdaQuery());
    }
}
