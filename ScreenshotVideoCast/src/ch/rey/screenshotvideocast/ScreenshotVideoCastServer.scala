package ch.rey.screenshotvideocast

import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl
import org.http4s.implicits._
import org.http4s.server.blaze._
import zio._
import zio.interop.catz._
import zio.interop.catz.implicits._

object ioz extends Http4sDsl[Task]


object ScreenshotVideoCastServer extends App {
  import ioz._

  val helloService = HttpRoutes.of[Task] {
    case GET -> Root => Ok("hello!")
  }.orNotFound

  def run(args: List[String]) =
    server.fold(_ => 1, _ => 0)

  val server = ZIO.runtime[ZEnv]
    .flatMap {
      implicit rts =>
        BlazeServerBuilder[Task]
          .bindHttp(8080, "localhost")
          .withHttpApp(helloService)
          .serve
          .compile
          .drain
    }

}
