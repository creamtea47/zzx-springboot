package com.fjcpc.zzx.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @TableName tbl_user
 */
@ApiModel("用户实体类")
public class Register implements Serializable {

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 密码
     */

    @ApiModelProperty("密码")
    private String password;

    /**
     * 真实姓名
     */
    @ApiModelProperty("真实姓名")
    private String truename;

    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private String sex;

    /**
     * 电话，手机11，座机13
     */
    @ApiModelProperty("电话")
    private String telephone;

    /**
     * 出生日期
     */
    @ApiModelProperty("出生日前")
    private String birth;

    /**
     * 余额
     */
    @ApiModelProperty("座机13")
    private Double balance;

    /**
     * 注册时间，默认值，系统意见
     */
    @ApiModelProperty("注册时间，默认值，系统意见")
    private String regtime;

    /**
     * 用户权限，0为管理员，1为一般用户
     */
    @ApiModelProperty("出生日期")
    private Integer role;

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */

    /**
     * 用户编号
     */

    /**
     * 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 真实姓名
     */
    public String getTruename() {
        return truename;
    }

    /**
     * 真实姓名
     */
    public void setTruename(String truename) {
        this.truename = truename;
    }

    /**
     * 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 电话，手机11，座机13
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 电话，手机11，座机13
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 出生日期
     */
    public String getBirth() {
        return birth;
    }

    /**
     * 出生日期
     */
    public void setBirth(String birth) {
        this.birth = birth;
    }

    /**
     * 余额
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * 余额
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * 注册时间，默认值，系统意见
     */
    public String getRegtime() {
        return regtime;
    }

    /**
     * 注册时间，默认值，系统意见
     */
    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    /**
     * 用户权限，0为管理员，1为一般用户
     */
    public Integer getRole() {
        return role;
    }

    /**
     * 用户权限，0为管理员，1为一般用户
     */
    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Register other = (Register) that;
        return (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
                && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
                && (this.getTruename() == null ? other.getTruename() == null : this.getTruename().equals(other.getTruename()))
                && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
                && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
                && (this.getBirth() == null ? other.getBirth() == null : this.getBirth().equals(other.getBirth()))
                && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
                && (this.getRegtime() == null ? other.getRegtime() == null : this.getRegtime().equals(other.getRegtime()))
                && (this.getRole() == null ? other.getRole() == null : this.getRole().equals(other.getRole()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getTruename() == null) ? 0 : getTruename().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getBirth() == null) ? 0 : getBirth().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getRegtime() == null) ? 0 : getRegtime().hashCode());
        result = prime * result + ((getRole() == null) ? 0 : getRole().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", truename=").append(truename);
        sb.append(", sex=").append(sex);
        sb.append(", telephone=").append(telephone);
        sb.append(", birth=").append(birth);
        sb.append(", balance=").append(balance);
        sb.append(", regtime=").append(regtime);
        sb.append(", role=").append(role);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}