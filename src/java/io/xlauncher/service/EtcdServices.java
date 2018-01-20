package io.xlauncher.service;

import io.xlauncher.entity.KeysInfosEntity;
import io.xlauncher.entity.NodesInfosEntity;

/**
 * Created by Administrator on 2018/1/19 0019.
 */
public interface EtcdServices {

    /**
     * 根据给定的IP获取etcd的集群信息
     * @param ip
     * @return
     * @throws Exception
     */
    public NodesInfosEntity getEtcdNodeInfos(String ip)throws Exception;

    /**
     * 创建Key，并设置Key的value
     * @param ip
     * @param key
     * @param value
     * @return
     */
    KeysInfosEntity setKeyAndValues(String ip, String key, String value)throws Exception;

    /**
     * 删除key
     * @param ip
     * @param keys
     * @return
     * @throws Exception
     */
    String deleteetcdkeys(String ip, String keys)throws Exception;

    /**
     * 监控指定的key
     * @param ip
     * @param keys
     * @return
     * @throws Exception
     */
    KeysInfosEntity watcherEtcdKeys(String ip, String keys)throws Exception;
}
