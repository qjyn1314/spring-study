package com.study.modu.web.persistence.service;

import com.study.modu.web.params.qo.OrgQo;
import com.study.modu.web.persistence.entity.Org;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangjunming
 * @since 2020-01-01
 */
public interface IOrgService extends IService<Org> {

    boolean addOrg(OrgQo qo);

}
