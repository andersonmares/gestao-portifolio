<form:form method="post" modelAttribute="projeto" class="form">
    <div class="form-group">
        <label for="nome">Nome</label>
        <form:input path="nome" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="status">Status</label>
        <form:select path="status" class="form-control">
            <form:options items="${statusList}"/>
        </form:select>
    </div>
    <button type="submit" class="btn btn-primary">Salvar</button>
</form:form>