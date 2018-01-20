package io.xlauncher.dao;

import io.xlauncher.entity.KeysInfosEntity;
import io.xlauncher.entity.NodesInfosEntity;

/**
 * Created by Administrator on 2018/1/19 0019.
 */
public interface EtcdDao {
    /**
     * 根据IP获取ETCD集群的信息
     * @param ip
     * @return
     * @throws Exception
     */
    public NodesInfosEntity getEtcdNodesInfos(String ip)throws Exception;

    /**
     * 创建Key，并设置Key的value值
     * @param ip
     * @param value
     * @return
     * @throws Exception
     */
    public KeysInfosEntity setKeyAndValues(String ip, String value)throws Exception;

    /**
     * 删除ETCD的Key
     * @param url
     * @return
     * @throws Exception
     */
    String deleteEtcdKeys(String url)throws Exception;

    /**
     * 监控etcd的Key值的变化
     * @param url
     * @return
     * @throws Exception
     */
    KeysInfosEntity watcherEtcdKeys(String url)throws Exception;
}
