package com.study.modu.web.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.modu.distributed.model.UserDistributedQo;
import com.study.modu.distributed.provider.DistributedAfternoonProviderService;
import com.study.modu.web.params.qo.OrgQo;
import com.study.modu.web.persistence.entity.Org;
import com.study.modu.web.persistence.mapper.OrgMapper;
import com.study.modu.web.persistence.service.IOrgService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangjunming
 * @since 2020-01-01
 */
@Service
public class OrgServiceImpl extends ServiceImpl<OrgMapper, Org> implements IOrgService {

    @Autowired
    private DistributedAfternoonProviderService afternoonProviderService;


    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public boolean addOrg(OrgQo qo) {
        Org org = new Org();
        BeanUtils.copyProperties(qo,org);
        UserDistributedQo userDistributedQo = new UserDistributedQo();
        Random random = new Random();
        userDistributedQo.setUserName("学习分布式事务"+random.nextInt());
        userDistributedQo.setAge(random.nextInt());
        userDistributedQo.setCreaterTime(LocalDateTime.now());
//        int i = 10/0;
        boolean insert = org.insert();
        //在rpc方法内若是抛出异常则组织信息会添加成功，用户信息会添加不成功，当前事务没有保证原子性，
        //解决方案：
//
        insert = afternoonProviderService.initUser(userDistributedQo);
        //在rpc方法之后若是抛出异常则组织信息会添加成功，用户信息会添加不成功，当前事务没有保证原子性，
//        int i = 10/0;
        return insert;
    }
}
