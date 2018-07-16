<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8" />
<title>Dinheiros</title>
</head>
<body>
	<form id="login" action="/usuario" method="GET">
		<label>Usuário: <input name="user" type="text" required>
		</label><br /> <label>senha: <input name="senha" type="password"
			required>
		</label><br /> <input type="submit" name="action" value="Login" />
		<a href="/usuario/novo">Cadastre-se</a>
	</form>
</body>
</html>