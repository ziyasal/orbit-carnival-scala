package carnival

import orbit.client.OrbitClientConfig
import scala.concurrent.blocking

object App {
  def main(args: Array[String]): Unit = {
    val config = new OrbitClientConfig()
    val orbitClient = new orbit.client.OrbitClient(config)
    orbitClient.start()

    Thread.sleep(10000)

    val server = new Server(orbitClient)
    server.spin()

    Runtime.getRuntime().addShutdownHook(new Thread() {
      override def run(): Unit = blocking {
        println("Gracefully shutting down")
        server.stop()
        orbitClient.stop(null)
        println("Shutdown complete")
      }
    })
  }
}
