package io.github.waleedsamy.scalatour.repository

case class User(name: String, password: String)

trait UserRepositoryComponent {
  val userRepository: UserRepository

  trait UserRepository {
    def authenticate(user: User): User

    def create(user: User)

    def delete(user: User)
  }

  class UserRepositoryImpl extends UserRepository {
    def authenticate(user: User): User = {
      println("authenticating user: " + user)
      user
    }

    def create(user: User) = println("creating user: " + user)

    def delete(user: User) = println("deleting user: " + user)
  }

}