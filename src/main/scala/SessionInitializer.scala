import java.sql.{DriverManager, Connection}
import javax.servlet.{ServletContextEvent, ServletContextListener}
import org.squeryl.adapters.H2Adapter
import org.squeryl.{SessionFactory, Session}
import org.zkoss.zk.ui.Sessions

/**
 * Created with IntelliJ IDEA.
 * User: rre
 * Date: 20/09/12
 * Time: 21:51
 */
class SessionInitializer extends ServletContextListener {

  def contextInitialized(e: ServletContextEvent) {
    println("Initializing squeryl sessions")
    org.h2.Driver.load
    SessionFactory.concreteFactory = Some(()=> {
//      val session = Session.create(e.getServletContext.getAttribute("connection").asInstanceOf[Connection],new H2Adapter)
      val conn = DriverManager.getConnection("jdbc:h2:~/klima", "sa", "sa");
      val session = Session.create(conn, new H2Adapter)
//      session.setLogger(println(_))
      session
    })
  }

  def contextDestroyed(e: ServletContextEvent) {}
}
