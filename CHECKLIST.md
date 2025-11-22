# 📋 Checklist de Desenvolvimento - Cara a Cara

## ✅ Status Geral
- [x] Estrutura do projeto Maven criada
- [x] Configuração do IntelliJ IDEA
- [x] Singleton (GameManager) implementado
- [x] Menu inicial (MenuScreen) implementado
- [ ] Model (Character) implementado
- [ ] Factory (CharacterFactory) implementado
- [ ] State Pattern implementado
- [ ] Compose (CharacterCompose) implementado
- [ ] Tela do jogo (GameScreen) implementada
- [ ] Lógica completa do jogo

---

## 🎯 Singleton - GameManager

### ✅ Concluído
- [x] Implementação do padrão Singleton (Lazy Initialization)
- [x] Método `getInstance()` para obter instância única
- [x] Construtor privado para impedir instanciação externa
- [x] Flag `gameRunning` para controlar estado do jogo
- [x] Método `startGame()` - inicia jogo e verifica se já existe um em execução
- [x] Método `endGame()` - finaliza o jogo atual
- [x] Método `isGameRunning()` - verifica se há jogo em execução
- [x] Método `reset()` - reseta o GameManager (para testes)



---

## 🎮 MenuScreen

### ✅ Concluído
- [x] Menu interativo no terminal
- [x] Opção 1: Iniciar Novo Jogo
- [x] Opção 2: Como Jogar (instruções)
- [x] Opção 3: Sair
- [x] Método `displayMenu()` - exibe e processa opções
- [x] Método `clearScreen()` - limpa tela do terminal
- [x] Método `waitForEnter()` - aguarda Enter do usuário
- [x] Integração com GameManager para iniciar jogos



---

## 👤 Model - Character

### 📝 A Fazer
- [ ] Definir atributos do personagem:
  - [ ] `String name` - nome do personagem
  - [ ] `String type` - tipo (ROBOT ou HUMAN)
  - [ ] `Map<String, Boolean> characteristics` - características do personagem
  - [ ] `CharacterState state` - estado atual (ativo/removido)
- [ ] Implementar construtor completo
- [ ] Implementar getters e setters:
  - [ ] `getName()`
  - [ ] `getType()`
  - [ ] `getCharacteristics()`
  - [ ] `getState()`
  - [ ] `setState(CharacterState state)`
  - [ ] `hasCharacteristic(String characteristic)` - verifica se tem característica
- [ ] Implementar método `toString()` para exibição
- [ ] Implementar método `equals()` e `hashCode()` (se necessário)

### 📋 Exemplo de Características
- [ ] Definir lista de características possíveis:
  - [ ] Tem cabelo?
  - [ ] Usa óculos?
  - [ ] Tem barba?
  - [ ] É homem/mulher?
  - [ ] Tem bigode?
  - [ ] Usa chapéu?
  - [ ] Tem cabelo colorido?
  - [ ] (Adicionar mais conforme necessário)

---

## 🏭 Factory - CharacterFactory

### 📝 A Fazer
- [ ] Criar método `createAllCharacters()` - cria todos os personagens do jogo
- [ ] Criar método `createCharacter(String name, String type, Map<String, Boolean> characteristics)`
- [ ] Definir lista de personagens (robôs e seres humanos):
  - [ ] Criar pelo menos 8-12 personagens diferentes
  - [ ] Garantir diversidade de características
  - [ ] Misturar robôs e seres humanos
- [ ] Implementar método `getRandomCharacter()` - retorna personagem aleatório
- [ ] Implementar método `getAllCharacters()` - retorna lista de todos os personagens
- [ ] Garantir que cada personagem tenha características únicas

### 📋 Personagens Sugeridos
- [ ] Robô 1 (com características específicas)
- [ ] Robô 2 (com características específicas)
- [ ] Robô 3 (com características específicas)
- [ ] Ser Humano 1 (com características específicas)
- [ ] Ser Humano 2 (com características específicas)
- [ ] Ser Humano 3 (com características específicas)
- [ ] (Adicionar mais personagens)

---

## 🔄 State Pattern

### 📝 CharacterState (Interface)
- [ ] Definir métodos da interface:
  - [ ] `boolean isActive()` - verifica se está ativo
  - [ ] `boolean isRemoved()` - verifica se está removido
  - [ ] `String getStatus()` - retorna status do personagem
  - [ ] `void handle(Character character)` - processa ação no estado

### 📝 ActiveState
- [ ] Implementar interface `CharacterState`
- [ ] `isActive()` retorna `true`
- [ ] `isRemoved()` retorna `false`
- [ ] `getStatus()` retorna "ATIVO"
- [ ] Implementar método `handle()` para transição de estado

### 📝 RemovedState
- [ ] Implementar interface `CharacterState`
- [ ] `isActive()` retorna `false`
- [ ] `isRemoved()` retorna `true`
- [ ] `getStatus()` retorna "REMOVIDO"
- [ ] Implementar método `handle()` para manter estado removido

---

## 🎨 Compose - CharacterCompose

### 📝 A Fazer
- [ ] Implementar gerenciamento de coleção de personagens
- [ ] Método `addCharacter(Character character)` - adiciona personagem
- [ ] Método `removeCharacter(Character character)` - remove personagem
- [ ] Método `getActiveCharacters()` - retorna lista de personagens ativos
- [ ] Método `getRemovedCharacters()` - retorna lista de personagens removidos
- [ ] Método `filterByCharacteristic(String characteristic, boolean value)` - filtra personagens por característica
- [ ] Método `removeByCharacteristic(String characteristic, boolean value)` - remove personagens que não têm a característica
- [ ] Método `getAllCharacters()` - retorna todos os personagens
- [ ] Método `getCharacterCount()` - retorna quantidade de personagens
- [ ] Método `reset()` - reseta todos os personagens para estado ativo

---

## 🎯 GameScreen

### 📝 A Fazer
- [ ] Método `start()` - inicia a tela do jogo
- [ ] Integração com GameManager para verificar se jogo está rodando
- [ ] Seleção aleatória do personagem secreto:
  - [ ] Usar CharacterFactory para obter personagem aleatório
  - [ ] Armazenar personagem secreto
- [ ] Exibição de características disponíveis:
  - [ ] Listar todas as características possíveis
  - [ ] Mostrar de forma organizada e numerada
- [ ] Processamento de escolha do jogador:
  - [ ] Ler entrada do usuário
  - [ ] Validar escolha
  - [ ] Filtrar personagens baseado na característica escolhida
- [ ] Exibição de personagens removidos:
  - [ ] Mostrar lista de personagens que foram eliminados
  - [ ] Mostrar personagens ainda ativos
- [ ] Sistema de chute:
  - [ ] Permitir que jogador dê chute do personagem
  - [ ] Validar se acertou ou errou
  - [ ] Se acertou: mostrar vitória e finalizar
  - [ ] Se errou: continuar o jogo
- [ ] Método `clearScreen()` - limpar tela
- [ ] Método `waitForEnter()` - aguardar Enter
- [ ] Método `displayGameStatus()` - mostrar status atual do jogo
- [ ] Método `displayCharacters()` - mostrar personagens ativos/removidos
- [ ] Método `processGuess(String characterName)` - processa chute do jogador
- [ ] Método `checkWinCondition()` - verifica condições de vitória
- [ ] Integração com CharacterCompose para gerenciar estados

### 📋 Fluxo do Jogo
1. [ ] Sistema escolhe personagem aleatório
2. [ ] Exibe características disponíveis
3. [ ] Jogador escolhe uma característica
4. [ ] Sistema filtra e remove personagens que não têm a característica
5. [ ] Exibe personagens removidos e ativos
6. [ ] Repete passos 2-5 até jogador dar chute
7. [ ] Processa chute e verifica vitória/derrota
8. [ ] Retorna ao menu ou reinicia

---

## 🔗 Integrações e Fluxo

### 📝 A Fazer
- [ ] Conectar MenuScreen → GameScreen:
  - [ ] Quando jogador escolhe "Iniciar Novo Jogo", chamar GameScreen
  - [ ] Após fim do jogo, retornar ao menu
- [ ] Conectar GameScreen → CharacterFactory:
  - [ ] Obter lista de personagens
  - [ ] Selecionar personagem aleatório
- [ ] Conectar GameScreen → CharacterCompose:
  - [ ] Gerenciar estados dos personagens
  - [ ] Filtrar e remover personagens
- [ ] Conectar Character → CharacterState:
  - [ ] Personagem deve ter estado (ActiveState ou RemovedState)
  - [ ] Transições de estado devem funcionar
- [ ] Conectar CharacterCompose → CharacterState:
  - [ ] Usar estados para gerenciar personagens

---

## 🧪 Testes e Validações

### 📝 A Fazer
- [ ] Testar Singleton:
  - [ ] Verificar que apenas uma instância é criada
  - [ ] Verificar que não pode iniciar dois jogos simultâneos
- [ ] Testar Factory:
  - [ ] Verificar que todos os personagens são criados
  - [ ] Verificar que personagem aleatório é válido
- [ ] Testar State Pattern:
  - [ ] Verificar transições de estado
  - [ ] Verificar que personagem removido não aparece como ativo
- [ ] Testar Compose:
  - [ ] Verificar filtragem de personagens
  - [ ] Verificar remoção de personagens
- [ ] Testar GameScreen:
  - [ ] Testar fluxo completo do jogo
  - [ ] Testar vitória
  - [ ] Testar derrota
  - [ ] Testar múltiplas rodadas

---

## 📚 Documentação

### 📝 A Fazer
- [ ] Adicionar JavaDoc em todas as classes
- [ ] Documentar métodos públicos
- [ ] Atualizar README.md com instruções completas
- [ ] Adicionar exemplos de uso
- [ ] Documentar padrões de design utilizados

---

## 🎨 Melhorias de UX/UI

### 📝 A Fazer (Opcional)
- [ ] Melhorar formatação visual do terminal
- [ ] Adicionar cores (se possível)
- [ ] Melhorar mensagens de feedback
- [ ] Adicionar animações/transições (se possível)
- [ ] Melhorar layout das listas de personagens

---

## 📊 Progresso Geral

**Concluído:** 2/8 componentes principais
- ✅ Singleton (100%)
- ✅ MenuScreen (100%)
- ⏳ Character (0%)
- ⏳ CharacterFactory (0%)
- ⏳ CharacterState (0%)
- ⏳ ActiveState (0%)
- ⏳ RemovedState (0%)
- ⏳ CharacterCompose (0%)
- ⏳ GameScreen (0%)

**Próximos Passos Sugeridos:**
1. Implementar Model (Character)
2. Implementar State Pattern (CharacterState, ActiveState, RemovedState)
3. Implementar Factory (CharacterFactory)
4. Implementar Compose (CharacterCompose)
5. Implementar GameScreen
6. Integrar tudo e testar

---

## 📝 Notas

- O projeto usa Java 11
- Padrões de design: Singleton, Factory, State, Compose
- Interface: Terminal/Console
- Estrutura: Maven

