package invest.data.database

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.`java-time`.timestamp
import java.time.Instant

object CasePriceTable : Table() {

    val id: Column<Int> = integer("Id")
    val name: Column<String> = varchar("Name", 255)
    val Date: Column<Instant> = timestamp("Date")
    val Price: Column<Double> = double("Price")

}