package invest.serializer

import invest.data.model.dailysellhistory.DailySellHistoryDto
import invest.serializer.invest.data.model.dailysellhistory.DailySellHistoryDtoNew
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.*

object DailySellHistorySerializer : KSerializer<DailySellHistoryDtoNew> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("DailySellHistoryDtoNew") {}

    override fun serialize(encoder: Encoder, value: DailySellHistoryDtoNew) {
        val jsonEncoder = encoder as JsonEncoder

        jsonEncoder.encodeJsonElement(buildJsonArray {
            add(value.date)
            add(value.price.toString())
            add(value.volume.toString())
        })
    }

    override fun deserialize(decoder: Decoder): DailySellHistoryDtoNew {
        val jsonDecoder = (decoder as JsonDecoder)
        val list = jsonDecoder.decodeJsonElement().jsonArray

        return DailySellHistoryDtoNew(
            date = list[0].jsonPrimitive.content,
            price = list[1].jsonPrimitive.content.toDouble(),
            volume = list[2].jsonPrimitive.content.toInt()
        )

    }
}
