package com.example.demo.pkg

import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.beans

class ComponentCBeaned {
    fun describeMe() = "ComponentCBeaned"
}

class ComponentDBeaned(
    // private val componentA: ComponentA - not working.
    private val someRepository: SomeRepository,
) {
    fun describeMe() = "ComponentDBeaned -> ${someRepository.describeMe()}"
}

val beans = beans {
    bean<ComponentCBeaned>()
    bean<ComponentDBeaned>()
}

// see application.properties
class BeansInitializer : ApplicationContextInitializer<GenericApplicationContext> {
    override fun initialize(context: GenericApplicationContext) = beans.initialize(context)
}
