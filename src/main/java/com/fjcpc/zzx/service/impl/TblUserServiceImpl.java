package com.fjcpc.zzx.service.impl;

import com.fjcpc.zzx.mapper.TblUserMapper;
import com.fjcpc.zzx.pojo.TblUser;
import com.fjcpc.zzx.pojo.vo.Register;
import com.fjcpc.zzx.pojo.vo.ResetPwd;
import com.fjcpc.zzx.pojo.vo.UpdateInfo;
import com.fjcpc.zzx.service.TblUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * @author xiaolu LuAng
 * @create 2022-05-31 10:49
 **/
@Service
public class TblUserServiceImpl implements TblUserService {
    @Autowired
    private TblUserMapper tblUserMapper;


    @Override
    public TblUser login(TblUser tblUser) {
        return tblUserMapper.login(tblUser);
    }

    @Override
    public TblUser register(Register register) {
        return tblUserMapper.register(register);
    }

    @Override
    public TblUser getInfoByUsername(String username) {
        return tblUserMapper.getInfoByUsername(username);
    }

    @Override
    public TblUser getInfoByUid(String uid) {
        return tblUserMapper.getInfoByUid(uid);
    }

    @Override
    public int delUserByUid(int uid) {
        return tblUserMapper.delUserByUid(uid);
    }

    @Override
    public int updateInfo(UpdateInfo updateInfo) {
        return tblUserMapper.updateInfo(updateInfo);
    }

    @Override
    public int resetPwd(ResetPwd resetPwd) {
        return tblUserMapper.resetPwd(resetPwd);
    }

}