package invest.data.database

import org.jetbrains.exposed.sql.*

object CaseValueTable : Table() {

    val id: Column<Int> = integer("id").autoIncrement()
    val name: Column<String> = varchar("name", 255)

}