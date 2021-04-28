package invest.data.database

import org.jetbrains.exposed.sql.*

object CasePriceTable : Table() {

    val id: Column<Int> = integer("Id").autoIncrement()
    val name: Column<String> = varchar("Name", 255)

}