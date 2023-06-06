# Desafio I
## O CÓDIGO DESENVOLVIDO
O código desenvolvido é de um jogo de adivinhação do resultado de um lançamento de um dado. Ao iniciar, o usuário vê o Menu Incial, composto por:

1. Novo Jogo
2. Como Jogar
3. Alterar Modo (modo zen selecionado por padrão)
4. Alterar Dado (D6 selecionado por padrão)
5. Sair

### 1 - NOVO JOGO

Um novo jogo é iniciado, um dado com o número de lados selecionado é lançado. O usuário deve tentar acertar qual foi o resultado (número gerado aleatoriamente).

O jogo se comporta de formas diferentes a depender do modo selecionado.

**Modo Zen:** Novos dados são lançados indefinidamente, até que o usuário decida parar digitando -1. O programa vai calcular a maior sequencia de acertos ("Acertou" e "Passou perto" são considerados acertos, veja mais em "Pontuação")

**Modo Desafio** O jogo se encerra quando o usuário erra 3 vezes. O usuário também tem a opção de parar a qualquer momento digitando -1. Ao final do jogo, o programa vai comparar a pontuação com o recorde salvo do modo de jogo selecionado.

**Modo Morte Súbita** O jogo se encerra quando o usuário erra pela primeira vez. O usuário também tem a opção de parar a qualquer momento digitando -1. Ao final do jogo, o programa vai comparar a pontuação com o recorde salvo do modo de jogo selecionado.

**FIM DE JOGO**

É exibida uma tabela com os números sorteados, os palpites do jogador, o resultado (Acertou / Passou perto / Errou) e o número de pontos adquirido nessa jogada.

Abaixo da tabela, é exibido o total de pontos.

Abaixo do total de pontos, são exibidos os recordes de cada modo desde que o programa foi inciado.

No modo Zen, o recorde é definido pela maior sequência de acertos ("Passou perto" conta como acerto).

Nos modos Desafio e Morte Súbita, os recordes são definidos pela maior pontuação.

O usuário retorna ao Menu Inicial e tem a opção de jogar novamente.

### 2 - COMO JOGAR

Eu vou lançar um dado e você tentará acertar o lado que ele vai cair!

#### PONTUAÇÃO

+10 caso acerte o resultado do lançamento do dado - Situação: ACERTOU

+5 caso seu palpite seja um a mais ou um a menos que o resultado - Situação: PASSOU PERTO

Nenhum ponto para palpites com 2 ou mais de diferença do resultado - Situação: ERROU

#### MODOS

Modo **Zen**: Pode jogar quantas vezes quiser! Os pontos serão contados, mas não há penalidade por errar, você escolhe quando parar!

Modo **Desafio**: O jogo termina quando você errar 3 vezes. PASSAR PERTO não conta como erro.

Modo **Morte Súbita**: O jogo termina assim que você errar. PASSAR PERTO não conta como erro.

#### DADOS

Você pode escolher qual dado iremos usar! O número ao lado do D indica o número de lados que um dado possui!

Lembre-se: quanto maior o número de lados, maior a dificuldade!

Um dado de 6 lados pode cair números entre 1 e 6

Um dado de 8 lados pode cair números entre 1 e 8

Um dado de 12 lados pode cair números entre 1 e 12

Um dado de 20 lados pode cair números entre 1 e 20

Um dado de 30 lados pode cair números entre 1 e 30

Um dado de 100 lados pode cair números entre 1 e 100

### 3 - ALTERAR MODO
Permite que o usuário alterne entre os modos Zen, Desafio ou Morte Súbita

### 4 - ALTERAR DADO
Permite que o usuário alterne entre dados de 6, 8, 12, 20, 30 ou 100 lados





## O DESAFIO:
Você deve gerar um número aleatório e comparar com a resposta vinda do usuário. Caso seja o mesmo número o usuário ganha 10 pontos, caso seja número diferente o programa deve comparar para saber se o número está 1 acima ou 1 abaixo do número sorteado, caso esteja o usuário ganha 5 pontos, caso não esteja o usuário apenas perde. No fim deverá ser exibida a pontuação do usuário. Tudo via console. 

**Entrega Mínima:** O sistema sorteia o número e realiza todas as comparação, no final ele exibe a pontuação correta.

**Entrega Média:** O sistema permite jogar mais de uma vez e soma todas as pontuações.

**Entrega Máxima:** O sistema permite adicionar nível de dificuldade de alguma forma e exibe, além da pontuação, os números que o usuário errou e acertou.
