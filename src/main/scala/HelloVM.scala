import java.text.SimpleDateFormat
import java.util.Date
import org.squeryl.PrimitiveTypeMode._
import org.zkoss.zul.SimpleCategoryModel
import reflect.BeanProperty

/**
 * Created with IntelliJ IDEA.
 * User: rre
 * Date: 20/09/12
 * Time: 22:04
 */
class HelloVM {

  @BeanProperty var model = new MySimpleCategoryModel(inTransaction{from(DB.records)(r => select(r)).toList})

}

class MySimpleCategoryModel(values: List[Record]) extends SimpleCategoryModel {
  val df = new SimpleDateFormat("dd/MM hh:mm:ss")
  values.foreach(r => setValue("Temperature", df.format(r.date), r.temperature))
  values.foreach(r => setValue("Humidity", df.format(r.date), r.humidity))
}
