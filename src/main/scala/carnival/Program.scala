package carnival

import orbit.client.OrbitClientConfig
import scala.concurrent.blocking

object Program {
  def main(args: Array[String]): Unit = {
    blocking {
      val config = new OrbitClientConfig()
      val orbitClient = new orbit.client.OrbitClient(config)
      orbitClient.start()

      Thread.sleep(10000)

      val greeter = orbitClient
        .getActorFactory
        .createProxy[Greeter](classOf[Greeter], "Bug the system")

      val response = greeter.sayHello("Welcome to Orbit")
      println(response.join())

      orbitClient.stop(null)
    }
  }
}
