package com.greatech.workflow.dto;

import com.greatech.workflow.dto.config.BussObject;
import com.greatech.workflow.dto.config.ResultObject;

import java.io.Serializable;


/**
 * Created by bigbeard on 2017/5/18.
 * 流程节点配置信息
 */
public class FlowConfigNode implements Serializable {


    /**
     * 是否开始节点
     */
    boolean startNode = false;

    /**
     * 是否结束节点
     */
    boolean endNode = false;

    /**
     * 当前节点编号
     */
    String nodeKey;

    BussObject bussObject;

    ResultObject resultObject;

    public String getNodeKey() {
        return nodeKey;
    }

    public void setNodeKey(String nodeKey) {
        this.nodeKey = nodeKey;
    }

    public BussObject getBussObject() {
        return bussObject;
    }

    public void setBussObject(BussObject bussObject) {
        this.bussObject = bussObject;
    }

    public ResultObject getResultObject() {
        return resultObject;
    }

    public void setResultObject(ResultObject resultObject) {
        this.resultObject = resultObject;
    }

    public boolean getStartNode() {
        return startNode;
    }

    public boolean isStartNode() {
        return startNode;
    }

    public void setStartNode(boolean startNode) {
        this.startNode = startNode;
    }

    public boolean isEndNode() {
        return endNode;
    }

    public boolean getEndNode() {
        return endNode;
    }

    public void setEndNode(boolean endNode) {
        this.endNode = endNode;
    }
}
