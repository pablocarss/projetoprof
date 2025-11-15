<%-- 
    Document   : cliente apagar
    Created on : 10 de set. de 2025, 20:59:14
    Author     : Adilson Lima
--%>

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
            <h2>Clientes - Apagar</h2>
            <%
                //Instância do Objeto

                // Entrada / Atrib. valores
                int id = Integer.parseInt( request.getParameter("ident"));

                //Apgar
                ClientesDAO cliDAO = new ClientesDAO();
                if (cliDAO.excluir(id)){
                    out.println("<br><br> Cliente Excluído com Sucesso!!!"); 
                }else{
                    out.println("<br><br> Cliente Não Excluído!!!");
                }        
            %>
        </div>
    </body>
</html>
