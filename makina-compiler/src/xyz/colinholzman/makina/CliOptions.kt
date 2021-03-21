package xyz.colinholzman.makina

import picocli.CommandLine.Option
import picocli.CommandLine.Parameters

class CliOptions {
    @Option(names = ["-o", "--output"], description = ["generated files output directory"])
    var outputDir: String? = null

    @Parameters(description = ["one ore more input files"])
    lateinit var files: List<String>

}