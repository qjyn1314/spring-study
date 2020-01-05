package com.study.modu.web.provider;

import com.study.modu.distributed.provider.DistributedMorningProviderService;
import com.study.modu.web.persistence.entity.Org;
import com.study.modu.web.persistence.service.IOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Explain:morning服务对外暴露rpc接口的具体实现
 * </p >
 *
 * @author wangjunming
 * @since 2020-01-04 21:12
 */
@Service
public class DistributedMorningProviderServiceImpl implements DistributedMorningProviderService {

    @Autowired
    private IOrgService orgService;

    @Override
    public String getStr() {
        System.out.println("获取字符串!!!");
        Org byId = orgService.getById(2);
        return byId.toString();
    }

}
