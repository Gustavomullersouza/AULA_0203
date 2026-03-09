import java.util.Scanner // Importa a classe Scanner para ler dados do teclado

fun main() {
    // Cria um objeto Scanner para ler entrada do usuário no console
    val scanner = Scanner(System.`in`)

    // Loop infinito para permitir várias operações seguidas
    while (true) {

        // Solicita que o usuário digite uma expressão matemática
        print("Digite a expressão: ")

        // Lê a linha digitada pelo usuário
        val input = scanner.nextLine()

        // Verifica se a expressão tem menos de 9 caracteres
        // Caso tenha, pede outra expressão
        if (input.length < 9) {
            println("Use pelo menos 9 caracteres.\n")
            continue // volta para o início do loop
        }

        try {
            // Remove espaços da expressão e chama a função calc para calcular
            println("Resultado: ${calc(input.replace(" ", ""))}\n")
        }
        catch (e: Exception) {
            // Caso ocorra erro durante o cálculo, mostra a mensagem
            println("Expressão inválida: ${e.message}\n")
        }
    }
}

fun calc(expr: String): Double {

    // Copia a expressão para uma variável que será manipulada
    var s = expr

    // Enquanto existir parênteses na expressão
    while (s.contains("(")) {

        // Encontra o último '(' (resolve de dentro para fora)
        val i = s.lastIndexOf('(')

        // Encontra o ')' correspondente após ele
        val j = s.indexOf(')', i)

        // Se não encontrar fechamento, gera erro
        if (j == -1) throw Exception("Parênteses incorretos")

        // Pega a parte dentro dos parênteses, calcula recursivamente
        // e substitui na expressão original
        s = s.substring(0,i) + calc(s.substring(i+1,j)) + s.substring(j+1)
    }

    // Lista que armazenará os números da expressão
    val nums = mutableListOf<Double>()

    // Lista que armazenará os operadores (+ - * /)
    val ops = mutableListOf<Char>()

    var i = 0

    // Percorre a expressão caractere por caractere
    while (i < s.length) {

        // Se for número ou ponto decimal
        if (s[i].isDigit() || s[i]=='.') {

            // Cria um construtor de string para montar o número
            val sb = StringBuilder()

            // Continua lendo enquanto for número ou ponto
            while (i<s.length && (s[i].isDigit() || s[i]=='.')) {
                sb.append(s[i])
                i++
            }

            // Converte o número para Double e adiciona na lista
            nums.add(sb.toString().toDouble())

            continue
        }

        // Se for operador válido
        else if ("+-*/".contains(s[i])) {
            ops.add(s[i])
        }

        // Caso contrário, caractere inválido
        else {
            throw Exception("Caractere inválido: ${s[i]}")
        }

        i++
    }

    // Índice usado para percorrer operadores
    var index = 0

    // Primeiro resolve multiplicação e divisão
    while (index < ops.size) {

        if (ops[index]=='*'||ops[index]=='/') {

            // Calcula o resultado da operação
            val res =
                if (ops[index]=='*')
                    nums[index]*nums[index+1]
                else
                    nums[index]/nums[index+1]

            // Substitui os dois números pelo resultado
            nums[index]=res

            // Remove o segundo número usado
            nums.removeAt(index+1)

            // Remove o operador já processado
            ops.removeAt(index)
        }
        else {
            index++
        }
    }

    // Agora resolve soma e subtração
    var res = nums[0]

    for (j in ops.indices) {

        res =
            if (ops[j]=='+')
                res + nums[j+1]
            else
                res - nums[j+1]
    }

    // Retorna o resultado final
    return res
}