package io.xlauncher.controller;

import io.xlauncher.entity.KeysInfosEntity;
import io.xlauncher.entity.NodesInfosEntity;
import io.xlauncher.service.EtcdServices;
import mousio.etcd4j.EtcdClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URI;

/**
 * Created by Administrator on 2018/1/19 0019.
 */
@Controller
@RequestMapping(value = "/etcd")
public class EtcdController {

    @Autowired
    EtcdServices etcdServices;

    //根据给定的IP查询ETCD集群的信息
    @ResponseBody
    @RequestMapping(value = "/getEtcdInfos")
    public NodesInfosEntity getEtcdClientInfos(String nodeIP)throws Exception{
        NodesInfosEntity nodeInfos = etcdServices.getEtcdNodeInfos(nodeIP);
        return nodeInfos;
    }

    @ResponseBody
    @RequestMapping(value = "/setEtcdKeysAndValues")
    public KeysInfosEntity setKeyAndValues(String ip,String key,String value)throws Exception{
        KeysInfosEntity entity = etcdServices.setKeyAndValues(ip,key,value);
        return entity;
    }

    @ResponseBody
    @RequestMapping(value = "deleteEtcdKeys")
    public String deleteEtcdKes(String ip, String keys)throws Exception{
        String entity = etcdServices.deleteetcdkeys(ip,keys);
        return entity;
    }

    @ResponseBody
    @RequestMapping(value = "watcherEtcdKeys")
    public KeysInfosEntity watcherEtcdKeys(String ip, String keys)throws Exception{
        KeysInfosEntity entity = etcdServices.watcherEtcdKeys(ip,keys);
        return entity;
    }
}
