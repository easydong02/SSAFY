<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="UTF-8"/>
<div id="header">

    <div id="hleft">
    </div>
    <div id="hright">
        <a href='./users?command=logout'>로그아웃</a> |
        <a href='./boards?command=list'>목록보기</a> |
        <a href='./boards?command=bfwrite'>글쓰기</a>
    </div>
</div>