package carnival

import com.twitter.finagle.http.{Request, Response}
import com.twitter.finagle.{Http, ListeningServer, Service, http}
import com.twitter.util.{Await, Future}
import orbit.client.OrbitClient

class Server(orbitClient: OrbitClient) {
  private val greeterService: Service[Request, Response] = (req: http.Request) => {
      val resp = http.Response(req.version, http.Status.Ok)

      val greeter = orbitClient
        .getActorFactory
        .createProxy[Greeter](classOf[Greeter], "Bug the system")

      val response = greeter.sayHello("Welcome to Orbit")
      val content = response.join()
      println(content)
      resp.setContentString(content)
      Future.value(resp)
    }

  private val server: ListeningServer = Http.serve(":8080", greeterService)

  def spin(): Unit = {
    Await.ready(server)
  }

  def stop(): Unit = {
    Await.ready(server.close())
  }
}
