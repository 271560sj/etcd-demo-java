package io.xlauncher.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrator on 2018/1/19 0019.
 */
public class KeysInfosEntity {

    @JsonProperty("action")
    private String action;

    @JsonProperty("node")
    private NodeEntity node;

    @JsonProperty("prevNode")
    private NodeEntity prevNode;
}
