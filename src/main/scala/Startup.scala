import java.io.File
import org.apache.catalina.startup.Tomcat
import org.zkoss.zk.ui.Sessions

/**
 * Created with IntelliJ IDEA.
 * User: rre
 * Date: 20/09/12
 * Time: 20:36
 */
object Startup {
  def main(args: Array[String]) {
    val tomcat = new Tomcat
    tomcat.setPort(8080)
    tomcat.addWebapp("/", new File("src/main/webapp").getAbsolutePath)
    tomcat.start()
    tomcat.getServer.await()
  }
}
