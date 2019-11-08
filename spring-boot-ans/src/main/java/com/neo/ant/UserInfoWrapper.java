package com.neo.ant;

/**
 * @author xianshuangzhang
 * @date 2019/10/21 17:43
 */
public class UserInfoWrapper {
    public static UserInfoWrapper EMPTY=new UserInfoWrapper(null);
    public UserInfo userInfo;
    long lastUpdatedTimeStamp=System.currentTimeMillis();

    public UserInfoWrapper(UserInfo i) {
        this.userInfo=i;
    }

    public boolean expired(){
        return userInfo==null||System.currentTimeMillis()-lastUpdatedTimeStamp>30*60*1000L;
    }
}
