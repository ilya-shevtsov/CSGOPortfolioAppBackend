package overview.data.database

import invest.data.model.Weapon
import org.jetbrains.exposed.sql.*

object CaseTable : Table() {

    val id: Column<Int> = integer("id").autoIncrement()
    val caseAccess: Column<String> = varchar("caseAccess", 255)
    val name: Column<String> = varchar("name", 255)
    val releaseDate: Column<String> = varchar("releaseDate", 255)
    val dropStatus: Column<String> = varchar("dropStatus", 255)
    val lowestPrice: Column<Double> = double("lowestPrice")
    val volume: Column<Int> = integer("volume")
    val medianPrice: Column<Double> = double("medianPrice")
    val imageUrl: Column<String> = varchar("imageUrl", 255)
    val description: Column<String> = varchar("description", 1000)
//    val weapons: Column<List<Weapon>> = v

    override val primaryKey = PrimaryKey(id, name = "PK_Case_ID")
}