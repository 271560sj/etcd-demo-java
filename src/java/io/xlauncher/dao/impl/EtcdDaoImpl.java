package io.xlauncher.dao.impl;

import io.xlauncher.dao.EtcdDao;
import io.xlauncher.entity.KeysInfosEntity;
import io.xlauncher.entity.NodesInfosEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/19 0019.
 */
@Component
public class EtcdDaoImpl implements EtcdDao{

    private RestTemplate restTemplate = new RestTemplate();
    public NodesInfosEntity getEtcdNodesInfos(String ip) throws Exception {
        String url = ip + "/version";
        try {
            ResponseEntity<NodesInfosEntity> responseEntity = restTemplate.getForEntity(url,NodesInfosEntity.class);
            NodesInfosEntity entity = responseEntity.getBody();
            if (entity != null){
                return entity;
            }
        }catch (Exception e){
        }
        return null;
    }

    public KeysInfosEntity setKeyAndValues(String ip, String value) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("value",value);
        try {
             restTemplate.put(ip,null,value);
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        return null;
    }
}
