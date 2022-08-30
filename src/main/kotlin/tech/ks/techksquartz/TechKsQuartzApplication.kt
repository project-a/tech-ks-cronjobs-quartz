package tech.ks.techksquartz

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class TechKsQuartzApplication

fun main(args: Array<String>) {
    runApplication<TechKsQuartzApplication>(*args)
}