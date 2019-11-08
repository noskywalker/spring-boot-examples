package com.neo.ant;

import com.neo.ant.dao.UserInfoDao;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xianshuangzhang
 * @date 2019/10/21 17:19
 */
public class UserInfoCacheFacade {

    public volatile boolean inited=false;

    UserInfoDao dao;

    Map<String,UserInfoWrapper> cache=new ConcurrentHashMap<>();

    ReentrantReadWriteLock lock=new ReentrantReadWriteLock();

    @PostConstruct
    public synchronized void initUserInfoCache() {
        if(inited==false) {
            List<UserInfo> list = dao.getUserInfoList();
            list.stream().forEach(i -> {
                UserInfoWrapper wrapper = new UserInfoWrapper(i);
                cache.put(i.getUserId(), wrapper);
            });
            inited=true;
        }
    }

    public UserInfo getUserInfoFromCacheById(String id) {

        if(StringUtils.isEmpty(id)){
            return null;
        }
       if(inited==false){
           initUserInfoCache();
       }
       Optional<UserInfoWrapper> wrapper= Optional.ofNullable(cache.get(id));
       if(wrapper.orElse(UserInfoWrapper.EMPTY).expired()){
            updateUserInfoCache(id);
       }
       //double check
        wrapper=Optional.ofNullable(cache.get(id));
       return wrapper.orElse(UserInfoWrapper.EMPTY).userInfo;
    }

    public UserInfo updateUserInfoCache(String id) {
        lock.writeLock().lock();
        UserInfoWrapper userInfo=null;//get userinfo by id;

        if((userInfo=cache.get(id))==null){
            userInfo=null;//getUserInfoByid();
            cache.put(id, new UserInfoWrapper(null));
        }

        return userInfo.userInfo;
    }
}
