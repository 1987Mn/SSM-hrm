<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>人事管理系统——添加用户</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<link href="${ctx}/css/css.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="${ctx}/js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
	<link href="${ctx}/js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
	<script src="${ctx}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
	<link href="${ctx}/css/pager.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript">
	$(function(){
		$(".quxiao").click(function () {
			parent.location = "${ctx}/main";
		});

    	/** 员工表单提交 */
		$(".userForm").submit(function(){
			var username = $(".username");
			var status = $(".status");
			var loginname = $(".loginname");
			var password = $(".password");
			var msg = "";
			if ($.trim(username.val()) == ""){
				msg = "姓名不能为空！";
				alert(msg);
				username.focus();
				return false;
			}else if ($.trim(status.val()) == ""){
				msg = "状态不能为空！";
				alert(msg);
				status.focus();
				return false;
			}else if ($.trim(loginname.val()) == ""){
				msg = "登录名不能为空！";
				alert(msg);
				loginname.focus();
				return false;
			}else if ($.trim(password.val()) == ""){
				msg = "密码不能为空！";
				alert(msg);
				password.focus();
				return false;
			}
		});
    });
	</script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr><td height="10"></td></tr>
  <tr>
    <td width="15" height="32"><img src="${ctx}/images/main_locleft.gif" width="15" height="32"></td>
	<td class="main_locbg font2"><img src="${ctx}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：用户管理  &gt; 添加用户</td>
	<td width="15" height="32"><img src="${ctx}/images/main_locright.gif" width="15" height="32"></td>
  </tr>
</table>
<form name="userForm" class="userForm" id="userForm" action="/usersave" method="post">
<input type="hidden" name="id" value="${user.id}" />
<table width="100%"  border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
  <tr><td>${message}</td></tr>
  <tr valign="top">
    <td>
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    <tr><td class="font3 fftd">
		    	<table>
		    		<tr>
		    			<td class="font3 fftd">姓&nbsp;名：<input type="text" name="username" id="username" class="username" value="${user.username}" size="20"/></td>
		    			<td class="font3 fftd">状&nbsp;态：<input type="text" name="status" id="status" class="status" value="${user.status}" size="20"/></td>
		    		</tr>
		    		<tr>
		    			<td class="font3 fftd">登录名：<input name="loginname" class="loginname" value="${user.loginname}" id="loginname" size="20" /></td>
		    			<td class="font3 fftd">密&nbsp;码：<input name="password" class="password" value="${user.password}" id="password" size="20" /></td>
		    		</tr>
		    	</table>
		    </td></tr>
			<tr><td align="left" class="fftd">
				<input type="submit" value="保存">&nbsp;&nbsp;
				<input type="reset" class="quxiao" value="取消"></td></tr>
		  </table>
	</td>
  </tr>
</table>
</form>
</body>
</html>