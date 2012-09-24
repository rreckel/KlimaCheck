import java.sql.Connection
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
    SessionFactory.concreteFactory = Some(()=>
        Session.create(e.getServletContext.getAttribute("connection").asInstanceOf[Connection],new H2Adapter))
  }

  def contextDestroyed(e: ServletContextEvent) {}
}
