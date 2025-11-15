<%-- 
    Document   : cliente consulta ID
    Created on : 05 de set. de 2025, 20:59:14
    Author     : Adilson Lima
--%>

<%@page import="java.text.SimpleDateFormat"%>
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
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet"> 
        <link href="../style/geral.css" rel="stylesheet" type="text/css"/>        
    </head>
    <body>
        <div class="container">
            <h2>Clientes - Consulta Id</h2>
            <%
                //Instância do Objeto
                Clientes cli = new Clientes();
                ClientesDAO cliDAO = new ClientesDAO();                        

                cli.setId(Integer.parseInt( request.getParameter("ident") ));

                cli = cliDAO.consulta_id(cli);

                if (cli == null){
                    out.println("Cliente não localiza!");
                }else{                       
                    out.println("<img src=" + cli.getImagem_url()+">");
                    
                    out.println("<br><br> <b>Identificador......:</b> " + cli.getId());
                    out.println("<br> <b>Nome do Cliente:</b> " + cli.getNome());
                    out.println("<br> <b>Email:</b> " + cli.getEmail());
                    out.println("<br> <b>Renda:</b> " + cli.getRenda());
                    out.println("<br> <b>Celular:</b> " + cli.getCelular());
                    out.println("<br> <b>Nascimento:</b> " +  new SimpleDateFormat("dd/MM/yyyy").format(cli.getNasc()));
                }                    
            %>
        </div>
    </body>
</html>