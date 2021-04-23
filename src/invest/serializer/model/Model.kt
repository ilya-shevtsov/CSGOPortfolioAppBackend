package invest.serializer.model

import kotlinx.serialization.SerialName

class Model {

    // As JSON example: [["hello ", []], ["Jake", [["b"], ["@", 1245]]]]
    data class TextValue(val tokens: List<TextToken>)

    // As JSON example: ["hello ", []]
// As JSON example: ["Jake", [["b"], ["@", 1245]]]
    data class TextToken(val plaintext: String, val annotations: List<Annotation>)

    sealed class Annotation {
        // As JSON example: ["b"]
        @SerialName("b")
        object Bold : Annotation()

        // As JSON example: ["i"]
        @SerialName("i")
        object Italic : Annotation()

        // As JSON example: ["@", 452534]
        @SerialName("@")
        data class Mention(val userId: Int)

    }
}