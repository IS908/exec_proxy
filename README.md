# SvnBasePatch工具执行代理

> 基于svn的增量抽取工具在低版本的Jenkins执行shell通过java -jar执行时报如下错误：

````text
org.tmatesoft.svn.core.SVNException: svn: E125002: Malformed URL ${SVN_REPO}
at org.tmatesoft.svn.core.internal.wc.SVNErrorManager.error(SVNErrorManager.java:64)
at org.tmatesoft.svn.core.internal.wc.SVNErrorManager.error(SVNErrorManager.java:51)
at org.tmatesoft.svn.core.SVNURL.<init>(SVNURL.java:233)
at org.tmatesoft.svn.core.SVNURL.parseURIDecoded(SVNURL.java:115)
......
````

由于项目现场交付任务较紧，换高版本Jenkins周期较长，通过该工具进行java -jar执行代理。

即：直接通过将参数以http的GET请求的方式发送到本代理工具，将参数重新组装成java -jar xxxxxx，并执行调用SvnBasePatch工具的操作。

Jenkins执行shell转变为：
````bash
#!/bin/bash

curl http://127.0.0.1:8088?jar_name=xxxx&type=xxxx&yml_prefix=xxxxx&workspace=xxxx&version_from=xxxx&version_to=xxxx
````

其中，
- jar_name为jar包路径，与配置文件application.yml中的svn.tool.dir的值拼接成调用jar包的全路径：
${svn.tool.dir}/[jar_name]
- type值为xml\zip;
- workspace为本地源码根目录;
- version_from为起始版本号;
- version_to为截止版本号;
