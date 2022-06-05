package com.fjcpc.zzx.service.impl;

import com.fjcpc.zzx.mapper.TblUserMapper;
import com.fjcpc.zzx.pojo.TblUser;
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
    public TblUser register(TblUser tblUser) {
        return tblUserMapper.register(tblUser);
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
    public TblUser delUserByUid(int uid) {
        return tblUserMapper.delUserByUid(uid);
    }

    @Override
    public int updateInfo(TblUser tblUser) {
        return tblUserMapper.updateInfo(tblUser);
    }

    @Override
    public int resetPwd(TblUser tblUser) {
        return tblUserMapper.resetPwd(tblUser);
    }
}