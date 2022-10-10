package invest.data.tables


import invest.data.entities.CaseWeaponDbo
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