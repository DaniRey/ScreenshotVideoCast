// build.sc
import mill._
import mill.scalalib._

object ScreenshotVideoCast extends ScalaModule {
  def scalaVersion = "2.13.1"
  def ivyDeps = Agg(
    ivy"org.http4s::http4s-dsl:0.21.0-M5",
    ivy"org.http4s::http4s-blaze-server:0.21.0-M5",
    ivy"org.http4s::http4s-blaze-client:0.21.0-M5",
    ivy"dev.zio::zio:1.0.0-RC16",
    ivy"dev.zio::zio-test:1.0.0-RC16",
    ivy"dev.zio::zio-interop-cats:2.0.0.0-RC7"
  )
}