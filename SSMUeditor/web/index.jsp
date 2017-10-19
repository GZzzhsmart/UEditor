<%--
  Created by IntelliJ IDEA.
  User: chenfeilong
  Date: 2017/10/18
  Time: 09:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/hui.css" />
</head>
<body>
<header class="hui-header">
    <div id="hui-back"></div>
</header>
<div class="hui-wrap">
    <div class="hui-center-title" style="margin-top:15px;"><h1>演示样例</h1></div>
    <div style="padding:28px 5px;">
        <div class="hui-tab">
            <div class="hui-tab-title">
                <div>查看列表</div>
                <div>说明</div>
                <div>sql文件</div>
                <div>演示demo</div>
            </div>
            <div class="hui-tab-body">
                <div class="hui-tab-item hui-list">
                    <a type="button" href="<%=path%>/ueditor/list" class="hui-button hui-primary hui-fl" style="margin-left:10px;">查看列表</a>
                </div>
                <div class="hui-tab-item hui-list">
                    <ul>
                        <li>1、登录ueditor官网下载jsp-utf-8版本的ueditor</li>
                        <li>2、找到下载后ueditor目录里面的jsp目录下的的lib目录，把5个jar包部署到WEB-INF/lib下</li>
                        <li>
                            3、新建一个jsp页面,引入如下js文件，即本项目中的web根目录下的index.jsp文件
                            <p>
                                &nbsp;&nbsp;&nbsp;&nbsp;1）<script type="text/javascript" charset="utf-8" src="ueditor.config.js"></script>
                            </p>
                            <p>
                                &nbsp;&nbsp;&nbsp;&nbsp;2）<script type="text/javascript" charset="utf-8" src="ueditor.all.min.js"> </script>
                            </p>
                            <p>
                                &nbsp;&nbsp;&nbsp;&nbsp;3）<script type="text/javascript" charset="utf-8" src="lang/zh-cn/zh-cn.js"></script>
                            </p>
                        </li>
                        <li>
                            4、些一个表单，实现文本区域框和ueditor融合，并设置相应的高度和宽度，并加入script脚本，获取ue对象，文本区域框的id必须和UE.getEditor括号中的参数保持一致
                            <p>
                                &nbsp;&nbsp;&nbsp;&nbsp;<textarea id="editor" style="height:400px;width:1000px"></textarea>
                            </p>
                            <p>
                                &nbsp;&nbsp;&nbsp;&nbsp;<script type="text/javascript">
                                    var ue = UE.getEditor('editor');
                                    </script>
                            </p>
                        </li>
                        <li>5、运行界面，效果就出来了，可上传单张，或多张</li>
                        <li>6、开始连接数据库，采用jsp+servlet方式，当然可以使用maven项目，配置mysql的jar包文件（本人采用的是idea编译器，连接mysql保存数据）</li>
                        <li>7、建立相对于的包，存放javabean、servlet、数据库连接类、sql操作类（sql参照documents下的ueditor.sql文件）</li>
                        <li>8、导入mysql的jar包，本项目是5.1.3的jar包，测试连接，本项目中的sqlcon包下面的MysqlConnection类（放开注释测试，更改用户名驱动，密码，url，可以改用其他的连接方式）</li>
                        <li>9、导入js、css文件，相应的前台框架</li>
                    </ul>
                </div>
                <div class="hui-tab-item hui-list">
                    drop table if EXISTS ueditor;
                    create table ueditor(
                    id int primary key AUTO_INCREMENT,
                    content TEXT ,
                    createTime DATETIME DEFAULT  now()

                    )engine=innodb default charset=utf8;
                </div>
                <div class="hui-tab-item hui-list">
                    <form action="" method="post">
                        <textarea id="ueditor" style="height:300px;width:800px"></textarea>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="<%=path%>/js/hui.js"></script>
<script src="<%=path%>/js/hui-tab.js" type="text/javascript"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
    hui.tab('.hui-tab');
</script>
<script type="text/javascript">
    var ue = UE.getEditor('ueditor');
</script>
</body>
</html>