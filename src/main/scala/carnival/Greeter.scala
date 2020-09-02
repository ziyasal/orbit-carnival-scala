package carnival

import java.util.concurrent.CompletableFuture
import orbit.client.actor.ActorWithStringKey

trait Greeter extends ActorWithStringKey {
  def sayHello(greeting: String): CompletableFuture[String]
}
