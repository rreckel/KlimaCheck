import java.sql.Timestamp
import java.util.Date
import org.squeryl.KeyedEntity

/**
 * Created with IntelliJ IDEA.
 * User: rre
 * Date: 20/09/12
 * Time: 21:57
 */
case class Record(id: Long, date: Timestamp, temperature: Int, humidity: Int) extends KeyedEntity[Long] {

}
