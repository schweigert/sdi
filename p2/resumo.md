# Sistemas de Arquivos Distribuídos

  - permitir acesso igual ao sistemas de arquivo local de forma remota
  - problemas de sistemas de arquivos de armazenamento remotos:
    - balanceamento de carga
    - confiabilidade
    - disponibilidade
    - segurança
  - requisitos:
    - transparência
    - atualização concorrente de Arquivos
    - replicação de arquivos
    - heterogeneidade de hardware e sistema operacional
    - tolerância a falhas
    - consistência (Atraso nas propagações feitas)
    - segurança
    - eficiência
  - exemplos:
    - NFS (Network File System)
    - AFS (Andrew File System)
  - arquitetura de serviço de arquivos:
    - Serviço de arquivos plano: preocupa com a implementação sobre o conteúdo do arquivo
    - Serviço de diretório: O serviço de diretório fornece um mapeamento entre nosmes textuais de arquivos.
    - Módulo cliente: É executado nos computadores clientes para interagir com os demais sub sistemas.
  - NFS:
    - Usa RPC
    - O protocolo NFS define um conjunto de funções
    - o módulo servidor fica no núcleo do sistema de cada computador
    - cria um sistema de arquivo virtual

# Sistema de Arquivos Distribuídos na Nuvem
  - Camadas da Nuvem
    - Camada de Aplicação
    - API
    - Gerenciamento de serviços | Armazenamento Distribuído

# Replicação
  - Motivação
    - Melhoria do Desempenho
    - Maior disponibilidade
    - Tolerância a falhas
  - Modelo de Sistema:
    - Requisição
    - Coordenação
    - Execução
    - Acordo
    - Resposta
    - Replicação passiva:
      - Tem escravos (Cópias idênticas)
    - Replicação ativa:
      - envia em broadcast para todos.
      - o primeiro que responder, responde aos demais

# Relógios
  - Problemática: limitação da capacidade de cadastrar o tempo dos eventos em diferentes nós.
  - Relógio de Hardware:
    - Hi(t) = valor lido pelo sistema operacional
  - Relógio de Software:
    - Ci(t) = a*Hi(t) + B, onde o retorno é um long int correspondente a nanosegundos
    - Skew: Diferença do tempo de dois relógios
    - Drift: É a diferença no valor lido de um relógio e o valor de tempo fornecido por um relógio de referência perfeita
  - Conceito de tempo
    - Baseado no dia solar médio (ANTES PACAS)
    - rotação da terra (1954)
    - Relógio atômio (1967)
  - Sincronização Externa: Limite externo de um grupo
  - Sincronização Interna: Limite interno do meu grupo
  - N relógios com limite ótimo: u(1-1/n)
  - Algoritmo de Christian
    - probabilistico
    - a transmissão de dados deve ser pequeno comparado a precisão conhecida
    - servidor global que será responsável pelo tempo
    - tira o tempo com uma média do tempo de ida e volta
    - tempo = Hi(t) + timeout(t)/2
  - Algoritmo de Berkeley
    - Define um dispositivo como mestre
    - o mestre é responsável por obter o tempo dos relógios e calcular as médias desses relógios
    - Repassa ajuste: envia a diferença da média com o restante dos clientes
  - NTP: Serviço de controle de tempo na rede
    - Tempo universal coordenado: UTC
    - Clientes sincronizam seus relógios com uma fonte UTC.
    - NTP utiliza UDP
    - Baseado na topologia hierárquica (servidores redundantes)
    - GPS: utiliza NTP
    - Relógio Atômico: utiliza NTP
    - Associações:
      - Permanente
      - Priozisáveis
      - Transitórias

# Tempo lógico e estado global

  - Sequencia de eventos pode ser ordenado, de ponde de vista de um único processo, pelo seu tempo do relógio lógico
  - Sincronização baseada em relógio lógico não tem relação com tempo físico
  - Lamport inventou um mecanismo de ordenação acontece antes (->) que permite modelar numericamente uma sequência de eventos pelo relógio lógico
  - Timestamp: carimbo de tempo
  - Estado global serve para coleta de lixo distribuída, detecção de dead-lock, detecção de término distribuído, depuração distribuída
  - Estado global consistente é o estado onde podemos garantir consistência do sistema
  - Corte consistente refere-se a um ponto onde podemos instanciar novamente o sistema de forma consistente
  - Snapshot distribuído:
    - Grava somente estados globais consistentes sem congelar o sistema;
    - permite avaliar os predicados estáveis;
    - Um corte é dito consistente se você separar estados de todos os membros de um sistema distribuído, onde esses sistemas estejam consistentes
  - Exemplo inicial - Alg. Chandy-Lamport
    - Mensagem com marcação é recebida, armazenada em disco e depois processada
    - Utiliza a marcação como um estado consistente para reiniciar em caso de falha
  - Hipóteses do algoritmo de snapshot distribuído:
    - Não há falha dos canais de comunicação nem dos processos;
    - Comunicação confiável, ou seja, toda mensagem enviada é recebia uma só uma e intacta;
    - Canais são unidirecionais com entrega FIFO.

# Coordenação e Acordos

- Exclusão mútua distribuída
  - Região crítica | Mutex
  - Resolve através de comunicação de passagens de mensagens
- Protocolo para executar uma região crítica:
  - Enter
  - Resouce Accesses
  - Exit
- Requisitos básicos:
  - Segurança: Um processo por vez
  - subsistência: as requisições para entrar e sair da seção crítica tem sucesso
  - Ordenação: Considera o time do protocolo, e não a ordem dos pacotes
  - Algoritmo de exclusão mútua:
    - Servidor Central
      - Servidor centralizado que gerenciará os tokens
      - Pede Token
      - Consede Token
      - Devolve Token
    - Baseado em Anel
      - Vai passando um token para outra pessoa na roda
      - Se eu não desejo o token, passo para frente
      - Se eu desejo, eu aguardo receber o token
    - Multicast e relógios lógicos
      - Pede autorização e aguarda a resposta de todos
      - Lamport
      - Estado:
        - RELEASED
        - WANTED
        - HELD
    - Votação de Maekawa
      - Divite os processos em subconjuntos, desde cada subconjunto tenha 1 e somente 1 que seja par desses outros conjuntos
      - Cada processo só vota uma vez
      - Para ser imparcial cada conjunto de processos tem um conjunto votante de mesmo tamanho
      - um processo convoca uma eleição e interessados nessa sessão crítica participam juntos
      - Um só sai vitorioso, executando a sessão critica
    - Eleição baseada em Anel
      - Todos os processos são marcados como não-participantes;
      - Um processo qualquer inicia o processo de votação alterando seu processo como participante
      - esse processo gera uma mensagem de eleição enviado para seu vizinho do Anel
      - Quando um processo recebe a mensagem eleição: Compara o ID da mensagem com o seu ID
        - Se for menor, ele encaminha para o seu vizinho, se o seu ID for maior, ele altera o seu estado de participante e substitui
        - o ID da mensagem e repassa
      - Algoritmo de eleição Valentão (Bully)
        - O algoritmo de anel não é tolerante a falhas
        - O Bully considera que o sistema é síncrono
      - Problema dos generais bizantinos (TCC)
        - Generais cercam uma cidade
        - Comunicação através de menssageiros
        - existem generais que são traidores
        - generais só vencem se todos atacarem ao mesmo tempo
        - Se 2/3 + 1 dos generais processos forem leais(não falharem) existe uma solução para o problema.
        - N <= 3f + 1, ,f : número de falhas, n é o numero de nós

# Peer-to-Peer

  - Garantia que cada usuário contribua para o sistema
  - Todos os nós tem as mesmas capacidades e responsabilidades
  - não existe nenhum agente centralizado
  - um certo grau de anonimato
  - depende de algoritmos eficientes para distribuição do dados e acesso aos dados;
  - bons algoritmos equilibram a carga de trabalho e garantem a disponibilidade com o mínimo de sobrecarga
    - O surgimento do p2p está fortemente ligado aos usuários comuns com banda larga
  - Sobreposição de roteamento é o algoritmo distribuido que assume a responsabilidade de encontrar nós e objetos. Ele implementa um mecanismo de roteamento independente da camada da rede.
    - Roteamento de requisições para objetos
    - Inserção e remoção de objetos
    - Adição e remoção de nós

  - Sistema de Arquivos Ivy
    - Ele simula um servidor NFS. Ivy amazena o estados dos arquivos como logs
    - os registros dos logs são mantidos no serviço de armazenamento por uma função DHash (Distributed Hash Table)

# Estudo de casos Google

  - Buffers de protocolo estabelecem o formato de serialização de invocação remota.
  - Publicar e assinar suporta disseminação efficiente de eventos.
  - Chuby é o sistema de coordenação
    - Características:
      - Serviço de Armazenamento e Coordenação para infraestrutura
      - Possúi exclusão mútua distribuída para exclusão mútua
      - Sistemas de arquivos confiáveis para pequenos arquivos
      - Dispôem serviço de suporte para eleição de réplicas
      - Utilizado como DNS do Google
  - Bigtable é o sistema de dados distribuídos
    - Linhas: String
    - Colunas: String
    - Etiquetas: Int64
  - MapReduce
  - Sawzall é uma linguagem de para executar computação distribuída.
    - Linguagem de Query.
  - PubSubHubBub
    - Publisher
    - Hub
    - Topic
    - Hub
    - Subscriber
