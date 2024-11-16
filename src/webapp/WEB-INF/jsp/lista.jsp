<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Projetos</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Projetos</h1>
    <a href="/projetos/novo" class="btn btn-primary">Novo Projeto</a>
    <table class="table">
        <thead>
        <tr>
            <th>Nome</th>
            <th>Gerente</th>
            <th>Status</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${projetos}" var="projeto">
            <tr>
                <td>${projeto.nome}</td>
                <td>${projeto.gerente}</td>
                <td>${projeto.status}</td>
                <td>
                    <a href="/projetos/${projeto.id}" class="btn btn-info">Editar</a>
                    <form action="/projetos/${projeto.id}" method="post" style="display:inline">
                        <input type="hidden" name="_method" value="delete"/>
                        <button type="submit" class="btn btn-danger">Excluir</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>