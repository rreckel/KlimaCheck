import org.squeryl.Schema
import org.squeryl.PrimitiveTypeMode._

/**
 * Created with IntelliJ IDEA.
 * User: rre
 * Date: 20/09/12
 * Time: 21:56
 */
object DB extends Schema {
  val records = table[Record]
  on(records)(r => declare(
    r.id is(autoIncremented)
  ))

//  printDdl
//  drop
//  create
}
