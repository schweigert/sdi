 ---- Instru��es para cria��o e utiliza��o de RMI em Java ----

1o.) Criar interface derivada de Remote
2o.) Compilar esta interface (javac <arquivo interface>)
3o.) Criar uma classe que implemente essa interface. Essa ser� a classe do objeto remoto.
4o.) Compilar esta classe (javac <arquivo contendo a classe>)
5o.) Gerar proxies (stubs) e skeletons (rmic <nome da classe do objeto remoto>)
6o.) Criar classes para a aplica��o servidora
7o.) Compilar classe servidora (juntamente com a classe Skeleton)
8o.) Criar classe para a aplica��o cliente
9o.) Compilar classe cliente (juntamente com a classe proxy)


 ----- Utiliza��o das aplica��es cliente e servidora ----

1o.) Execute o servi�o de nomes do RMI Java (rmiregistry)
2o.) Execute a aplica��o servidora (java <nome da classe servidora>)
3o.) Execute a aplica��o cliente (java <nome da classe cliente>)
   134  15:05   javac  Hello.java
   135  15:06   javac  HelloServidora.java
   136  15:06   rmic HelloServidora
   137  15:06   javac AplicacaoServidora.java
   138  15:06   javac AplicacaoCliente.java
   139  15:06   rmiregistry &
   140  15:07   java AplicacaoServidora
java AplicacaoCliente
