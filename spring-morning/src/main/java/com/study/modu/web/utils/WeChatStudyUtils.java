package com.study.modu.web.utils;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * Explain:学习微信开发中所总结的工具类
 * </p >
 *
 * @author wangjunming
 * @since 2020-01-14 13:49
 */
public class WeChatStudyUtils {
    private static final Logger logger = LogManager.getLogger(WeChatStudyUtils.class);

    private static final WxMpService wxService = new WxMpServiceImpl();

    private final static String ACCESS_TOKEN = "ACCESS_TOKEN_";

    /**
     * 获取accessToken
     * @author wangjunming
     * @since 2020/1/15 11:30
     * @param appid: 公众号的APPID
     * @param secret: 公众号的密钥
     * @param redisTemplate: redis缓存
     * @return java.lang.String
     */
    public static String getAccessToken(String appid, String secret, RedisTemplate<String, String> redisTemplate) {
        String key = ACCESS_TOKEN + appid;
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        WxMpDefaultConfigImpl config = new WxMpDefaultConfigImpl();
        config.setAppId(appid);
        config.setSecret(secret);
        wxService.setWxMpConfigStorage(config);
        String accessToken = valueOperations.get(key);
        if (StringUtils.isBlank(accessToken)) {
            try {
                accessToken = wxService.getAccessToken();
                valueOperations.set(key, accessToken, 7200, TimeUnit.SECONDS);
                return accessToken;
            } catch (Exception e) {
                logger.error("生成accessToken失败!!!", e);
                return "";
            }
        } else {
            return accessToken;
        }
    }

}
