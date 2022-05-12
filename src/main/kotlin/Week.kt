import kotlinx.serialization.Serializable

@Serializable
data class Week (val number: Int, val type: WeekType){
}