<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8" />
<title>Dinheiros</title>
</head>
<body>
	<form id="login" action="/usuario" method="POST" enctype="application/json">
		<label>Usuário: <input name="user" type="text" required
			maxlength="40" pattern="[0-9a-zA-Z_-.]*">
		</label><br /> 
		<label>Senha: <input name="senha" type="password"
			maxlength="40" required>
		</label><br /> 
		<label>E-mail: <input name="email"
			type="email" maxlength="80" required>
		</label><br />
		<label>Nome: <input name="nome"
			type="text" maxlength="80" required>
		</label><br />
		<label>Língua:<select name="lingua"><option value="pt-BR">Português-Brasil</option></select></label>
		 <input type="submit" name="action" value="Salvar" />
	</form>
</body>
</html>