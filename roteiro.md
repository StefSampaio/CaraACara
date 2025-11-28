🎬 Roteiro – Vídeo de Apresentação

Projeto Cara a Cara

Duração: 10–15 minutos

Disciplina: Arquitetura de Software

Tema: Implementação de 5 Design Patterns em Java

📋 0. Introdução (1–2 min)
O que falar:

“Olá, somos [seus nomes] e vamos apresentar nosso projeto de Arquitetura de Software.”
“Desenvolvemos um jogo Cara a Cara em Java aplicando 5 Design Patterns do GoF.”
“O objetivo é adivinhar o personagem secreto fazendo perguntas estratégicas.”
O que mostrar:

Tela inicial do jogo rodando.
Menu principal brevemente.
🗂️ 1. Visão Geral do Projeto (2 min)
Estrutura de pastas:
```javascript
src/main/java/com/caraacara/
├── controller/          (MVC - Controladores)
│   ├── MenuController.java
│   └── GameController.java
├── model/               (MVC - Modelos)
│   ├── GameCharacter.java
│   └── CharacterType.java
├── view/                (MVC - Views)
│   ├── MenuView.java
│   ├── GameView.java
│   └── ConsoleHelper.java
└── patterns/            (Design Patterns)
├── composite/
│   └── CharacterComposite.java
├── factory/
│   └── CharacterFactory.java
├── singleton/
│   └── GameManager.java
├── state/
│   ├── CharacterState.java
│   ├── ActiveState.java
│   └── RemovedState.java
└── strategy/
├── DifficultyStrategy.java
├── EasyStrategy.java
├── MediumStrategy.java
└── HardStrategy.java
```

Pontos a destacar:

✅ Organização seguindo padrão arquitetural MVC

✅ Implementação de 5 Design Patterns do GoF

✅ 16 personagens com características variadas

✅ Código limpo e bem estruturado

🏭 2. Design Pattern: Factory (2 min)
Código a mostrar – CharacterFactory.java:

```java
public class CharacterFactory {

    public static GameCharacter createCharacter(CharacterType type) {
        return new GameCharacter(
            type.name(),
            type.getSexo(),
            type.getCor(),
            type.getOlho(),
            type.getCabelo(),
            type.getDetalhe()
        );
    }

}
```

Código a mostrar – CharacterType.java (enum):

```java
public enum CharacterType {
ANA("Feminino", "Negro(a)", "Olhos castanhos", "Cabelos pretos", "Usa óculos"),
CARLOS("Masculino", "Negro(a)", "Olhos castanhos", "Cabelos castanhos", "Barba");
// ... outros personagens
}
```

Pontos importantes a explicar:

✅ Centraliza a criação de personagens em um único lugar

✅ Usa o enum CharacterType como “receita” dos personagens

✅ Facilita manutenção – se mudar a forma de criar, muda só aqui

✅ Padrão Criacional – foco em como criar objetos

✅ Evita código duplicado de new GameCharacter() espalhado pelo projeto

🔒 3. Design Pattern: Singleton (2 min)
Código a mostrar – GameManager.java:
```java
public class GameManager {

    private static volatile GameManager instance;
    private boolean gameRunning;
    private DifficultyStrategy difficultyStrategy;
    private int questionsAsked;

    private GameManager() {
        this.gameRunning = false;
        this.difficultyStrategy = new EasyStrategy();
        this.questionsAsked = 0;
    }

    public static GameManager getInstance() {
        if (instance == null) {
            synchronized (GameManager.class) {
                if (instance == null) {
                    instance = new GameManager();
                }
            }
        }
        return instance;
    }

    // ... outros métodos (getters/setters, lógica do jogo etc.)
}
```
Pontos importantes a explicar:

✅ Garante uma única instância do gerenciador do jogo

✅ Usa Double-Checked Locking para thread-safety

✅ Palavra-chave volatile garante visibilidade entre th reads

✅ Construtor privado impede criação externa

✅ Gerencia o estado global do jogo:

- Personagens ativos/removidos
- Personagem secreto
- Contador de perguntas
- Estratégia de dificuldade
-
🔄 4. Design Pattern: State (2 min)
Código a mostrar – CharacterState.java (interface):
```java
public interface CharacterState {
void activate(GameCharacter character);
void remove(GameCharacter character);
boolean isActive();
boolean isRemoved();
}
Código a mostrar – ActiveState.java:

public class ActiveState implements CharacterState {

    @Override
    public void remove(GameCharacter character) {
        System.out.println(character.getNome() + " foi removido do jogo.");
        character.setState(new RemovedState());
    }

    @Override
    public void activate(GameCharacter character) {
        // já está ativo, pode manter vazio ou logar
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public boolean isRemoved() {
        return false;
    }
}
```
Código a mostrar – RemovedState.java:
```java
public class RemovedState implements CharacterState {

    @Override
    public void activate(GameCharacter character) {
        character.setState(new ActiveState());
    }

    @Override
    public void remove(GameCharacter character) {
        // já está removido, pode manter vazio ou logar
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public boolean isRemoved() {
        return true;
    }
}
```

Diagrama de transição:
```markdown
[ActiveState] --remove()--> [RemovedState]
^                        |
|------activate()--------|
```

Pontos importantes a explicar:

✅ Personagens mudam de estado durante o jogo

✅ Estados possíveis:
- Ativo – pode ser escolhido como resposta
- Removido – foi eliminado pelas perguntas

✅ Padrão Comportamental – altera comportamento baseado no estado interno

✅ Evita vários if/else checando estado manualmente

✅ Cada estado sabe como transitar para outro estado

🌳 5. Design Pattern: Composite (2 min)
Código a mostrar – CharacterComposite.java:
```java
public class CharacterComposite {

    private final List<GameCharacter> personagens = new ArrayList<>();

    public void add(GameCharacter character) {
        personagens.add(character);
    }

    public List<GameCharacter> getTodosPersonagens() {
        return new ArrayList<>(personagens);
    }

    public List<GameCharacter> getPersonagensAtivos() {
        List<GameCharacter> ativos = new ArrayList<>();
        for (GameCharacter character : personagens) {
            if (character.isActive()) {
                ativos.add(character);
            }
        }
        return ativos;
    }

    public int getTotalAtivos {
        return (int) personagens.stream()
                .filter(GameCharacter::isActive)
                .count();
    }
}
```
Pontos importantes a explicar:

✅ Gerencia a coleção de personagens como um grupo

✅ Permite tratar múltiplos personagens de forma uniforme

✅ Facilita operações em lote:
- Listar todos os personagens
- Filtrar apenas ativos
- Contar quantos estão ativos

✅ Padrão Estrutural – organiza objetos em estrutura de árvore / coleção

✅ Encapsula a lista – controla como os personagens são acessados

🎯 6. Design Pattern: Strategy (2 min)

Código a mostrar – DifficultyStrategy.java (interface):
```java
public interface DifficultyStrategy {
int getMaxQuestions();
String getDifficultyName();
boolean hasUnlimitedQuestions();
}
Código a mostrar – EasyStrategy.java:

public class EasyStrategy implements DifficultyStrategy {

    @Override
    public int getMaxQuestions() {
        return -1; // -1 = infinito
    }

    @Override
    public String getDifficultyName() {
        return "Fácil";
    }

    @Override
    public boolean hasUnlimitedQuestions() {
        return true;
    }
}
```
Código a mostrar – MediumStrategy.java:
```java
public class MediumStrategy implements DifficultyStrategy {

    @Override
    public int getMaxQuestions() {
        return 10;
    }

@Override
public String getDifficultyName() {
return "Médio";
}

    @Override
    public boolean hasUnlimitedQuestions() {
        return false;
    }
}
Código a mostrar – HardStrategy.java:

public class HardStrategy implements DifficultyStrategy {

    @Override
    public int getMaxQuestions() {
        return 5;
    }

    @Override
    public String getDifficultyName() {
        return "Difícil";
    }

    @Override
    public boolean hasUnlimitedQuestions() {
        return false;
    }
}
```
Uso no GameManager:
```java
public void setDifficultyStrategy(DifficultyStrategy strategy) {
this.difficultyStrategy = strategy;
}

public boolean canAskMoreQuestions() {
if (difficultyStrategy.hasUnlimitedQuestions()) {
return true;
}
return questionsAsked < difficultyStrategy.getMaxQuestions();
}
```
Pontos importantes a explicar:

✅ Define uma família de algoritmos (dificuldades)

✅ Permite trocar estratégia em tempo de execução

✅ Cada dificuldade tem suas próprias regras:

- Fácil: perguntas ilimitadas
- Médio: 10 perguntas
- Difícil: 5 perguntas
-
✅ Padrão Comportamental – encapsula algoritmos intercambiáveis

✅ Facilita adicionar novas dificuldades sem modificar código existente

🏗️ 7. Arquitetura MVC (1–2 min)

- Separação de responsabilidades:
- MODEL (Modelo – Dados e Lógica de Negócio)
- GameCharacter.java – representa um personagem com suas características
- CharacterType.java – enum com dados de todos os personagens
- VIEW (Visão – Interface com Usuário)
- MenuView.java – exibe menu principal e instruções
- GameView.java – exibe interface do jogo (personagens, perguntas)
- ConsoleHelper.java – utilitários para console (limpar tela, ler input)
- CONTROLLER (Controlador – Lógica de Controle)
- MenuController.java – controla fluxo do menu (iniciar, instruções, sair)
- GameController.java – controla lógica do jogo (perguntas, eliminação, chute)

Diagrama de fluxo:

User Input → Controller → Model (processa) → Controller → View (exibe)
Pontos importantes a explicar:

✅ Separação clara de responsabilidades

✅ Model não conhece View – não tem System.out.println()

✅ View não tem lógica de negócio – só exibe informações

✅ Controller faz a ponte entre Model e View

✅ Facilita manutenção – mudar interface não afeta a lógica

🎮 8. Demonstração do Jogo (2–3 min)

Roteiro da demonstração:

- Menu Principal
- Mostrar opções: Iniciar Jogo, Como Jogar, Sair
- Entrar em “Como Jogar” rapidamente.
- Seleção de Dificuldade
- Escolher Difícil (5 perguntas) para demonstrar o Strategy.
- Início do Jogo
- Mostrar os 16 personagens disponíveis.
- Destacar o contador: “Perguntas restantes: 5”.
- Primeira Pergunta
- Exemplo: escolher “Masculino”.
- Mostrar resposta e personagens eliminados.
- Contador muda para: “Perguntas restantes: 4”.
- Segunda Pergunta
- Exemplo: escolher “Olhos castanhos”.
- Mostrar eliminação.
- Contador: “Perguntas restantes: 3”.
- Terceira Pergunta (opcional)
- Fazer mais uma pergunta se necessário.
- Mostrar que a lista de características diminui conforme elimina personagens.
- Chute Final
- Quando sobrar poucos personagens, dar o chute.
- Mostrar tela de vitória ou derrota.

Pontos a destacar durante a demo:

✅ “Reparem que características únicas não aparecem nas opções.”

✅ “O contador de perguntas está diminuindo – isso é o Strategy em ação.”

✅ “Os personagens estão mudando de estado – State Pattern.”

✅ “Quando as perguntas acabam, o jogo força o chute ao invés de perder automaticamente.”

✅ “A interface é limpa e intuitiva, com emojis e bordas.”

⭐ 9. Diferenciais do Projeto (1 min)

Funcionalidades inteligentes
- ✅ Lógica de características: só mostra opções que 2+ personagens têm
- ✅ Contador dinâmico: características diminuem conforme elimina personagens
- ✅ Chute obrigatório: quando acabam perguntas, força o jogador a tentar

Qualidade do código
- ✅ Código limpo e bem comentado
- ✅ Organização clara com pacotes separados
- ✅ Nomes descritivos de classes e métodos
- ✅ Sem código duplicado

Interface
- ✅ Visual agradável com emojis e bordas ASCII
- ✅ Feedback claro para o jogador
- ✅ Navegação intuitiva

Arquitetura
- ✅ Todos os 5 patterns trabalhando juntos de forma coesa
- ✅ Fácil de estender – adicionar novos personagens ou dificuldades
- ✅ Fácil de manter – responsabilidades bem definidas
-
🎓 10. Conclusão (1 min)

Resumo do que foi alcançado

“Conseguimos aplicar com sucesso os 5 Design Patterns solicitados.”

“O projeto demonstra boas práticas de arquitetura de software.”

“O código é extensível e fácil de manter.”

“Criamos um jogo totalmente funcional e jogável.”

Aprendizados

“Entendemos na prática quando e como aplicar cada pattern.”

“Vimos como os patterns trabalham juntos em um sistema real.”

“Aprendemos a importância da separação de responsabilidades.”

Encerramento

“Obrigado pela atenção!”

📝 Dicas para Gravação

Preparação
- ✅ Teste o jogo antes – garanta que está funcionando 100%
- ✅ Prepare o código – deixe as classes abertas nas abas certas
- ✅ Limpe o console antes de gravar
- ✅ Feche notificações do sistema

Durante a gravação
- ✅ Grave a tela com software tipo OBS Studio ou Loom
- ✅ Use zoom nas partes importantes do código
- ✅ Fale devagar e com clareza
- ✅ Faça pausas entre seções para dar tempo de processar
- ✅ Aponte com o cursor o que está explicando

Edição
- ✅ Corte pausas longas e erros
- ✅ Adicione legendas com o nome de cada pattern
- ✅ Coloque um timer no canto para controlar a duração
- ✅ Música de fundo suave (opcional)

📌 Pontos-Chave a Não Esquecer

Para cada Design Pattern, mencionar:

- ✅ Qual é – nome e categoria (Criacional / Estrutural / Comportamental)
- ✅ Por que usamos – problema que ele resolve
- ✅ Como implementamos – mostrar o código principal
- ✅ Benefícios – o que ganhamos com isso

Frases de apoio para explicação:

“Este pattern resolve o problema de …”

“Sem ele, teríamos que …”

“Isso facilita porque …”

“Reparem como isso deixa o código mais limpo …”