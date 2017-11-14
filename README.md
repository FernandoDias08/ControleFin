#############################
## FinControl - 1.0 (Beta) ##
#############################

README

Como servidor de aplicação, será necessário utilizar o servidor Tomcat8 (porta 8080). 
Para execução, importar no Spring Tools Suite e executar como 'Spring Boot App', 
pois o mesmo já possui o Tomcat embarcado ou então subir o servidor separado e 
realizar o deploy pelo Maven.

É necessário um servidor de banco Mysql instalado, onde o banco de dados, as tabelas e a
massa de dados necessária serão criadas automaticamente na execução do aplicativo, pelos arquivos SQL. 
O usuário e senha de Banco constam no arquivo 'Application.properties'. São eles:
Usuário: root
senha: 123456