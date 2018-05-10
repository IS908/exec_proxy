package com.dcits.patch.tool.svn.conf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Kevin
 * @date 2018-05-10 16:25.
 * @desc
 * @email chenkunh@dcits.com
 */
@Component
@PropertySource("classpath:application.yml")
public class SpringConf {

    @Value("${svn.tool.dir}")
    @Setter @Getter
    private String svn_tool_dir;
}
