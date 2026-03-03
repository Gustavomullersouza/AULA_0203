fun main() {

    print("Digite a operação (ex: 5 + 3): ")
    val input = readLine()!!

    val partes = input.split(" ")

    val n1 = partes[0].toInt()
    val op = partes[1]
    val n2 = partes[2].toInt()

    // Verifica se os números estão entre 0 e 9
    if (n1 !in 0..9 || n2 !in 0..9) {
        println("Digite apenas números de 0 a 9.")
        return
    }

    if (op == "+") {
        println("Resultado: ${n1 + n2}")
    } else if (op == "-") {
        println("Resultado: ${n1 - n2}")
    } else if (op == "*") {
        println("Resultado: ${n1 * n2}")
    } else if (op == "/") {
        println("Resultado: ${n1 / n2}")
    } else {
        println("Operação inválida.")
    }
}