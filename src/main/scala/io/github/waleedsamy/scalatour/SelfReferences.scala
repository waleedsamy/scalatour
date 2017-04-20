package io.github.waleedsamy.scalatour

import io.github.waleedsamy.scalatour.repository.UserRepositoryComponent
import io.github.waleedsamy.scalatour.service.UserServiceComponent

object SelfReferences extends App {

  object ComponentRegistry extends UserServiceComponent with UserRepositoryComponent {
    val userService = new UserServiceImpl
    val userRepository = new UserRepositoryImpl
  }

  ComponentRegistry.userService.create("John", "jj")

}
