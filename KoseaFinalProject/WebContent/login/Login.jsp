<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- 자바빈클래스 import --%>
<%@ page import="jsp.member.model.MemberBean"%>
    <html>
        <head>
            <title>회원가입 처리</title>
            <style>
                #wrap{
                    margin-left:auto;
                    margin-right:auto;
                    text-align:center;
                }
                #title{
                    background-color:skyblue;
                }
            </style>
        </head>
        <body>
            <!---->
            <%
            request.setCharacterEncoding("euc-kr");
            String id = request.getParameter("id");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String nickname = request.getParameter("nickname");
            String email1 = request.getParameter("email_1");
            String[] email2 = request.getParameterValues("email2");
            %>
            <%-- 자바빈 관련 액션태그 사용--%>
            <jsp:useBean id = "memberBean" class="jsp.member.model.MemberBean"/>
            <jsp:setProperty property="*" name="memberBean"/>
        
            <div id = "wrap">
            <br><br>
            <b><font size="5" color="gray">회원가입 정보를 확인하세요</font></b>
            <br><br>
            <font color="blue"><%= memberBean.getNickname() %></font>님 가입을 축하드립니다!
            <br><br>
               <%--자바비네서 입력된 값을 추출한다 --%>
            <table>
                <tr>
                    <td id="title">아이디</td>
                    <td><%=memberBean.getId() %></td>
                </tr>
                <tr>
                    <td id="title">비밀번호</td>
                    <td><%=memberBean.getPassword() %></td>
                </tr>
                <tr>
                    <td id="title">이름</td>
                    <td><%=memberBean.getName() %></td>
                </tr>
                <tr>
                    <td id="title">닉네임</td>
                    <td><%=memberBean.getNickname() %></td>
                </tr>
                <tr>
                    <td id="title">이메일</td>
                    <td>
                    <%=memberBean.getMail1()%>@<%= memberBean.getMail2()%>
                    </td>
                </tr>
            </table>
            <br>
            <input type="button" value="확인">
        </div>
        
        </body>


    </html>