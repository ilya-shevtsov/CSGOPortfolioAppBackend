package invest.data.database.table

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.`java-time`.timestamp
import java.time.Instant

object CaseSellHistoryTable : Table() {

    val id: Column<Int> = integer("id")
    val name: Column<String> = varchar("name", 255)
    val date: Column<Instant> = timestamp("date")
    val price: Column<Double> = double("price")
    val volume: Column<Int> = integer("volume")

}