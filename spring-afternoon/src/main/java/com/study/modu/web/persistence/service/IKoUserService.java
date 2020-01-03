package com.study.modu.web.persistence.service;

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

}
