import com.typesafe.sbt.pgp.PgpKeys._
import sbt.Keys._
import sbt._

object PublicationDetails {


  val preventPublication =
    Seq(
      publishArtifact := false,
      publish :=(),
      publishLocal :=(),
      publishLocalSigned :=(), // doesn't work
      publishSigned :=(), // doesn't work
      packagedArtifacts := Map.empty) // doesn't work - https://github.com/sbt/sbt-pgp/issues/42

  def publicationSettings =
    Seq(
      publishTo := {
        val nexus = "https://oss.sonatype.org/"
        if (isSnapshot.value)
          Some("snapshots" at nexus + "content/repositories/snapshots")
        else
          Some("releases" at nexus + "service/local/staging/deploy/maven2")
      },
      pomExtra :=
        <scm>
          <connection>scm:git:github.com/chandu0101/sri</connection>
          <developerConnection>scm:git:git@github.com:chandu0101/sri.git</developerConnection>
          <url>github.com:chandu0101/sri.git</url>
        </scm>
          <developers>
            <developer>
              <id>chandu0101</id>
              <name>Chandra Sekhar Kode</name>
            </developer>
          </developers>,
      scalacOptions += {
        val a = (baseDirectory in LocalRootProject).value.toURI.toString
        val g = "https://raw.githubusercontent.com/chandu0101/sri/" + sys.process.Process("git rev-parse HEAD").lines_!.head
        s"-P:scalajs:mapSourceURI:$a->$g/"
      }
    )


  //  def sourceMapsToGithub =
  //    Seq(
  //      scalacOptions ++= (if (isSnapshot.value) Seq.empty else Seq({
  //        val a = p.base.toURI.toString.replaceFirst("[^/]+/?$", "")
  //        val g = "https://raw.githubusercontent.com/chandu0101/sri"
  //        s"-P:scalajs:mapSourceURI:$a->$g/v${version.value}/"
  //      }))
  //    )


}