package carnival

import java.util.concurrent.CompletableFuture
import orbit.client.actor.AbstractActor

class GreeterActor extends AbstractActor with Greeter {
  override def sayHello(greeting: String): CompletableFuture[String] = {
    println(s"Here: ${greeting}")
    CompletableFuture.completedFuture(
      s"You said: '${greeting}'," +
        s"I say: 'Hello from ${context.getReference.getKey} " +
        s"at node ${context.getClient.getNodeId.getKey}!'"
    )
  }
}
