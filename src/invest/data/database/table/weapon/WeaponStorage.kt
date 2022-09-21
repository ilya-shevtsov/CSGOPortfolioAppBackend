package invest.data.database.table.weapon


import invest.data.model.CaseWeaponDbo
import org.jetbrains.exposed.sql.insert

object WeaponStorage {

    fun insertWeaponTable(caseWeaponDbo: CaseWeaponDbo) {
        WeaponTable.insert {
            it[caseId] = caseWeaponDbo.caseId
            it[caseName] = caseWeaponDbo.caseName
            it[weaponName] = caseWeaponDbo.weaponName
            it[weaponImage] = caseWeaponDbo.weaponImage
        }
    }


}