package com.study.modu.web.controller;


import com.study.modu.parent.utils.JsonResult;
import com.study.modu.web.params.qo.KoUserQo;
import com.study.modu.web.persistence.service.IKoUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author wangjunming
 * @since 2020-01-02
 */
@RestController
@RequestMapping("/koUser")
public class KoUserController {

    @Autowired
    private IKoUserService koUserService;

    @ApiOperation("添加用户")
    @PostMapping("/addUser")
    public JsonResult addUser(KoUserQo qo) {
        boolean flag = false;
        qo.setUserName("asdasdsad");
        flag = koUserService.addUser(qo);
      return JsonResult.success(flag);
    }



}

