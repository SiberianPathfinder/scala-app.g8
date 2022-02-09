package $package$

import cats.effect.{IO, IOApp, Sync}
import org.typelevel.log4cats.{Logger, SelfAwareStructuredLogger}
import org.typelevel.log4cats.slf4j.Slf4jLogger

object Main extends IOApp.Simple {

  implicit def unsafeLogger[F[_]: Sync]: SelfAwareStructuredLogger[F] = Slf4jLogger.getLogger

  override def run: IO[Unit] =
    Logger[IO].info("Hello World")

}
