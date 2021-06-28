# FormBuilder Portlet

Esse é um sistema de Formulários contendo upload e armazenamento de arquivos, e uma demonstração de formulário de fale conosco que implementa envio de email de notificação para responsáveis da empresa, regras de notificação baseada em tipos de formulários.

Essa solução combina ES6 + PortletMVC + ServiceBuilder + DLAppLocalService + MailService

## FrontEnd
1. Todo o HTML é gerado dinamicamente pelo motor JS.
2. Esse motor JS foi desenvolvido em ES6 puro.
3. Todas as mensagens e labels do formulário são cadastradas nos arquivos Languages e são traduzidas para uma função JS
4. O transpile do ES6 é feito pelo script npm `transpile`
5. Existem diferentes tipos de formulários que são exibidos de acordo com a seleção de um campo específico `Assunto`
6. Antes de qualquer build ou deploy:
   1. `npm install` (somente na primeira instalação)
   2. ` npm run transpile-fale-conosco`


## BackEnd
1. O conteúdo do formulário é persistido com um serviceBuilder `forms-service`.
2. Todo o conteúdo é armazenado em JSON dentro de uma só coluna da tabela no banco de dados.
3. Formulários podem contem upload de arquivos, os arquivos são armazenados no Liferay utilizado a API `DLAppLocalService`
4. O folderId do diretório a serem salvos os arquivos deve ser definido nas configurações do portlet `attachmentsFolderId`
5. Para cada tipo de formulário um email de notificação é disparado, os email são enviados utilizando a API `MailService`
6. Existem regras para destintários de email baseado em informações dos formulários. Essas regras são configuradas pelo administrador via JSON nas configurações do portlet.

## Melhorias
1. O mapeamento das mensagens localizadas para função JS ainda é manual, pode-se automatizar