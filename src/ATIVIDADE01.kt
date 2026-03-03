fun main() {
    // 5 + 2

    println("Digite sua operação:")
    val op = readln().trim()

    if (op.contains("+")){
        val soma = op.split("+")
        println(soma[0].toInt() + soma[1].toInt())
    }else if (op.contains("-")){
        val soma = op.split("-")
        println(soma[0].toInt() - soma[1].toInt())
    }else if (op.contains("*")){
        val soma = op.split("*")
        println(soma[0].toInt() * soma[1].toInt())
    }else if (op.contains("/")){
        val soma = op.split("/")
        println(soma[0].toInt() / soma[1].toInt())
    }
}