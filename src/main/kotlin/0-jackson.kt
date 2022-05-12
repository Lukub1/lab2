import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList

@JsonRootName("MyObj")
@JsonPropertyOrder(value = ["age", "name"])
data class MyStateObject(val name: String="", val age: Int=-1)

val jsonMapper = jacksonObjectMapper()
val xmlMapper = XmlMapper()

val myStateObject = MyStateObject("Sheldon", 30)



val dateNow = LocalDate.now().toString()
val originalFormat = SimpleDateFormat("yyyy-MM-dd")
val dateForm = SimpleDateFormat("yyyy.MM.dd")
val date: Date = originalFormat.parse(dateNow)
val formattedDate = dateForm.format(date)

@JsonFormat(
    shape = JsonFormat.Shape.STRING,
    pattern = "yyyy.MM.dd"
)

val objectsMap = ObjectMapper()

data class Lesson(val name: String = "", val date: String)
val myLesson = Lesson("Java Date", formattedDate)


val mysubject = Course("Math", PersonSurrogate("Leonard Euler"))


val physDeCode = Json.decodeFromString<Course>("{\"name\": \"Phys\"}")



val weekType = Json.encodeToString(arrayListOf(
    1 to WeekType.TRAINING,
    2 to WeekType.TRAINING,
    3 to WeekType.SESSION,
    4 to WeekType.HOLIDAY
))

val week: ArrayList<Week> = arrayListOf(   Week(1,WeekType.TRAINING),
                                            Week(2,WeekType.TRAINING),
                                            Week(3, WeekType.SESSION),
                                            Week(4, WeekType.HOLIDAY))

val weekJson = Json.encodeToString(week)






fun main(){
/*    val json = jsonMapper.writeValueAsString(myStateObject)
    val xml = xmlMapper.writeValueAsString(myStateObject)

    val newJson = json.replace("30", "35")
    val newXml = xml.replace("30", "35")

    val newJsonObject = jsonMapper.readValue<MyStateObject>(newJson)
    val newXmlObject = xmlMapper.readValue<MyStateObject>(newXml)

    println(json)
    println(xml)
    println(newJson)
    println(newXml)
    println(newJsonObject)
    println(newXmlObject)*/
    val lesson = objectsMap.writeValueAsString(myLesson)

    val subject = objectsMap.writeValueAsString(mysubject)


//   println(lesson) // 1task
//    println(subject) //2.2task
//    println(physDeCode) //2.3task

//    println(weekJson) //3task
    println(WeekTypeSerializer)
}
