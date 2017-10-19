<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  String path = request.getContextPath();
%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
  <meta charset="utf-8">
  <meta name="renderer" content="webkit|ie-comp|ie-stand">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="Bookmark" href="/favicon.ico" >
  <link rel="Shortcut Icon" href="/favicon.ico" />
  <!--[if lt IE 9]>
  <script type="text/javascript" src="<%=path%>/js/html5shiv.js"></script>
  <script type="text/javascript" src="<%=path%>/js/respond.min.js"></script>
  <![endif]-->
  <link rel="stylesheet" type="text/css" href="<%=path%>/css/h-ui/css/H-ui.min.css" />
  <link rel="stylesheet" type="text/css" href="<%=path%>/css/h-ui.admin/css/H-ui.admin.css" />
  <link rel="stylesheet" type="text/css" href="<%=path%>/css/Hui-iconfont/1.0.8/iconfont.css" />
  <link rel="stylesheet" type="text/css" href="<%=path%>/css/h-ui.admin/skin/default/skin.css" id="skin" />
  <link rel="stylesheet" type="text/css" href="<%=path%>/css/h-ui.admin/css/style.css" />
  <link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/icon.css"/>
  <link rel="stylesheet" type="text/css" href="<%=path %>/css/themes/gray/easyui.css">
  <!--[if IE 6]>
  <script type="text/javascript" src="<%=path%>/js/DD_belatedPNG_0.0.8a-min.js" ></script>
  <script>DD_belatedPNG.fix('*');</script>
  <![endif]-->
  <!--/meta 作为公共模版分离出去-->

  <title>更新数据</title>
</head>
<body>
<article class="page-container">
  <form class="form form-horizontal"  id="form-member-add">
    <input type="hidden" value="${ueditor.id}"  name="id" />
    <div class="row cl">
      <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>资讯标题：</label>
      <div class="formControls col-xs-8 col-sm-9">
        <input type="text" class="input-text" value="${ueditor.title}" placeholder="" id="title" name="title">
      </div>
    </div>
    <div class="row cl">
      <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>资讯内容：</label>
      <div class="formControls col-xs-8 col-sm-9">
        <textarea   style="width:566px;height:300px"  id="content" name="content">${ueditor.content}</textarea>
      </div>
    </div>
    <div style="height:50px"></div>
    <div class="row cl">
      <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
        <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;修改&nbsp;&nbsp;">
      </div>
    </div>
  </form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/layer/2.4/layer.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=path%>/js/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
    var ue = UE.getEditor('content');
</script>
<script type="text/javascript">
    $(function(){
        $("#form-member-add").validate({
            rules:{
                title:{
                    required:true,
                    minlength:0,
                    maxlength:50
                }
            },
            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
                //$(form).ajaxSubmit();
                $.post(
                    "<%=path%>/ueditor/update",$("#form-member-add").serialize(),
                    function(data){
                    },
                    "json"
                );
                var index = parent.layer.getFrameIndex(window.name);
                parent.$('#patrentutl').trigger("click");
                parent.layer.close(index);

            }
        });
    });
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>