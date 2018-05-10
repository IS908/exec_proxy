package com.dcits.patch.tool.svn.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author Kevin
 * @date 2018-05-10 17:40.
 * @desc 封装返回结果
 * @email chenkunh@dcits.com
 */
@Data
@ToString
public class ExecResult {
    private int exitCode;
    private String executeOut;

    public ExecResult(int exitCode, String executeOut) {
        this.exitCode = exitCode;
        this.executeOut = executeOut;
    }
}
