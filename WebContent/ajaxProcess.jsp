<%@page import="dao.UserDaoSX"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    //1， 转码
    request.setCharacterEncoding("utf-8");
    //2,接收数据
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    UserDaoSX Sx = new UserDaoSX();
    boolean Panduan=Sx.GetUser(username, password);
    
    //3,登录判断逻辑（正确账号：朱强，密码：123）
    if(Panduan){
         //将用户名数据存入session，以便作登录保护用
         session.setAttribute("username",username); 
         //返回登录成功数据（1代表成功）
         out.println("1");
    }else{
         //返回登录失败数据（0代表失败）
         out.println("0");
    }
    return;
 %>