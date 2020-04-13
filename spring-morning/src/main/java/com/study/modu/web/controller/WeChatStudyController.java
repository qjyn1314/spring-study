package com.study.modu.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.study.modu.common.controller.BaseController;
import com.study.modu.parent.utils.JsonResult;
import com.study.modu.web.utils.WeChatStudyUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.WxMpMassOpenIdsMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;
import me.chanjar.weixin.mp.bean.result.WxMpMassSendResult;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Explain:
 * </p >
 *
 * @author wangjunming
 * @since 2020-01-13 16:13
 */
@Api(tags = "微信公众号开发")
@RestController
@RequestMapping("/wechat/study/")
public class WeChatStudyController extends BaseController {
    private static final Logger logger = LogManager.getLogger(WeChatStudyController.class);

    private static final String token = "20200114_king";

    private static final WxMpService wxService = new WxMpServiceImpl();

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 验证成为微信开发者
     *
     * @param request:
     * @param response:
     * @return void
     * @author wangjunming
     * @since 2020/1/13 16:19
     */
    @ApiOperation("验证成为微信开发者")
    @GetMapping("weChatValidateForDate")
    public void weChatValidate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String signature = request.getParameter("signature");
        logger.info("signature-->{}", signature);
        String timestamp = request.getParameter("timestamp");
        logger.info("timestamp-->{}", timestamp);
        String nonce = request.getParameter("nonce");
        logger.info("nonce-->{}", nonce);
        String echostr = request.getParameter("echostr");
        logger.info("echostr-->{}", echostr);
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        WxMpDefaultConfigImpl config = new WxMpDefaultConfigImpl();
        // 设置微信公众号的token
        config.setToken(token);
        logger.info("token-->{}", token);
        wxService.setWxMpConfigStorage(config);
        boolean checkSignatureFlag = wxService.checkSignature(timestamp, nonce, signature);
        logger.info("是否成功：{}", checkSignatureFlag);
        if (!checkSignatureFlag) {
            // 消息签名不正确，说明不是公众平台发过来的消息
            response.getWriter().print("非法请求");
        }
        if (StringUtils.isNotBlank(echostr)) {
            // 说明是一个仅仅用来验证的请求，回显echostr
            response.getWriter().print(echostr);
        }
    }

    /**
     * 用户与服务之前进行数据交互
     *
     * @param request:
     * @param response:
     * @return void
     * @author wangjunming
     * @since 2020/1/13 17:01
     */
    @ApiOperation("用户与服务之前进行数据交互")
    @PostMapping("weChatValidateForDate")
    public void dataTransfer(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String encryptType = StringUtils.isBlank(request.getParameter("encrypt_type")) ? "raw" : request.getParameter("encrypt_type");
        if ("raw".equals(encryptType)) {
            // 明文传输的消息
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(request.getInputStream());
            logger.info("获取到关注公众号的信息是：{}", JSON.toJSONString(inMessage, SerializerFeature.WriteDateUseDateFormat));
            //为公众号的原始ID
            String fromUser = inMessage.getToUser();
            //--TODO--需要将公众号的原始ID，以及关注公众号用户的openID进行存到数据库
            //--TODO--需要将公众号所配置的信息，以及回复内容进行查询并回复给用户
            String content = "欢迎关注开发公众号";
            WxMpXmlOutTextMessage outMessage = WxMpXmlOutMessage.TEXT()
                    .content(content)
                    .fromUser(inMessage.getToUser())
                    .toUser(inMessage.getFromUser())
                    .build();
            response.getWriter().write(outMessage.toXml());
            return;
        }
        /*if ("aes".equals(encryptType)) {
            // 是aes加密的消息
            String msgSignature = request.getParameter("msg_signature");
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromEncryptedXml(request.getInputStream(), wxMpConfigStorage, timestamp, nonce, msgSignature);
            WxMpXmlOutMessage outMessage = wxMpMessageRouter.route(inMessage);
            if(outMessage == null) {
                //为null，说明路由配置有问题，需要注意
                response.getWriter().write("");
            }
            response.getWriter().write(outMessage.toEncryptedXml(wxMpConfigStorage));
            return;
        }*/
    }

    /**
     * 发送图文
     * @author wangjunming
     * @since 2020/1/14 17:51
     * @param original:
     * @return com.study.modu.parent.utils.JsonResult
     */
    @ApiOperation("发送图文")
    @PostMapping("sendPictureTextMessage")
    public JsonResult sendPictureTextMessage(String original){

//--TODO--根据original从数据库中进行配置进行获取出来
        String appid = "wx6a583a0c8500d4";
        String secret = "8933105a928cc394aefc589fecdd82";
        boolean flag = false;
        WxMpDefaultConfigImpl config = new WxMpDefaultConfigImpl();
        config.setAppId(appid);
        config.setSecret(secret);
        String accessToken = WeChatStudyUtils.getAccessToken(appid,secret,redisTemplate);
        config.setAccessToken(accessToken);
        wxService.setWxMpConfigStorage(config);
        File file = new File("C:\\Users\\Calm\\Pictures\\桌面壁纸\\adler-4694474__340.jpg");
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (Exception e) {
            logger.error("上传图片失败!!",e);
            return JsonResult.success(flag);
        }
        WxMediaUploadResult uploadMediaRes = null;
        try {
            uploadMediaRes = wxService.getMaterialService().mediaUpload(WxConsts.MassMsgType.IMAGE, "jpg", inputStream);
        } catch (WxErrorException e) {
            logger.error("失败!!!--<",e);
            return JsonResult.success(flag);
        }
        WxMpMassOpenIdsMessage massMessage = new WxMpMassOpenIdsMessage();
        massMessage.setMsgType(WxConsts.MassMsgType.IMAGE);
        massMessage.setMediaId(uploadMediaRes.getMediaId());
        logger.info("获取得到的--MediaId-->{}",uploadMediaRes.getMediaId());
        List<String> openIds = new ArrayList<>();
        openIds.add("oPSI_wLYOH3CSqqB1mJnwGe4oYGE");
        openIds.add("oPSI_wPXAnvI0qrgaqfyfNNC1sx4");
        massMessage.setToUsers(openIds);
        try {
            WxMpMassSendResult massResult = wxService.getMassMessageService().massOpenIdsMessageSend(massMessage);
        } catch (WxErrorException e) {
            logger.error("发送失败：",e);
        }
        return JsonResult.success(flag);
    }
















}
