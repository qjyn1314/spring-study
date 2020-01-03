package com.study.modu.web.persistence.service.impl;

import com.study.modu.web.params.qo.OrgQo;
import com.study.modu.web.persistence.entity.Org;
import com.study.modu.web.persistence.mapper.OrgMapper;
import com.study.modu.web.persistence.service.IOrgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public boolean addOrg(OrgQo qo) {
        Org org = new Org();
        BeanUtils.copyProperties(qo,org);

//        int i = 10/0;

        return org.insert();
    }
}
