package com.example.demo.pkg

import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.beans.factory.config.BeanDefinitionCustomizer
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.support.GenericApplicationContext
import org.springframework.stereotype.Component

class ComponentA(
    private val someRepository: SomeRepository,
) {
    fun describeMe() = "ComponentA -> ${someRepository.describeMe()}"
}

@Component
class ProgrammaticBootstrapper: ApplicationContextAware {
    override fun setApplicationContext(applicationContext: ApplicationContext) {
        (applicationContext as GenericApplicationContext).registerBean(
            ComponentA::class.java, noopBeanCustomizer
        )
    }
}

private val noopBeanCustomizer = object : BeanDefinitionCustomizer {
    override fun customize(bd: BeanDefinition) {
    }
}