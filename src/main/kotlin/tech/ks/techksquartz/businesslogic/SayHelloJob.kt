package tech.ks.techksquartz.businesslogic

import org.quartz.DisallowConcurrentExecution
import org.quartz.Job
import org.quartz.JobExecutionContext
import org.springframework.stereotype.Component
import java.time.LocalDateTime.now

@Component
@DisallowConcurrentExecution
class SayHelloJob : Job {
    override fun execute(context: JobExecutionContext) {
        println("${now()} Hello this is ${context.trigger.description}")
    }
}