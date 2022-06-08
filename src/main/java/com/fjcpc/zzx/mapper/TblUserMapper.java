package com.fjcpc.zzx.mapper;

import com.fjcpc.zzx.pojo.TblUser;
import com.fjcpc.zzx.pojo.vo.ResetPwd;
import com.fjcpc.zzx.pojo.vo.UpdateInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xiaolu
 * @description 针对表【tbl_user】的数据库操作Mapper
 * @createDate 2022-05-31 10:41:49
 * @Entity generator.domain.TblUser
 */
@Mapper
public interface TblUserMapper {
    TblUser login(TblUser tblUser);

    TblUser register(TblUser tblUser);

    TblUser getInfoByUsername(String username);

    TblUser getInfoByUid(String uid);

    int delUserByUid(int uid);

    int updateInfo(UpdateInfo updateInfo);

    int resetPwd(ResetPwd resetPwd);
}
