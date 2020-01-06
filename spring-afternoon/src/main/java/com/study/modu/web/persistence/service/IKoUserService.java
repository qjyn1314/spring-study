package com.study.modu.web.persistence.service;

import com.study.modu.distributed.model.UserDistributedQo;
import com.study.modu.web.params.qo.KoUserQo;
import com.study.modu.web.persistence.entity.KoUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author wangjunming
 * @since 2020-01-02
 */
public interface IKoUserService extends IService<KoUser> {

    boolean addUser(KoUserQo qo);

    /**
     * 添加用户信息，为学习分布式事务练习
     *
     * @author wangjunming
     * @since 2020/1/5 15:27
     * @param userDistributedQo:
     * @return boolean
     */
    boolean initUser(UserDistributedQo userDistributedQo);


}
