package com.example.demo

import com.example.demo.pkg.ComponentA
import com.example.demo.pkg.SomeRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DemoApplicationTests(
	@Autowired private val someRepository: SomeRepository,
	@Autowired private val componentA: ComponentA,
) {

	@Test
	fun contextLoads() {
	}

	@Test
	fun `context should contain some repository`() {
		assertThat(someRepository.describeMe()).isEqualTo("someRepository")
	}

	@Test
	fun `app should contain component A`() {
		assertThat(componentA.describeMe()).isEqualTo("ComponentA -> someRepository")
	}

}
