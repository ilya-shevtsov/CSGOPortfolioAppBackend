package invest.data.database

import org.jetbrains.exposed.sql.*

object CasePriceTable : Table() {

    val id: Column<Int> = integer("Id")
    val name: Column<String> = varchar("Name", 255)
    val Date: Column<String> = varchar("Date", 255)
    val Price: Column<Double> = double("Price")

}