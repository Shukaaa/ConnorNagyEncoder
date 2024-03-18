package rip.shuka.service

import rip.shuka.extension.binaryAsciiToText
import rip.shuka.extension.toBinary

class ConnorNagyService {
    private val printService = PrintService()

    fun encode(message: String, minified: Boolean) {
        var binaryAscii = message.toBinary()
        binaryAscii = replaceDuplicatesWithPoints(binaryAscii)

        binaryAscii = binaryAscii.replace("0", "Connor")
        binaryAscii = binaryAscii.replace("1", "Nagy")

        if (minified) {
            binaryAscii = binaryAscii.replace("Connor", "C")
            binaryAscii = binaryAscii.replace("Nagy", "N")
            binaryAscii = replacePointsWithNumberOfPoints(binaryAscii)
        }

        val jobText = if (minified) "Encoded message (minified)" else "Encoded message"

        printService.print(binaryAscii, jobText)
    }

    fun decode(message: String) {
        var encodedMsg = message
        encodedMsg = encodedMsg.replace("Connor", "C")
        encodedMsg = encodedMsg.replace("Nagy", "N")

        println(encodedMsg)
        encodedMsg = addBackPointsFromCountNumbers(encodedMsg)
        encodedMsg = addBackDuplicates(encodedMsg)

        encodedMsg = encodedMsg.replace("C", "0")
        encodedMsg = encodedMsg.replace("N", "1")

        encodedMsg = encodedMsg.binaryAsciiToText()

        printService.print(encodedMsg, "Decoded message")
    }

    private fun replaceDuplicatesWithPoints(binaryAscii: String): String {
        var newString = binaryAscii
        var lastChar = newString[0]
        for (i in 1 until newString.length) {
            if (newString[i] == lastChar) {
                newString = newString.substring(0, i) + "." + newString.substring(i + 1)
            }

            if (newString[i] != '.') {
                lastChar = newString[i]
            }
        }

        return newString
    }

    private fun replacePointsWithNumberOfPoints(binaryAscii: String): String {
        var result = StringBuilder() // Use StringBuilder for efficient string manipulation
        var count = 0
        var i = 0

        while (i < binaryAscii.length) {
            if (binaryAscii[i] == '.') {
                count++ // Increment count if the current character is a dot
                i++ // Move to the next character
            } else {
                if (count > 0) {
                    // Append the count of dots to the result string and reset count
                    result.append(count.toString())
                    count = 0
                }
                // Append the current character to the result string and move to the next character
                result.append(binaryAscii[i])
                i++
            }
        }

        // Handle trailing dots, if any
        if (count > 0) {
            result.append(count.toString())
        }

        return result.toString()
    }

    private fun addBackPointsFromCountNumbers(binaryAscii: String): String {
        var newString = binaryAscii
        var result = StringBuilder() // Use StringBuilder for efficient string manipulation
        var i = 0

        while (i < newString.length) {
            if (newString[i].isDigit()) {
                // Append the next character to the result string count times
                val count = newString[i].toString().toInt()
                for (j in 0 until count) {
                    result.append('.')
                }
                i++
            } else {
                // Append the current character to the result string and move to the next character
                result.append(newString[i])
                i++
            }
        }

        return result.toString()
    }
    private fun addBackDuplicates(binaryAscii: String): String {
        var newString = binaryAscii
        var lastChar = newString[0]
        for (i in 1 until newString.length) {
            if (newString[i] == '.') {
                newString = newString.substring(0, i) + lastChar + newString.substring(i + 1)
            }

            if (newString[i] != '.') {
                lastChar = newString[i]
            }
        }

        return newString
    }
}