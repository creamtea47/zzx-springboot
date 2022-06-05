package com.fjcpc.zzx.service;

import com.fjcpc.zzx.pojo.TblUser;

/***
 * @author xiaolu LuAng
 * @create 2022-05-31 10:49
 **/
public interface TblUserService {
    TblUser login(TblUser tblUser);

    TblUser register(TblUser tblUser);

    TblUser getInfoByUsername(String username);

    TblUser getInfoByUid(String uid);

    TblUser delUserByUid(int uid);

    int updateInfo(TblUser tblUser);

    int resetPwd(TblUser tblUser);
}
