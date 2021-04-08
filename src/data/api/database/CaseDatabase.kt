package data.api.database

import com.ilya.shevtsov.casewatcher.data.api.database.CaseDbo
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object CaseDatabase : Table() {
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

    override val primaryKey = PrimaryKey(id, name = "PK_Case_ID")

    fun toCase(row: ResultRow): CaseDbo {
        return CaseDbo(
            id = row[id],
            name = row[name],
            releaseDate = row[releaseDate],
            dropStatus = row[dropStatus],
            lowestPrice = row[lowestPrice],
            volume = row[volume],
            medianPrice = row[medianPrice],
            imageUrl = row[imageUrl],
            description = row[description]
        )
    }
}