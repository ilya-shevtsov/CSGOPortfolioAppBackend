package invest.data.database

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object CaseReturnInPercentTable: Table() {

    val id: Column<Int> = integer("Id").autoIncrement()
    val name: Column<String> = varchar("Name", 255)

}