import java.io.{BufferedOutputStream, PrintStream, ByteArrayOutputStream}
import org.junit.runner.RunWith
import org.junit.{After, Before, Test}
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class AppTest extends FlatSpec with Matchers {

  private val byteArrayOutputStream: ByteArrayOutputStream = new ByteArrayOutputStream()
  private val out: PrintStream = System.out

  "App.main" should "print Hello World" in {
    System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)))
    App.main(Array())
    System.out.flush()
    byteArrayOutputStream.toString should be ("Hello World!\n")
    System.setOut(out)
  }

  "App.ret" should "return same value" in {
    App.ret(2) should be (2)
  }

}
