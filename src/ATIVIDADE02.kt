import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    while (true) {
        print("Digite a expressão: ")
        val input = scanner.nextLine()
        if (input.length < 9) { println("Use pelo menos 9 caracteres.\n"); continue }
        try { println("Resultado: ${calc(input.replace(" ", ""))}\n") }
        catch (e: Exception) { println("Expressão inválida: ${e.message}\n") }
    }
}

fun calc(expr: String): Double {
    var s = expr
    while (s.contains("(")) {
        val i = s.lastIndexOf('(')
        val j = s.indexOf(')', i)
        if (j == -1) throw Exception("Parênteses incorretos")
        s = s.substring(0,i) + calc(s.substring(i+1,j)) + s.substring(j+1)
    }

    val nums = mutableListOf<Double>()
    val ops = mutableListOf<Char>()
    var i = 0
    while (i < s.length) {
        if (s[i].isDigit() || s[i]=='.') {
            val sb = StringBuilder()
            while (i<s.length && (s[i].isDigit() || s[i]=='.')) { sb.append(s[i]); i++ }
            nums.add(sb.toString().toDouble()); continue
        } else if ("+-*/".contains(s[i])) ops.add(s[i]) else throw Exception("Caractere inválido: ${s[i]}")
        i++
    }

    var index = 0
    while (index < ops.size) {
        if (ops[index]=='*'||ops[index]=='/') {
            val res = if (ops[index]=='*') nums[index]*nums[index+1] else nums[index]/nums[index+1]
            nums[index]=res; nums.removeAt(index+1); ops.removeAt(index)
        } else index++
    }

    var res = nums[0]
    for (j in ops.indices) res = if (ops[j]=='+') res+nums[j+1] else res-nums[j+1]
    return res
}