<%-- 
    Document   : cliente consulta ID
    Created on : 05 de set. de 2025, 20:59:14
    Author     : Adilson Lima
--%>

<%@page import="java.text.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Clientes"%>
<%@page import="model.DAO.ClientesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Clientes</title>
        <link href="../style/geral.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">         
    </head>
    <body>
        <div class="container">
            <h2>Clientes - Consulta Id - Alterar</h2>
            <%
                //Instância do Objeto
                Clientes cli = new Clientes();
                ClientesDAO cliDAO = new ClientesDAO();                        

                cli.setId(Integer.parseInt( request.getParameter("ident") ));

                cli = cliDAO.consulta_id(cli);

                if (cli == null){
                    out.println("Cliente não localiza!");
                }else{
            %>
                    <form method="post" action="cli_alt.jsp">
                        Identificador: <input type="number" name="ident" value="<%=cli.getId()%>" readonly="true"> <p>
                        Nome do Cliente: <input type="text" name="cliente" value="<%=cli.getNome()%>"> <p>
                        Email: <input type="email" name="email" value="<%=cli.getEmail()%>"> <p>
                        Renda: <input type="number" name="renda" step="0.25" value="<%=cli.getRenda()%>"> <p>
                        Celular: <input type="text" name="celular" value="<%=cli.getCelular()%>"> <p>
                        Nascimento: <input type="date" name="nascimento" value="<%= new SimpleDateFormat("yyyy-MM-dd").format(cli.getNasc())%>"> <p>
                       
                        <div class="buttons">
                          <button type="submit" class="submit-btn">Salvar Alteração</button>
                          <button type="reset" class="reset-btn">Limpar</button>
                        </div>                        
                    </form>
            <%  
                }                    
            %>
        </div>
    </body>
</html>