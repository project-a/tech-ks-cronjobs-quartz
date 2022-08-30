package tech.ks.techksquartz.quartz.cronjobs.configurations

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "cron-jobs.say-hello")
class SayHelloConfigurations(
    val aLot: BaseInterval,
    val sometimes: BaseInterval
)

class BaseInterval(
    val startDelayInSeconds: Long,
    val periodInSeconds: Int
)