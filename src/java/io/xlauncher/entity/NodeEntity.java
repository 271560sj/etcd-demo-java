package io.xlauncher.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrator on 2018/1/19 0019.
 */
public class NodeEntity {

    @JsonProperty("key")
    private String key;

    @JsonProperty("value")
    private String value;

    @JsonProperty("modifiedIndex")
    private int modifiedIndex;

    @JsonProperty("createdIndex")
    private int createdIndex;
}
