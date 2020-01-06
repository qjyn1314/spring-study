package com.study.modu.web.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.modu.distributed.model.UserDistributedQo;
import com.study.modu.web.params.qo.KoUserQo;
import com.study.modu.web.persistence.entity.KoUser;
import com.study.modu.web.persistence.mapper.KoUserMapper;
import com.study.modu.web.persistence.service.IKoUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wangjunming
 * @since 2020-01-02
 */
@Service
public class KoUserServiceImpl extends ServiceImpl<KoUserMapper, KoUser> implements IKoUserService {


    @Override
    @Transactional
    public boolean addUser(KoUserQo qo) {
        KoUser user = new KoUser();
        BeanUtils.copyProperties(qo, user);
        return user.insert();
    }

    /**
     * 添加用户信息，为学习分布式事务练习
     *
     * @param userDistributedQo :
     * @return boolean
     * @author wangjunming
     * @since 2020/1/5 15:27
     */
    @Override
    @Transactional
    public boolean initUser(UserDistributedQo userDistributedQo) {
        KoUser user = new KoUser();
//        int i = 10/0;
        BeanUtils.copyProperties(userDistributedQo, user);
        boolean insert = user.insert();
//        int i = 10/0;
        return insert;
    }


}
