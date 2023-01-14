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

class ComponentB(
    private val componentA: ComponentA
) {
    fun describeMe() = "ComponentB -> ${componentA.describeMe()}"
}

@Component
class ProgrammaticBootstrapper: ApplicationContextAware {
    override fun setApplicationContext(applicationContext: ApplicationContext) {
        val genericContext = (applicationContext as GenericApplicationContext)
        genericContext.registerBean(
            ComponentB::class.java, noopBeanCustomizer
        )
        genericContext.registerBean(
            ComponentA::class.java, noopBeanCustomizer
        )
    }
}

private val noopBeanCustomizer = object : BeanDefinitionCustomizer {
    override fun customize(bd: BeanDefinition) {
    }
}