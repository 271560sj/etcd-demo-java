package io.xlauncher.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Bean;

/**
 * Created by Administrator on 2018/1/19 0019.
 */
public class NodesInfosEntity {

    @JsonProperty("nodeName")
    private String nodeName;

    @JsonProperty("etcdcluster")
    private String clusterVersion;

    @JsonProperty("etcdserver")
    private String etcdVersion;
}
