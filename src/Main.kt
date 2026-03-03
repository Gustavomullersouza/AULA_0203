fun main() {


        print("Digite o primeiro número: ")
        val n1 = readLine()!!.toDouble()

        print("Digite o segundo número: ")
        val n2 = readLine()!!.toDouble()

        print("Digite a operação (+, -, *, /): ")
        val op = readLine()

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
