<%-- 
    Document   : produto
    Created on : 27 de ago. de 2025, 20:13:12
    Author     : alunocmc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Produtos"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Produtos</title>
    </head>
    <body>
        <h2>Produtos</h2>
        <%
            //Instância do Objeto e Atriuição de valores
            Produtos prod = new Produtos(Integer.parseInt( request.getParameter("ident")), 
                    request.getParameter("produto"), 
                    Float.parseFloat(request.getParameter("valor")), 
                    Integer.parseInt(request.getParameter("qtd")) );           
                                               
            // Saída
            out.println(" <b>Identificador......:</b> " + prod.getId());
            out.println("<br> <b>Nome do Produto:</b> " + prod.getProduto());
            out.println("<br> <b>Valor:</b> " + prod.getValor());            
            out.println("<br> <b>Quantidade:</b> " + prod.getQtd());                   
        %>
    </body>
</html>
