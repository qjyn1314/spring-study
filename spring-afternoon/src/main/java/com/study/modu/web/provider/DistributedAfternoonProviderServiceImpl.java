package com.study.modu.web.provider;

import com.study.modu.distributed.provider.DistributedAfternoonProviderService;
import com.study.modu.web.persistence.entity.KoUser;
import com.study.modu.web.persistence.service.IKoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Explain:afternoon服务对外暴露rpc接口的具体实现
 * </p >
 *
 * @author wangjunming
 * @since 2020-01-05 14:16
 */
@Service
public class DistributedAfternoonProviderServiceImpl implements DistributedAfternoonProviderService {

    @Autowired
    private IKoUserService userService;

    @Override
    public String getUser() {
        KoUser byId = userService.getById(9);
        System.out.println("开始获取用户信息!!!");
        return byId.toString();
    }
}
