package xyz.colinholzman.makina

import picocli.CommandLine.Option
import picocli.CommandLine.Parameters

class CliOptions {
    @Option(names = ["-o", "--output"], description = ["generated files output directory"])
    var outputDir: String? = null

    @Option(names = ["-m", "--machine-data"], description = ["data type of machine context"])
    var machineDataType: String = "void *"

    @Option(names = ["-e", "--event-data"], description = ["data type of event context"])
    var eventDataType: String = "void *"

    @Option(names = ["-i", "--include"], description = ["files to include in generated code"])
    var includes: List<String> = emptyList()

    @Parameters(description = ["one ore more input files"])
    var files: List<String> = emptyList()

}