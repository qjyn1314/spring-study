package com.study.modu.distributed.provider;

import com.study.modu.distributed.model.UserDistributedQo;

/**
 * <p>
 * Explain:afternoon服务对外暴露rpc接口
 * </p >
 *
 * @author wangjunming
 * @since 2020-01-04 21:12
 */
public interface DistributedAfternoonProviderService {


    String getUser();


    /**
     * 添加用户信息，为学习分布式事务练习
     *
     * @author wangjunming
     * @since 2020/1/5 15:25
     * @param userDistributedQo:
     * @return boolean
     */
    boolean initUser(UserDistributedQo userDistributedQo);


}
