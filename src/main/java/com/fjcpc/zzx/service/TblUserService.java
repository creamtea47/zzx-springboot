package com.fjcpc.zzx.service;

import com.fjcpc.zzx.pojo.TblUser;
import com.fjcpc.zzx.pojo.vo.Register;
import com.fjcpc.zzx.pojo.vo.ResetPwd;
import com.fjcpc.zzx.pojo.vo.UpdateInfo;

/***
 * @author xiaolu LuAng
 * @create 2022-05-31 10:49
 **/
public interface TblUserService {
    TblUser login(TblUser tblUser);

    TblUser register(Register register);

    TblUser getInfoByUsername(String username);

    TblUser getInfoByUid(String uid);

    int delUserByUid(int uid);

    int updateInfo(UpdateInfo updateInfo);

    int resetPwd(ResetPwd resetPwd);

}
