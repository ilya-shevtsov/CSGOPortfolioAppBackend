package invest.data.database

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object CaseReturnTable: Table() {

    val id: Column<Int> = integer("id").autoIncrement()
    val name: Column<String> = varchar("name", 255)

}