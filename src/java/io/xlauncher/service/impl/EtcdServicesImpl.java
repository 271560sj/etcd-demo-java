package io.xlauncher.service.impl;

import io.xlauncher.dao.EtcdDao;
import io.xlauncher.entity.KeysInfosEntity;
import io.xlauncher.entity.NodesInfosEntity;
import io.xlauncher.service.EtcdServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/1/19 0019.
 */
@Service
public class EtcdServicesImpl implements EtcdServices{

    @Autowired
    EtcdDao etcdDao;

    public NodesInfosEntity getEtcdNodeInfos(String ip) throws Exception {
        if (ip == null || "".equals(ip)){
            return null;
        }else {
            ip = "http://" + ip;
        }
        NodesInfosEntity entity = etcdDao.getEtcdNodesInfos(ip);
        return entity;
    }

    public KeysInfosEntity setKeyAndValues(String ip, String key, String value) throws Exception{
        if (ip == null || "".equals(ip)){
            return null;
        }else {
            ip = "http://" + ip + "/v2/keys/" + key;
        }

        KeysInfosEntity entity = etcdDao.setKeyAndValues(ip,value);
        return entity;
    }

    public String deleteetcdkeys(String ip, String keys) throws Exception {
        String url = "http://" + ip +"/v2/keys/" + keys;

        String entity = etcdDao.deleteEtcdKeys(url);
        return entity;
    }

    public KeysInfosEntity watcherEtcdKeys(String ip, String keys) throws Exception {

        String url = "http://" + ip + "/v2/keys/" + keys +"?wait=true";
        KeysInfosEntity entity = etcdDao.watcherEtcdKeys(url);
        return entity;
    }
}
