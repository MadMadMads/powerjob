package com.github.kfcfans.powerjob.server.web.request;

import lombok.Data;

/**
 * 查询任务列表
 *
 * @author tjq
 * @since 2020/4/13
 */
@Data
public class QueryJobInfoRequest {

    // 任务所属应用ID
    private Long appId;
    // 当前页码
    private Integer index;
    // 页大小
    private Integer pageSize;

    // 查询条件
    private Long jobId;
    private String keyword;
}
