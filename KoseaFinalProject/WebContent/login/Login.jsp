<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- �ڹٺ�Ŭ���� import --%>
<%@ page import="jsp.member.model.MemberBean"%>
    <html>
        <head>
            <title>ȸ������ ó��</title>
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
            <%-- �ڹٺ� ���� �׼��±� ���--%>
            <jsp:useBean id = "memberBean" class="jsp.member.model.MemberBean"/>
            <jsp:setProperty property="*" name="memberBean"/>
        
            <div id = "wrap">
            <br><br>
            <b><font size="5" color="gray">ȸ������ ������ Ȯ���ϼ���</font></b>
            <br><br>
            <font color="blue"><%= memberBean.getNickname() %></font>�� ������ ���ϵ帳�ϴ�!
            <br><br>
               <%--�ڹٺ�׼� �Էµ� ���� �����Ѵ� --%>
            <table>
                <tr>
                    <td id="title">���̵�</td>
                    <td><%=memberBean.getId() %></td>
                </tr>
                <tr>
                    <td id="title">��й�ȣ</td>
                    <td><%=memberBean.getPassword() %></td>
                </tr>
                <tr>
                    <td id="title">�̸�</td>
                    <td><%=memberBean.getName() %></td>
                </tr>
                <tr>
                    <td id="title">�г���</td>
                    <td><%=memberBean.getNickname() %></td>
                </tr>
                <tr>
                    <td id="title">�̸���</td>
                    <td>
                    <%=memberBean.getMail1()%>@<%= memberBean.getMail2()%>
                    </td>
                </tr>
            </table>
            <br>
            <input type="button" value="Ȯ��">
        </div>
        
        </body>


    </html>