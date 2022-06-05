package com.fjcpc.zzx.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/*** 修改密码
 * @author xiaolu LuAng
 * @create 2022-06-02 11:51
 **/
@ApiModel("用户修改密码实体类")
public class ResetPwd {
    @ApiModelProperty("用户编号")
    private int uid;

    @ApiModelProperty("用户旧密码")
    private String oldPassword;

    @ApiModelProperty("用户新密码")
    private String newPassword;


    public ResetPwd(int uid, String oldPassword, String newPassword) {
        this.uid = uid;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "resetPwd{" + "uid=" + uid + ", oldPassword='" + oldPassword + '\'' + ", newPassword='" + newPassword + '\'' + '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

}