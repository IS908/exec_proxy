package com.dcits.patch.tool.svn.service;

import com.dcits.patch.tool.svn.model.ExecResult;

/**
 * @author Kevin
 * @date 2018-05-10 17:41.
 * @desc 执行命令对外接口
 * @email chenkunh@dcits.com
 */
public interface LocalCommandExecutor {
    ExecResult executeCommand(String command, long timeout);
}
