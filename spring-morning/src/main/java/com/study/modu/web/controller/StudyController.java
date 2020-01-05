package com.study.modu.web.controller;

import com.study.modu.common.controller.BaseController;
import com.study.modu.distributed.provider.DistributedAfternoonProviderService;
import com.study.modu.parent.utils.DataUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * Explain:学习的控制层，仅个人使用
 * </p >
 *
 * @author wangjunming
 * @since 2019-12-30 11:51
 */
@RestController
@Api(value = "学习的控制层，仅个人使用")
public class StudyController extends BaseController {

    @Autowired
    private DistributedAfternoonProviderService afternoonProviderService;


    /**
     * 获取当前时间字符串
     *
     * @return java.lang.String
     * @author wangjunming
     * @since 2019/12/30 12:53
     */
    @ApiOperation("获取当前时间字符串")
    @GetMapping("/curentDate")
    public String getNewDate() {
        logger.info("进入控制层{}", hashCode());
        String contextPath = "";//request.getServletPath();
        logger.info("开始获取路径......{}", contextPath);

        try {
            String str = afternoonProviderService.getUser();
            logger.info("通过dubbo+zookeeper获取affternoon服务的用户信息：{}",str);
        } catch (Exception e) {
            System.out.println(e);
        }
        if (contextPath != null) {
            logger.info("进入判断......start");
//            MoDuException.build("数据为空!");
            logger.info("进入判断......end");
        }
        String dateTimes = DataUtils.getDateTimes();
        logger.debug("开始获取路径");
        logger.info("开始获取路径.....结束." + dateTimes);
        return dateTimes;
    }


}
