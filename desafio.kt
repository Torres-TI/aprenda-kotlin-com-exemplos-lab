

data class ConteudoEducacional(
	val nome : String,
    val url: String
)

data class Aluno(
    val nome: String, 
    val email : String)

data class Formacao(
	val nome : String,
    val nivel: String,
    val conteudosEducacionais: MutableList<ConteudoEducacional> = mutableListOf(),
    val alunosMatriculado: MutableList<Aluno> = mutableListOf()
)

class DIO(val formacoes: MutableList<Formacao> = mutableListOf(), val alunos: MutableList<Aluno> = mutableListOf() ) {
   
    
    //Criar formacao e adicionar na lista de formações
    fun criarFormacao(nome : String, nivel : String){
        val formacao = Formacao(nome, nivel) 
        formacoes.add(formacao)
    }
   	//Adicionar conteúdo em formação
   	fun adicionarConteudoEmFormacao(formacao: Formacao, conteudo: ConteudoEducacional){
        formacao.conteudosEducacionais.add(conteudo)
    }
    //Matricular aluno em formação
    fun matricularAlunoEmFormacao(formacao: Formacao, aluno: Aluno){
        formacao.alunosMatriculado.add(aluno)
    }
}



fun main() {
    // Criando uma instância da classe DIO
    val dio = DIO()
    //Criando Formações)
    dio.criarFormacao("Seus Primeiros Passos em Kotlin", "Básico")
    dio.criarFormacao("Kotlin + Spring", "Intermediário")
    //Criando conteúdo e adicionando em formação
    val conteudo1 = ConteudoEducacional("Introduction", "https://kotlinlang.org")
    val conteudo2 = ConteudoEducacional("Fundamentos Spring", "https://spring.io/")
    dio.adicionarConteudoEmFormacao(dio.formacoes[0], conteudo1)
    dio.adicionarConteudoEmFormacao(dio.formacoes[1], conteudo2)
    //Criar alunos
    val aluno1 = Aluno("Bruno Torres", "developertorress@gmail.com")
    val aluno2 = Aluno("Bruno Araujo", "developer.torress@gmail.com")
    val aluno3 = Aluno("Diego Silva", "diego.silvaficticio@gmail.com")
    //Adicionar alunos em formação
    dio.matricularAlunoEmFormacao(dio.formacoes[0], aluno1)
    dio.matricularAlunoEmFormacao(dio.formacoes[0], aluno2)
    dio.matricularAlunoEmFormacao(dio.formacoes[1], aluno3)
    //Exibir Detalhes
     println("Formações:")
    // Para cada formação quero que exiba nome, nível e os detalhes dos conteúdos educacionais
    dio.formacoes.forEach { formacao ->
        println("Nome: ${formacao.nome}, Nível: ${formacao.nivel}")
        println("Conteúdos Educacionais:")
        formacao.conteudosEducacionais.forEach { conteudo ->
            println(" - Nome: ${conteudo.nome}, URL: ${conteudo.url}")
        }
     // Exiba os alunos matriculados na formacao, nome e email
        println("Alunos Matriculados:")
        formacao.alunosMatriculado.forEach { aluno ->
            println(" - Nome: ${aluno.nome}, Email: ${aluno.email}")
        }
    }
    
}