package io.github.waleedsamy.scalatour.service

import io.github.waleedsamy.scalatour.repository.{ User, UserRepositoryComponent }

trait UserServiceComponent {

  self: UserRepositoryComponent =>

  val userService: UserService

  trait UserService {
    def authenticate(username: String, password: String): User

    def create(username: String, password: String)

    def delete(user: User)
  }

  class UserServiceImpl extends UserService {

    def authenticate(username: String, password: String): User =
      userRepository.authenticate(new User(username, password))

    def create(username: String, password: String) =
      userRepository.create(new User(username, password))

    def delete(user: User) =
      userRepository.delete(user)
  }

}