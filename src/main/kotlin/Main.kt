package rip.shuka

import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.default
import kotlinx.cli.required
import rip.shuka.enum.Type
import rip.shuka.service.ConnorNagyService

fun main(args: Array<String>) {
    val connorNagyService = ConnorNagyService()
    val parser = ArgParser("connor-nagy-decoder")

    val message by parser.option(ArgType.String, fullName = "message", description = "Message").required()
    val type by parser.option(ArgType.String, fullName = "type", description = "ENCODE or DECODE").required()
    val encodeMinified by parser.option(ArgType.Boolean, fullName = "encodeMinified", description = "encodeMinified").default(false)

    parser.parse(args)

    when (Type.valueOf(type)) {
        Type.ENCODE -> connorNagyService.encode(message, encodeMinified)
        Type.DECODE -> connorNagyService.decode(message)
    }
}