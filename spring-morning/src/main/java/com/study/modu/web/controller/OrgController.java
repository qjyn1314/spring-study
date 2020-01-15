package com.study.modu.web.controller;


import com.study.modu.common.controller.BaseController;
import com.study.modu.parent.utils.JsonResult;
import com.study.modu.web.params.qo.OrgQo;
import com.study.modu.web.persistence.service.IOrgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 组织前端控制器
 * </p>
 *
 * @author wangjunming
 * @since 2020-01-01
 */
@Api(tags = "组织控制器")
@RestController
@RequestMapping("/org")
public class OrgController extends BaseController {
    private static final Logger logger = LogManager.getLogger(OrgController.class);

    @Autowired
    private IOrgService orgService;

    /**
     * 添加组织
     *
     * @return com.study.modu.parent.utils.JsonResult
     * @author wangjunming
     * @since 2020/1/2 13:51
     */
    @ApiOperation("添加组织")
    @PostMapping("/addOrg")
    public JsonResult addOrg(OrgQo qo) {
        qo.setName("顶级组织");
        qo.setParentId(0);
        boolean flag = orgService.addOrg(qo);
        return JsonResult.success(flag);
    }


}

