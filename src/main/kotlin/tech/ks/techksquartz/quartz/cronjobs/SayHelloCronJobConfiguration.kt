package tech.ks.techksquartz.quartz.cronjobs

import org.quartz.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import tech.ks.techksquartz.businesslogic.SayHelloJob
import tech.ks.techksquartz.quartz.cronjobs.configurations.SayHelloConfigurations
import java.time.Instant.now
import java.time.temporal.ChronoUnit
import java.util.*

@Configuration
class SayHelloCronJobConfiguration(
    val sayHelloConfigurations: SayHelloConfigurations
) {


    @Bean("say-hello-job-detail")
    fun sayHelloJobDetailBean(): JobDetail =
        JobBuilder.newJob()
            .ofType(SayHelloJob::class.java)
            .storeDurably()
            .withIdentity("say-hello")
            .withDescription("Jobs that says hello followed by the identity of the service")
            .build()

    @Bean("say-hello-often-trigger")
    fun sayHelloOftenTrigger(): Trigger =
        baseHelloTrigger(
            sayHelloConfigurations.aLot.periodInSeconds,
            sayHelloConfigurations.aLot.startDelayInSeconds
        )

    @Bean("say-hello-less-often-trigger")
    fun sayHelloLessOftenTrigger(): Trigger =
        baseHelloTrigger(
            sayHelloConfigurations.sometimes.periodInSeconds,
            sayHelloConfigurations.sometimes.startDelayInSeconds
        )

    private fun baseHelloTrigger(periodInSeconds: Int, startDelayedInSeconds: Long) = TriggerBuilder.newTrigger()
        .forJob(sayHelloJobDetailBean())
        // they belong to the say "group", but have different identities
        .withIdentity("say-hello-trigger-$periodInSeconds", "with-period")
        .withDescription("Execute the Hello job every $periodInSeconds seconds")
        .startAt(
            Date.from(now().plus(startDelayedInSeconds, ChronoUnit.SECONDS))
        ).withSchedule(
            SimpleScheduleBuilder.repeatSecondlyForever(periodInSeconds)
        )
        .build()
}