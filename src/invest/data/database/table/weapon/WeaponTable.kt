package invest.data.database.table.weapon


import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.Column

object WeaponTable : Table() {

    val caseId: Column<Int> = WeaponTable.integer("caseId")
    val caseName: Column<String> = WeaponTable.varchar("caseName", 255)
    val weaponName: Column<String> = WeaponTable.varchar("weaponName", 255)
    val weaponImage: Column<String> = WeaponTable.varchar("weaponImage", 255)
}