# Projecto-Jornadas
# PLATAFORMA DE COMPARTILHAMENTO DE ARQUIVOS EM REDE LAN

Bom!! O sistema conciste em criar um abiente unico e integro para estudantes e docentes fa universidade 
pedagogica de Maputo UPM. No entanto vamos precisar de muita investigacao e dedicação para tornarmos o sistema
a rodar na melhor perfeição!!

A ideia é criar uma interface web para que os usuários possam:

	- Fazer login com usuário e senha Samba.
	- Visualizar as pastas disponíveis.
	- Fazer upload/download de arquivos (com permissões definidas no Samba).
	- Ter uma experiência moderna, estilo “Google Drive escolar”.
	
Vamos precisar de conhecimentos em:
	- Samba --> nesse caso o nosso servidor de arquivos na LAN
	- Servidor Web(Apache ou Nginx e PHP ou Node.js) --> Para permitir a comunicacao entre o servidor Samba
	- HTML, CSS e JavaScript --> para criar a interface facilitada para o usuario acessar no navegador
	- E o menos importante dominar alguns comandos de atribuicao de privilegios do Linux 😜️.
	
COMO DEVE FUNCIONAR +/-

	- Usuário acessa por exemplo: http://192.168.1.10/ → vê a página de login (HTML, CSS).
	- Faz login → JavaScript envia os dados para o backend (PHP ou Node.js).
	- O backend autentica com o usuário Samba (via PAM ou script).
	- Se autenticado, mostra os arquivos/pastas (puxados de /srv/samba/...).
	- Usuário pode fazer upload ou download, respeitando as permissões Samba, like se for docente pode fazer upload.
	
													Niggas sugestoes, o projecto eh nosso!! Let's get start!
