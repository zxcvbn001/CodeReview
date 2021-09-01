<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%


    session = request.getSession();

    session.setAttribute("userName", "admin");
    session.setAttribute("orgName", "");
    session.setAttribute("orgId", "0");
    session.setAttribute("orgIdString", "");
    session.setAttribute("browseRange", "0");

//this.request.setAttribute("sysCode", "1");
    session.setAttribute("keySerial",  null);
    session.setAttribute("domainId", "0");

    session.setAttribute("userId", "0");
    session.setAttribute("userAccount", "admin");

//dsession.setAttribute("sysManager", userInfo.get("sysManager"));
    session.setAttribute("skin", "2015/color1");
    session.setAttribute("rootCorpId", "0");
    session.setAttribute("corpId", "0");
    session.setAttribute("departId", "0");
    session.setAttribute("pageFontsize", "14");

    session.setAttribute("orgEnglishName", "");

    session.setAttribute("empNumber", "");

    session.setAttribute("empBusinessPhone", "");

    session.setAttribute("orgSelfName", "");

    session.setAttribute("empIdCard", "");

    session.setAttribute("userPageSize", "15");

    session.setAttribute("userIdentityNo", "");
    session.setAttribute("hasLoged", null);
    CookieParser cookieparser = new CookieParser();
    cookieparser.addCookie(this.response, "JSESSIONID", session.getId(), 31536000, null, "/", false);
    cookieparser.addCookie(this.response, "OASESSIONID", session.getId(), 31536000, null, "/", false);
    //System.out.println(session.getAttribute("userAccount"));
    out.println(session.getId());
%>
ok