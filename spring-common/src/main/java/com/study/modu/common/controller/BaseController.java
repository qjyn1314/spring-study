package com.study.modu.common.controller;

import com.study.modu.common.base.BaseObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * Explain:控制层抽象类
 * </p >
 *
 * @author wangjunming
 * @since 2019-12-30 15:16
 */
public abstract class BaseController extends BaseObject {

    @Autowired
    public HttpServletRequest request;


}
