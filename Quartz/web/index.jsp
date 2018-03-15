<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<%--APP ID：101439324--%>
<%--APP Key：1d9623a09a4d507e7fa143c80cd437ae--%>

<html>
  <head>
    <title>QQ登录</title>
    <script type="text/javascript" src="http://qzonestyle.gtimg.cn/qzone/openapi/qc_loader.js" data-appid="101439324" data-redirecturi="http://localhost:8080/index.jsp" charset="utf-8"></script>
  </head>
  <body>
  <span id="qqLoginBtn"></span>
  <script type="text/javascript">
      QC.Login({
          btnId:"qqLoginBtn"
      });
  </script>
  <a href="javascript:void(0);" onclick="getOpenId();">获取openid</a>
  <a href="javascript:void(0);" onclick="getInfo();">获取用户信息</a>
  </body>
  <script>

      function getOpenId() {
          QC.Login.getMe(function(openId, accessToken){
              alert(openId);
              alert(accessToken);
          })
      }

      function  getInfo() {
          QC.api("get_user_info", {})
              .success(function(s){
                  alert("获取用户信息成功！当前用户昵称为："+s.data.nickname);
              })
              .error(function(f){
                  alert("获取用户信息失败！");
              })
              .complete(function(c){
                  alert("获取用户信息完成！");
              });
      }
  </script>
</html>
