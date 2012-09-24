import actors._
import com.tinkerforge.{BrickletHumidity, BrickletTemperature, IPConnection}
import javax.servlet.{ServletContextEvent, ServletContextListener}
import Actor._

/**
 * Created with IntelliJ IDEA.
 * User: rre
 * Date: 20/09/12
 * Time: 22:14
 */
class CollectorInitializer extends ServletContextListener {
  val ipc = new IPConnection("192.168.2.12", 4223)
  val temperatureBricklet = new BrickletTemperature("aKw")
  val humidityBricklet = new BrickletHumidity("aYu")
  ipc.addDevice(temperatureBricklet)
  ipc.addDevice(humidityBricklet)

  val a = actor {
    loop {
      react {
        case x => {
          println("Temp: " + (temperatureBricklet.getTemperature/100f))
          println("Humidity: " + (humidityBricklet.getHumidity/10f))
        }
      }
    }
  }

  val t = new TimerActor(1000, a, "Go for it")

  def contextInitialized(e: ServletContextEvent) {
    a.start()
    t.start()
  }

  def contextDestroyed(e: ServletContextEvent) {
  }
}

class TimerActor(val timeout: Long,val who: Actor,val reply: Any) extends Actor {
  def act {
    loop {
      reactWithin(timeout) {
        case TIMEOUT => who ! reply
      }
    }
  }
}
