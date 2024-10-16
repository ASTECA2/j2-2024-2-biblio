<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Livros</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <h1>Editoras</h1>
            <a href="/livros/insert" class="btn btn-primary">Novo livro</a>
            <table class="table">
                <tr>
                    <th>id</th>
                    <th>genero</th>
                    <th>editora</th>
                </tr>
                <c:forEach var="l" items="${livros}">
                    <tr>
                        <td>${g.id}</td>
                        <td>${g.titulo}</td>
                        <td>${g.genero}</td>
                        <td>${g.editora}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>