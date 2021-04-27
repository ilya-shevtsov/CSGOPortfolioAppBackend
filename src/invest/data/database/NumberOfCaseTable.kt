package invest.data.database

import invest.data.database.CasePriceTable.autoIncrement
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object NumberOfCaseTable: Table() {

    val id: Column<Int> = integer("Id").autoIncrement()
    val name: Column<String> = varchar("Name", 255)

}