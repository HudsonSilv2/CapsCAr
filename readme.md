# CapsCAr - Sistema de Aluguel de Veículos

## 📚 Descrição
Sistema desktop em JavaFX para gerenciamento de aluguéis de veículos,
baseado em partes de projetos já criados, contem codigos de outros sistemas,
porém está funcional.

## ⚙️ Tecnologias
- Java
- JavaFX
- PostgreSQL
- JDBC
- Odio
- Café

## 🗃️ Estrutura do Projeto
- `dao/`: Acesso ao banco de dados/ configure separadamente
- `model/`: Entidades
- `ui/`: Interface gráfica com JavaFX
- `util/`: Utilitários como ConnectionFactory

## ▶️ Execução
1. Configure o banco PostgreSQL (veja abaixo).
2. Rode a classe `AluguelApplication`.
3. OBS: Veja se o seu usuario e senhas são compativeis com o do codigo.

## 📊 JavaFX
Dentro de `AluguelApplication`, está toda a estrutura da tela da aplicação,
aqui tbm tem a verificação de dados, o `hello-view.fxml` está vazio,
pois por algum motivo entrou em conflito com o Main.


## 🛢️ Banco de Dados
Crie um banco chamado `aluguel_carros`.
Tabela exemplo:

```sql
CREATE TABLE filial (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(100),
  endereco TEXT,
  telefone VARCHAR(15),
  horarioabertura TIME,
  horariofechamento TIME
);
