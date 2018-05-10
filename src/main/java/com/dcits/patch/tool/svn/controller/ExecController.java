package com.dcits.patch.tool.svn.controller;

import com.dcits.patch.tool.svn.conf.SpringConf;
import com.dcits.patch.tool.svn.service.LocalCommandExecutor;
import com.dcits.patch.tool.svn.service.impl.LocalCommandExecutorImpl;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Kevin
 * @date 2018-05-10 16:07.
 * @desc
 * @email chenkunh@dcits.com
 */
@RestController
@RequestMapping("/svn")
public class ExecController {
    private static final Logger logger = LoggerFactory.getLogger(ExecController.class);

    @Resource
    @Getter
    @Setter
    private SpringConf springConf;

    private final String JAVA_JAR = "java -jar";


    @GetMapping("/runJar")
    public String runJar(@RequestParam("jar_name") String jarName,
                         @RequestParam("type") String type,
                         @RequestParam("yml_prefix") String ymlPrefix,
                         @RequestParam("workspace") String workspace,
                         @RequestParam("version_from") String versionFrom,
                         @RequestParam("version_to") String versionTo) {
        logger.info("Execute runJar...");
        logger.info(springConf.getSvn_tool_dir());
        StringBuffer sb = new StringBuffer(JAVA_JAR);
        sb.append(" ").append(springConf.getSvn_tool_dir()).append(jarName).append(" ");
        sb.append(type).append(" ");
        sb.append(ymlPrefix).append(" ");
        sb.append(workspace).append(" ");
        sb.append(versionFrom).append(" ");
        sb.append(versionTo).append(" ");

        LocalCommandExecutor commandExecutor = new LocalCommandExecutorImpl();
        commandExecutor.executeCommand(sb.toString(), 30 * 1000);
        return "success";
    }

}
