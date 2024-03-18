package rip.shuka.service

class PrintService {
    fun print(result: String, job: String) {
        val cliTagRed = "\u001B[33m[CN-DECODER CLI]\u001B[0m"
        println("~ $cliTagRed > $job ~")
        println(result)
        println("~".repeat(job.length + cliTagRed.length-2))
    }
}