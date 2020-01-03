package com.study.modu.web.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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



}
