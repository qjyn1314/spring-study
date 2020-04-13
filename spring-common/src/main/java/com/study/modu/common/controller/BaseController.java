package com.study.modu.common.controller;

import com.study.modu.common.base.BaseObject;
import com.study.modu.parent.utils.DataUtils;
import com.study.modu.parent.utils.JsonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * Explain:控制层抽象类
 * </p >
 *
 * @author wangjunming
 * @since 2019-12-30 15:16
 */
@Controller
public abstract class BaseController extends BaseObject {

    @Autowired(required = false)
    public HttpServletRequest request;

    @ApiOperation("跳转index页面")
    @GetMapping("/")
    public String index(ModelAndView view) {
        view.addObject("nowDate", DataUtils.getDateTimes());
        return "index";
    }

}
