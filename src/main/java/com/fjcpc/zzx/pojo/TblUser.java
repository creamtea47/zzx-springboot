package generator.domain;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 
 * @TableName tbl_user
 */
public class TblUser implements Serializable {
    /**
     * 用户编号
     */
    private Object uid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 
     */
    private String truename;

    /**
     * 性别
     */
    private String sex;

    /**
     * 电话，手机11，座机13
     */
    private String telephone;

    /**
     * 出生日期
     */
    private String birth;

    /**
     * 余额
     */
    private Double balance;

    /**
     * 用户权限，0为管理员，1为一般用户
     */
    private Integer role;

    /**
     * 注册时间，默认值，系统意见
     */
    private byte[] regtime;

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    public Object getUid() {
        return uid;
    }

    /**
     * 用户编号
     */
    public void setUid(Object uid) {
        this.uid = uid;
    }

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
     * 
     */
    public String getTruename() {
        return truename;
    }

    /**
     * 
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

    /**
     * 注册时间，默认值，系统意见
     */
    public byte[] getRegtime() {
        return regtime;
    }

    /**
     * 注册时间，默认值，系统意见
     */
    public void setRegtime(byte[] regtime) {
        this.regtime = regtime;
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
        TblUser other = (TblUser) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getTruename() == null ? other.getTruename() == null : this.getTruename().equals(other.getTruename()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getBirth() == null ? other.getBirth() == null : this.getBirth().equals(other.getBirth()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getRole() == null ? other.getRole() == null : this.getRole().equals(other.getRole()))
            && (Arrays.equals(this.getRegtime(), other.getRegtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getTruename() == null) ? 0 : getTruename().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getBirth() == null) ? 0 : getBirth().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getRole() == null) ? 0 : getRole().hashCode());
        result = prime * result + (Arrays.hashCode(getRegtime()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", truename=").append(truename);
        sb.append(", sex=").append(sex);
        sb.append(", telephone=").append(telephone);
        sb.append(", birth=").append(birth);
        sb.append(", balance=").append(balance);
        sb.append(", role=").append(role);
        sb.append(", regtime=").append(regtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}