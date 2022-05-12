import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.serializer

@Serializable
enum class WeekType {TRAINING, SESSION, HOLIDAY}




object WeekTypeSerializer : KSerializer<WeekType> {
    override val route: String = "Обучение"
    override fun serializer: KSerializer<WeekType> = serializer()
    }


