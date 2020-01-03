package com.study.modu.web.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author wangjunming
 * @since 2020-01-02
 */
@TableName("ko_user")
@ApiModel(value="KoUser对象", description="用户表")
public class KoUser extends Model<KoUser> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户名(登录名)")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty(value = "真实姓名")
    @TableField("real_name")
    private String realName;

    @ApiModelProperty(value = "身份证号")
    @TableField("identity_card")
    private String identityCard;

    @ApiModelProperty(value = "用户邮箱")
    @TableField("user_email")
    private String userEmail;

    @ApiModelProperty(value = "1--男；2--女；")
    @TableField("sex")
    private Integer sex;

    @ApiModelProperty(value = "年龄")
    @TableField("age")
    private Integer age;

    @ApiModelProperty(value = "登录密码")
    @TableField("user_password")
    private String userPassword;

    @ApiModelProperty(value = "权限加盐")
    @TableField("salt")
    private String salt;

    @ApiModelProperty(value = "通讯地址")
    @TableField("postal_address")
    private String postalAddress;

    @ApiModelProperty(value = "联系电话")
    @TableField("contact_number")
    private String contactNumber;

    @ApiModelProperty(value = "用户最后登录时间")
    @TableField("login_time")
    private LocalDateTime loginTime;

    @ApiModelProperty(value = "创建者")
    @TableField("creater")
    private Long creater;

    @ApiModelProperty(value = "创建时间")
    @TableField("creater_time")
    private LocalDateTime createrTime;

    @ApiModelProperty(value = "更新者")
    @TableField("updater")
    private Long updater;

    @ApiModelProperty(value = "更新时间")
    @TableField("updater_time")
    private LocalDateTime updaterTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public LocalDateTime getCreaterTime() {
        return createrTime;
    }

    public void setCreaterTime(LocalDateTime createrTime) {
        this.createrTime = createrTime;
    }

    public Long getUpdater() {
        return updater;
    }

    public void setUpdater(Long updater) {
        this.updater = updater;
    }

    public LocalDateTime getUpdaterTime() {
        return updaterTime;
    }

    public void setUpdaterTime(LocalDateTime updaterTime) {
        this.updaterTime = updaterTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "KoUser{" +
        "id=" + id +
        ", userName=" + userName +
        ", realName=" + realName +
        ", identityCard=" + identityCard +
        ", userEmail=" + userEmail +
        ", sex=" + sex +
        ", age=" + age +
        ", userPassword=" + userPassword +
        ", salt=" + salt +
        ", postalAddress=" + postalAddress +
        ", contactNumber=" + contactNumber +
        ", loginTime=" + loginTime +
        ", creater=" + creater +
        ", createrTime=" + createrTime +
        ", updater=" + updater +
        ", updaterTime=" + updaterTime +
        "}";
    }
}
