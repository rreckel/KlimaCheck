import java.util.Date
import org.squeryl.KeyedEntity

/**
 * Created with IntelliJ IDEA.
 * User: rre
 * Date: 20/09/12
 * Time: 21:57
 * To change this template use File | Settings | File Templates.
 */
case class Record(id: Long, date: Date, temperature: Int, humidity:Int) extends KeyedEntity[Long] {

}
