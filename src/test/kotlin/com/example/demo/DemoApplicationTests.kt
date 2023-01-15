package com.example.demo

import com.example.demo.pkg.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DemoApplicationTests(
	@Autowired private val someRepository: SomeRepository,
	@Autowired private val componentA: ComponentA,
	@Autowired private val componentB: ComponentB,
	@Autowired private val componentCBeaned: ComponentCBeaned,
	@Autowired private val componentDBeaned: ComponentDBeaned,
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

	@Test
	fun `app should contain component B`() {
		assertThat(componentB.describeMe()).isEqualTo("ComponentB -> ComponentA -> someRepository")
	}

	@Test
	fun `app should contain component C which is beaned`() {
		assertThat(componentCBeaned.describeMe()).isEqualTo("ComponentCBeaned")
	}

	@Test
	fun `app should contain component D which is beaned`() {
		assertThat(componentDBeaned.describeMe()).isEqualTo("ComponentDBeaned -> someRepository")
	}

}
