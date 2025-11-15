<%-- 
    Document   : cliente
    Created on : 22 de ago. de 2025, 20:59:14
    Author     : alunocmc
--%>

<%@page import="java.text.SimpleDateFormat"%>
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
            <h2>Clientes</h2>
            <%
                //Instância do Objeto
                Clientes cli = new Clientes();

                // Entrada / Atrib. valores
                //cli.setId(Integer.parseInt( request.getParameter("ident")) );
                cli.setNome(request.getParameter("cliente") );
                cli.setEmail(request.getParameter("email") );
                cli.setRenda(Float.parseFloat(request.getParameter("renda")) );    
                cli.setCelular(request.getParameter("celular") );
                cli.setNasc( new SimpleDateFormat("yyyy-MM-dd").parse( request.getParameter("nascimento")) );

                // Saída
                //out.println(" <b>Identificador......:</b> " + cli.getId());
                out.println("<br> <b>Nome do Cliente:</b> " + cli.getNome());
                out.println("<br> <b>Email:</b> " + cli.getEmail());
                out.println("<br> <b>Renda:</b> " + cli.getRenda());
                out.println("<br> <b>Celular:</b> " + cli.getCelular());
                out.println("<br> <b>Nascimento:</b> " + new SimpleDateFormat("dd/MMMM/yyyy").format(cli.getNasc()));

                //Salvar
                ClientesDAO cliDAO = new ClientesDAO();
                if (cliDAO.cadastrar(cli)==true){
                    out.println("<br><br> Cliente Cadastrado com Sucesso!!!"); 
                }else{
                    out.println("<br><br> Cliente Não cadastrado!!!");
                }        
            %>
        </div>
    </body>
</html>
