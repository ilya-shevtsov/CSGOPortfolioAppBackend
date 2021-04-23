package invest.serializer

import invest.data.model.dailysellhistory.DailySellHistoryDto
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.*

object DailySellHistorySerializer : KSerializer<DailySellHistoryDto> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("DailySellHistoryDto") {}

    override fun serialize(encoder: Encoder, value: DailySellHistoryDto) {
        val jsonEncoder = encoder as JsonEncoder

        jsonEncoder.encodeJsonElement(buildJsonArray {
            add(value.date)
            add(value.price.toString())
            add(value.volume.toString())
        })
    }

    override fun deserialize(decoder: Decoder): DailySellHistoryDto {
        val jsonDecoder = (decoder as JsonDecoder)
        val list = jsonDecoder.decodeJsonElement().jsonArray

        return DailySellHistoryDto(
            date = list[0].jsonPrimitive.content,
            price = list[1].jsonPrimitive.content.toDouble(),
            volume = list[2].jsonPrimitive.content.toInt()
        )

    }
}
