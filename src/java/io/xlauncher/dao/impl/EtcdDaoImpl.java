package io.xlauncher.dao.impl;

import com.alibaba.fastjson.JSONObject;
import io.xlauncher.dao.EtcdDao;
import io.xlauncher.entity.KeysInfosEntity;
import io.xlauncher.entity.NodesInfosEntity;
import org.springframework.http.*;
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
        String values = "value="+value;
        System.out.println(values);
        try {
            JSONObject jsonObject = new JSONObject(map);
            String str = jsonObject.toJSONString();
            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.TEXT_PLAIN);
            HttpEntity<String> entity = new HttpEntity<String>(values,headers);
//             restTemplate.put(ip,values,new Object[]{});
            ResponseEntity<KeysInfosEntity> responseEntity = restTemplate.exchange(ip, HttpMethod.PUT,entity,KeysInfosEntity.class);
            if (responseEntity.getStatusCodeValue() == 200){
                KeysInfosEntity entitys = responseEntity.getBody();
                return entitys;
            }
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        return null;
    }

    public String deleteEtcdKeys(String url) throws Exception {
        String result;
        try {
            restTemplate.delete(url,new Object[]{});
            result = "success";
        }catch (Exception e){
            result = "failed";
            return result;
        }
        return result;
    }

    public KeysInfosEntity watcherEtcdKeys(String url) throws Exception {
        try {
//            ResponseEntity<KeysInfosEntity>
        }catch (Exception e){

        }
        return null;
    }
}
