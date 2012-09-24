import java.util.Date
import org.squeryl.PrimitiveTypeMode._

/**
 * Created with IntelliJ IDEA.
 * User: rre
 * Date: 20/09/12
 * Time: 22:04
 */
class HelloVM {
  inTransaction {
    DB.printDdl
    DB.records.insert(Record(0l, new Date, 1234, 54321))
    println(from(DB.records)(r => select(r)).toList)
  }
}
