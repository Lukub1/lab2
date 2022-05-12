import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("person")
data class PersonSurrogate private constructor(val firstname: String, val surname: String) {
    constructor(name: String) : this(
        name.substringBefore(" "),
        name.substringAfter(" ")
    )
}
@Serializable
data class Course(
    val name:String,
    val tutor: PersonSurrogate? = null
)
