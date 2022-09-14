package overview.data.repository

import invest.data.model.Weapon
import overview.data.database.CaseTable
import overview.data.database.CaseStorage
import overview.data.model.case.CaseDbo
import overview.domain.model.marketoverview.MarketOverview
import overview.data.model.case.CaseDboMapper
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class DatabaseRepository {

    private val caseDboList = listOf(
        CaseDbo(
            caseAccess = "Chroma%20Case",
            name = "Chroma Case",
            releaseDate = "08.01.2015",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Chroma%20Case",
            description =
            "The Chroma Case is a weapon case consisting of 14 community-desgined weapon skins released as part of the January 8, 2015 update. It requires a Chroma Case Key to be opened. The Chroma Case also has six exclusive community created knife finishes: Damascus Steel, Doppler, Marble Fade, Tiger Tooth, Rust Coat, and Ultraviolet. The Spectrum Case and Spectrum 2 Case includes these Chroma finishes on the Huntsman Knife, Butterfly Knife, Falchion Knife, Shadow Daggers and the Bowie Knife. The Prisma Case contains these Chroma finishes on the Navaja Knife, Stiletto Knife, Talon Knife, and the Ursus Knife."
        ),
        CaseDbo(
            caseAccess = "Chroma%202%20Case",
            name = "Chroma 2 Case",
            releaseDate = "15.04.2015",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Chroma%202%20Case",
            description =
            "The Chroma 2 Case is a weapon case consisting of 15 community-made weapon skins released as part of the April 15, 2015 update. It requires a Chroma 2 Case Key to be opened."
        ),
        CaseDbo(
            caseAccess = "Chroma%203%20Case",
            name = "Chroma 3 Case",
            releaseDate = "20.04.2016",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Chroma%203%20Case",
            description =
            "The Chroma 3 Case is a weapon case consisting of community weapons released as part of the April 27, 2016 update. It requires a Chroma 3 Case Key to be opened."
        ),
        CaseDbo(
            caseAccess = "Clutch%20Case",
            name = "Clutch Case",
            releaseDate = "15.02.2018",
            dropStatus = "Active",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Clutch%20Case",
            description =
            "The Clutch Case is a weapon case featuring 17 community-designed weapon finishes and 24 new glove finishes. Released as part of the February 15, 2018 update. It requires a Clutch Case Key to be opened."
        ),
        CaseDbo(
            caseAccess = "CS%3AGO%20Weapon%20Case",
            name = "CS:GO Weapon Case",
            releaseDate = "14.08.2013",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/CS%3AGO%20Weapon%20Case",
            description =
            "The CS:GO Weapon Case is the first series of Weapon Cases introduced in Counter-Strike: Global Offensive and contains 9 Valve-made finishes during the August 14, 2013 Arms Deal update. The Weapon Case requires a standard CS:GO Case Key to be opened. Since the release of Weapon Case 2, this crate is very rarely dropped."
        ),
        CaseDbo(
            caseAccess = "CS%3AGO%20Weapon%20Case%202",
            name = "CS:GO Weapon Case 2",
            releaseDate = "08.11.2013",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/CS%3AGO%20Weapon%20Case%202",
            description =
            "The CSGO Weapon Case 2 was introduced to Counter-Strike: Global Offensive as part of the November 6, 2013 update, switching the CSGO Weapon Case to a rare drop. The standard CSGO Case Key can be used to open this case. Since the release of CSGO Weapon Case 3, this case is a rare drop."
        ),
        CaseDbo(
            caseAccess = "CS%3AGO%20Weapon%20Case%203",
            name = "CS:GO Weapon Case 3",
            releaseDate = "12.02.2014",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/CS%3AGO%20Weapon%20Case%203",
            description =
            "The Weapon Case 3 is a case featured in Counter-Strike: Global Offensive, released as part of the February 12, 2014 update when the CZ75-Auto was released as a pistol-exclusive weapon case. This case requires the standard CS:GO Case Key to open."
        ),
        CaseDbo(
            caseAccess = "CS20%20Case",
            name = "CS20 Case",
            releaseDate = "18.10.2019",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/CS20%20Case",
            description =
            "The CS20 Case is a weapon case featuring 17 community-made skins made for the CS20 event that have a Counter-Strike theme to it. It features the Classic Knife in 13 different finishes. It was released during the October 18, 2019 in the CS20 event, along with the CS20 Sticker Capsule. There is a tiny chance to unbox the Classic Knife."
        ),
        CaseDbo(
            caseAccess = "Danger%20Zone%20Case",
            name = "Danger Zone Case",
            releaseDate = "06.12.2018",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Danger%20Zone%20Case",
            description =
            "The Danger Zone Case is a weapon case of community created weapon skins released in the December 6, 2018 update. It requires a Danger Zone Case Key to be opened. There is also a small chance to receive one of the Horizon knives when opening the case."
        ),
        CaseDbo(
            caseAccess = "eSports%202013%20Case",
            name = "eSports 2013 Case",
            releaseDate = "14.08.2013",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/eSports%202013%20Case",
            description =
            "The eSports 2013 Case is the second ever weapon crate released in Counter-Strike: Global Offensive during the August 14, 2013 Arms Deal update. A portion of the profits from the eSports key sales are given to the Counter-Strike eSports community. Since the introduction of the eSports 2013 Winter Case, the eSports 2013 Case drops very rarely."
        ),
        CaseDbo(
            caseAccess = "eSports%202013%20Winter%20Case",
            name = "eSports 2013 Winter Case",
            releaseDate = "18.12.2013",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/eSports%202013%20Winter%20Case",
            description =
            "The eSports 2013 Winter Case is a weapon case in Counter-Strike: Global Offensive introduced as part of the December 18, 2013 Winter Offensive update that contains 12 Valve-made skins. A portion of the profits from the eSports key sales are given to the Counter-Strike eSports community. Since the introduction of the eSports 2014 Summer Case, the eSports 2013 Winter Case drops very rarely."
        ),
        CaseDbo(
            caseAccess = "eSports%202014%20Summer%20Case",
            name = "eSports 2014 Summer Case",
            releaseDate = "10.07.2014",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/eSports%202014%20Summer%20Case",
            description =
            "The eSports 2014 Summer Case is a weapon crate in Counter-Strike: Global Offensive added as part of the July, 10, 2014 update. It contains 17 weapon skins that are made by Valve. A portion of the profits from the eSports key sales are given to the Counter-Strike eSports community."
        ),
        CaseDbo(
            caseAccess = "Falchion%20Case",
            name = "Falchion Case",
            releaseDate = "26.05.2015",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Falchion%20Case",
            description =
            "The Falchion Case is a weapon case released on the May 26, 2015 update, alongside with Operation Bloodhound as an exclusive drop to pass holders. After Operation Bloodhound came to a close, the case was available to drop for all players. This case also introduces the case-exclusive Falchion Knife which can be unboxed at a very low chance."
        ),
        CaseDbo(
            caseAccess = "Fracture%20Case",
            name = "Fracture Case",
            releaseDate = "07.08.2020",
            dropStatus = "Active",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Fracture%20Case",
            description =
            "The Fracture Case is a weapon case featuring 17 community-designed weapon finishes and along with the Shattered Web Case knives (Paracord Knife, Survival Knife, Skeleton Knife, Nomad Knife), in the standard knife finishes."
        ),
        CaseDbo(
            caseAccess = "Gamma%20Case",
            name = "Gamma Case",
            releaseDate = "15.06.2016",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Gamma%20Case",
            description =
            "The Gamma Case is a weapon case consisting of community weapons and new knife finishes released as part of the June 15, 2016 update. It requires a Gamma Case Key to be opened. On Glock-18 Wasteland Rebel, the numbers 7355608 are hidden on the back of the gun. Glock-18 Wasteland Rebel contains many hidden smaller painted messages and symbols that can be seen at a very low weapon condition, which are covered by the Kill Them All graffiti on higher conditions."
        ),
        CaseDbo(
            caseAccess = "Gamma%202%20Case",
            name = "Gamma 2 Case",
            releaseDate = "18.08.2016",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Gamma%202%20Case",
            description =
            "The Gamma 2 Case is a weapon case consisting of community weapons and new knife finishes released as part of the August 18, 2016 update. It requires a Gamma Case Key to be opened."
        ),
        CaseDbo(
            caseAccess = "Glove%20Case",
            name = "Glove Case",
            releaseDate = "28.11.2016",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Glove%20Case",
            description =
            "The Glove Case is a weapon case consisting of community weapons and new gloves released as part of the November 28, 2016 update. It requires a Glove Case Key to be opened."
        ),
        CaseDbo(
            caseAccess = "Horizon%20Case",
            name = "Horizon Case",
            releaseDate = "02.08.2018",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Horizon%20Case",
            description =
            "The Horizon Case is a weapon case featuring 17 community-designed weapon finishes and along Ursus Knife, Navaja Knife, Stiletto Knife, Talon Knife. Released as part of the August 3, 2018 update. It requires a Horizon Case Key to be opened."
        ),
        CaseDbo(
            caseAccess = "Huntsman%20Weapon%20Case",
            name = "Huntsman Weapon Case",
            releaseDate = "01.05.2014",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Huntsman%20Weapon%20Case",
            description =
            "The Huntsman Weapon Case is a weapon case consisting of 15 community-made weapon skins released as part of the May 1, 2014 update that also introduced the Bank Collection. It requires a Huntsman Weapon Case Key to be opened. There is a small chance to unbox a Huntsman Knife when opening the case. On June 11th, 2014, the Huntsman Weapon Case was updated, along with the Community Sticker Capsule 1 due to a copyright infringement[1][2][3]. The M4A4 | Howl and several other weapon skins were removed and 6 new weapon skins were added."
        ),
        CaseDbo(
            caseAccess = "Operation%20Bravo%20Case",
            name = "Operation Bravo Case",
            releaseDate = "19.09.2013",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Operation%20Bravo%20Case",
            description =
            "The Operation Bravo Case is a crate containing 15 Valve-made weapon skins that was released during September 19, 2013. Since the release of Operation Bravo, any player could obtain this case. However, holders of the Operation Bravo pass had a higher chance to receive the case as a drop. Like the CSGO Weapon Case, the standard weapon case key can be used to open this case. Since the end of Operation Bravo, this case drops very rarely."
        ),
        CaseDbo(
            caseAccess = "Operation%20Breakout%20Weapon%20Case",
            name = "Operation Breakout Weapon Case",
            releaseDate = "01.07.2014",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Operation%20Breakout%20Weapon%20Case",
            description =
            "The Operation Breakout Case is a weapon case consisting of 14 community-created weapon skins released as part of Operation Breakout with the July 1, 2014 update. Like the Operation Phoenix Weapon Case during Operation Phoenix, Operation Breakout Coin holders received this case. Once the operation ended on October 2, 2014, the weapon case became available for all CS:GO players."
        ),
        CaseDbo(
            caseAccess = "Operation%20Broken%20Fang%20Case",
            name = "Operation Broken Fang Case",
            releaseDate = "04.12.2020",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Operation%20Broken%20Fang%20Case",
            description =
            "The Broken Fang Case is a case that contains 17 community-made weapon skins released as part of Operation Broken Fang. There is a very small chance to unbox a pair of gloves."
        ),
        CaseDbo(
            caseAccess = "Operation%20Hydra%20Case",
            name = "Operation Hydra Case",
            releaseDate = "23.05.2017",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Operation%20Hydra%20Case",
            description =
            "The Operation Hydra Case is a weapon case of community created weapon skins AWP Oni Taiji is likely named after the Japanese phrase 鬼退治 (おに　たいじ, Oni Taiji), which means evil spirit extermination. As each case Key in-game is worth $2.49, this is the only case where the Key only costs around $1.and new gloves released in the May 23, 2017 update, alongside with Operation Hydra as an exclusive drop to pass holders. It requires a Operation Hydra Case Key to be opened."
        ),
        CaseDbo(
            caseAccess = "Operation%20Phoenix%20Weapon%20Case",
            name = "Operation Phoenix Weapon Case",
            releaseDate = "20.02.2014",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Operation%20Phoenix%20Weapon%20Case",
            description =
            "The Operation Phoenix Case is a weapon case of 13 community-created weapon skins released on February 20, 2014 as part of Operation Phoenix. The chance for the case to drop was originally exclusive to pass owners. As of the June 11, 2014 update, the weapon case became available as a drop for all players."
        ),
        CaseDbo(
            caseAccess = "Operation%20Vanguard%20Weapon%20Case",
            name = "Operation Vanguard Weapon Case",
            releaseDate = "11.11.2014",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Operation%20Vanguard%20Weapon%20Case",
            description =
            "The Operation Vanguard Case is a weapon case consisting of 14 community-created weapon skins released as part of Operation Vanguard during the November 11, 2014 update. Like the previous operation cases, Operation Vanguard Coin holders receive exclusive case drops in addition to the normal timed drops during Operation Vanguard as well as the potential to receive a case as a mission drop."
        ),
        CaseDbo(
            caseAccess = "Operation%20Wildfire%20Case",
            name = "Operation Wildfire Case",
            releaseDate = "17.02.2016",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Operation%20Wildfire%20Case",
            description =
            "The Operation Wildfire Case is a weapon case released in the February 17, 2016 update, alongside with Operation Wildfire as an exclusive drop to pass holders. This case also introduces the case-exclusive Bowie Knife which can be awarded at a very low chance. Due to the way Valve has re-sized the Case Hardened texture for the Bowie Knife, it is now much easier to get an almost full blue gem Case Hardened Bowie knife."
        ),
        CaseDbo(
            caseAccess = "Prisma%20Case",
            name = "Prisma Case",
            releaseDate = "13.03.2019",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Prisma%20Case",
            description =
            "The Prisma Case is a weapon case featuring 17 community-designed weapon finishes and along with Ursus Knife, Navaja Knife, Stiletto Knife, and Talon Knife, in Chroma finishes. The case was released as part of the March 13, 2019 update. It requires a Prisma Case Key to be opened."
        ),
        CaseDbo(
            caseAccess = "Prisma%202%20Case",
            name = "Prisma 2 Case",
            releaseDate = "01.04.2020",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Prisma%202%20Case",
            description =
            "Case Prism 2 is a container with weapon skins in Counter-Strike: Global Offensive. To open a special key from the case Prism 2."
        ),
        CaseDbo(
            caseAccess = "Revolver%20Case",
            name = "Revolver Case",
            releaseDate = "08.12.2015",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Revolver%20Case",
            description =
            "The Revolver Case is a weapon case consisting of 16 community-created weapon skins released as part of the December 8, 2015 update. The Revolver Case was the first case to contain skins for the R8 Revolver."
        ),
        CaseDbo(
            caseAccess = "Shadow%20Case",
            name = "Shadow Case",
            releaseDate = "17.09.2015",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Shadow%20Case",
            description =
            "The Shadow Case is a weapon case consisting of 16 community-made weapon skins released as part of the September 18, 2015 update. It requires a Shadow Case Key to be opened. There is a tiny chance to unbox a pair of Shadow Daggers."
        ),
        CaseDbo(
            caseAccess = "Shattered%20Web%20Case",
            name = "Shattered Web Case",
            releaseDate = "18.11.2019",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Shattered%20Web%20Case",
            description =
            "The Shattered Web Cas`e is a case that contains 17 community-made weapon skins released as part of Operation Shattered Web. There is a very small chance to unbox the Nomad Knife, Skeleton Knife, Paracord Knife, and the Survival Knife each in 13 different finishes."
        ),
        CaseDbo(
            caseAccess = "Snakebite%20Case",
            name = "Snakebite Case",
            releaseDate = "03.05.2021",
            dropStatus = "Active",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://www.csgodatabase.com/images/containers/webp/Snakebite_Case.webp",
            description =
            "The Snakebite Case is a weapon case introduced on 03 May 2021 as part of the End of Broken Fang update. The weapon case contains CS:GO skins from The Snakebite Collection."        ),
        CaseDbo(
            caseAccess = "Spectrum%20Case",
            name = "Spectrum Case",
            releaseDate = "15.03.2017",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Spectrum%20Case",
            description =
            "The Spectrum Case is a weapon case consisting of community weapons and new knife finishes for second generation of knives in Chroma Case released as part of the March 15, 2017 update. It requires a Spectrum Case Key to be opened."
        ),
        CaseDbo(
            caseAccess = "Spectrum%202%20Case",
            name = "Spectrum 2 Case",
            releaseDate = "14.09.2017",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Spectrum%202%20Case",
            description =
            "The Spectrum 2 Case is a weapon case consisting of community weapons and Chroma finishes for the later-added knives, released as part of the September 14, 2017 update. It requires a Spectrum 2 Case Key to be opened."
        ),
        CaseDbo(
            caseAccess = "Winter%20Offensive%20Weapon%20Case",
            name = "Winter Offensive Weapon Case",
            releaseDate = "18.12.2013",
            dropStatus = "Inactive (Rare)",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Winter%20Offensive%20Weapon%20Case",
            description =
            "The Winter Offensive Weapon Case is a weapon case containing 12 community-created skins. It was released as part of the December 18, 2013 update and requires a Winter Offensive Case Key to open. Since the release of Operation Vanguard, this crate is very rarely dropped. It can also be bought in the Steam Community Market."
        ),
        CaseDbo(
            caseAccess = "Dreams%20%26%20Nightmares%20Case",
            name = "Dreams & Nightmares Case",
            releaseDate = "20.01.2022",
            dropStatus = "Active",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Dreams%20%26%20Nightmares%20Case",
            description =
            "The Dreams & Nightmares Case is a weapon case introduced on 20 January 2022 as part of the Dreams & Nightmares Case update. The weapon case contains CS:GO skins from The Dreams & Nightmares Collection. The case contains 17 skins, all of which were selected from the Dreams & Nightmares contest which ran from 22 July 2021 through to 21 October 2021. The rare special items in this case are the second generation Gamma Knives which first appeared in the Operation Riptide case."
        ),
        CaseDbo(
            caseAccess = "Recoil%20Case",
            name = "Recoil Case",
            releaseDate = "01.07.2022",
            dropStatus = "Active",
            lowestPrice = 00.00,
            volume = 0,
            medianPrice = 00.00,
            imageUrl = "https://api.steamapis.com/image/item/730/Recoil%20Case",
            description =
            "The Recoil Case is a weapon case introduced on 01 July 2022 as part of the A New Cassssssse update. The weapon case contains CS:GO skins from The Recoil Collection. The rare special items in this case are the Broken Fang gloves which first appeared in the Operation Broken Fang case and also appear in the Snakebite case."
        )
    )

    fun getCaseList(): List<CaseDbo> {
        return transaction {
            CaseTable.selectAll().map { CaseDboMapper.map(it) }
        }
    }

    fun saveMarketOverview(caseId: Int, marketOverviewDto: MarketOverview) {
        CaseStorage.saveMarketOverview(caseId, marketOverviewDto)
    }

    fun insertInitialData() {
        val storedCaseList = getCaseList()
        caseDboList.forEach { caseDbo ->
            if (storedCaseList.all { storedCase -> caseDbo.name != storedCase.name }) {
                CaseStorage.insertToCaseTable(caseDbo)
            }
        }
    }
    
//    private val newCaseDboList = listOf(
//        CaseDbo(
//            caseAccess = "Chroma%20Case",
//            name = "Chroma Case",
//            releaseDate = "08.01.2015",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Chroma%20Case",
//            description =
//            "The Chroma Case is a weapon case consisting of 14 community-desgined weapon skins released as part of the January 8, 2015 update. It requires a Chroma Case Key to be opened. The Chroma Case also has six exclusive community created knife finishes: Damascus Steel, Doppler, Marble Fade, Tiger Tooth, Rust Coat, and Ultraviolet. The Spectrum Case and Spectrum 2 Case includes these Chroma finishes on the Huntsman Knife, Butterfly Knife, Falchion Knife, Shadow Daggers and the Bowie Knife. The Prisma Case contains these Chroma finishes on the Navaja Knife, Stiletto Knife, Talon Knife, and the Ursus Knife.",
//            weapons = listOf(
//                Weapon(
//                    "Glock-18 | Catacombs",
//                    "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Catacombs%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M249 | System Lock",
//                    "https://api.steamapis.com/image/item/730/M249%20%7C%20System%20Lock%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP9 | Deadly Poison",
//                    "https://api.steamapis.com/image/item/730/MP9%20%7C%20Deadly%20Poison%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SCAR-20 | Grotto",
//                    "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Grotto%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "XM1014 | Quicksilver",
//                    "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Quicksilver%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Dual Berettas | Urban Shock",
//                    "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Urban%20Shock%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Desert Eagle | Naga",
//                    "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Naga%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAC-10 | Malachite",
//                    "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Malachite%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Sawed-Off | Serenity",
//                    "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Serenity%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Cartel",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Cartel%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A4 | 龍王 (Dragon King)",
//                    "https://api.steamapis.com/image/item/730/M4A4%20%7C%20龍王%20(Dragon%20King)%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P250 | Muertos",
//                    "https://api.steamapis.com/image/item/730/P250%20%7C%20Muertos%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | Man-o'-war",
//                    "https://api.steamapis.com/image/item/730/AWP%20%7C%20Man-o'-war%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Galil AR | Chatterbox",
//                    "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Chatterbox%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Chroma%202%20Case",
//            name = "Chroma 2 Case",
//            releaseDate = "15.04.2015",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Chroma%202%20Case",
//            description =
//            "The Chroma 2 Case is a weapon case consisting of 15 community-made weapon skins released as part of the April 15, 2015 update. It requires a Chroma 2 Case Key to be opened.",
//            weapons = listOf(
//                Weapon(
//                    "AK-47 | Elite Build",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Elite%20Build%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP7 | Armor Core",
//                    "https://api.steamapis.com/image/item/730/MP7%20%7C%20Armor%20Core%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Desert Eagle | Bronze Deco",
//                    "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Bronze%20Deco%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P250 | Valence",
//                    "https://api.steamapis.com/image/item/730/P250%20%7C%20Valence%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Negev | Man-o'-war",
//                    "https://api.steamapis.com/image/item/730/Negev%20%7C%20Man-o'-war%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Sawed-Off | Origami",
//                    "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Origami%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | Worm God",
//                    "https://api.steamapis.com/image/item/730/AWP%20%7C%20Worm%20God%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAG-7 | Heat",
//                    "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Heat%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "CZ75-Auto | Pole Position",
//                    "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Pole%20Position%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "UMP-45 | Grand Prix",
//                    "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Grand%20Prix%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Five-SeveN | Monkey Business",
//                    "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Monkey%20Business%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Galil AR | Eco",
//                    "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Eco%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "FAMAS | Djinn",
//                    "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Djinn%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A1-S | Hyper Beast",
//                    "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Hyper%20Beast%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAC-10 | Neon Rider",
//                    "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Neon%20Rider%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Chroma%203%20Case",
//            name = "Chroma 3 Case",
//            releaseDate = "20.04.2016",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Chroma%203%20Case",
//            description =
//            "The Chroma 3 Case is a weapon case consisting of community weapons released as part of the April 27, 2016 update. It requires a Chroma 3 Case Key to be opened.",
//            weapons = listOf(
//                Weapon(
//                    "Dual Berettas | Ventilators",
//                    "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Ventilators%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "G3SG1 | Orange Crash",
//                    "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Orange%20Crash%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M249 | Spectre",
//                    "https://api.steamapis.com/image/item/730/M249%20%7C%20Spectre%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP9 | Bioleak",
//                    "https://api.steamapis.com/image/item/730/MP9%20%7C%20Bioleak%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P2000 | Oceanic",
//                    "https://api.steamapis.com/image/item/730/P2000%20%7C%20Oceanic%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Sawed-Off | Fubar",
//                    "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Fubar%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SG 553 | Atlas",
//                    "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Atlas%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "CZ75-Auto | Red Astor",
//                    "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Red%20Astor%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Galil AR | Firefight",
//                    "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Firefight%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SSG 08 | Ghost Crusader",
//                    "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Ghost%20Crusader%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Tec-9 | Re-Entry",
//                    "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Re-Entry%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "XM1014 | Black Tie",
//                    "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Black%20Tie%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AUG | Fleet Flock",
//                    "https://api.steamapis.com/image/item/730/AUG%20%7C%20Fleet%20Flock%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P250 | Asiimov",
//                    "https://api.steamapis.com/image/item/730/P250%20%7C%20Asiimov%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "UMP-45 | Primal Saber",
//                    "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Primal%20Saber%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "PP-Bizon | Judgement of Anubis",
//                    "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Judgement%20of%20Anubis%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A1-S | Chantico's Fire",
//                    "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Chantico's%20Fire%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Clutch%20Case",
//            name = "Clutch Case",
//            releaseDate = "15.02.2018",
//            dropStatus = "Active",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Clutch%20Case",
//            description =
//            "The Clutch Case is a weapon case featuring 17 community-designed weapon finishes and 24 new glove finishes. Released as part of the February 15, 2018 update. It requires a Clutch Case Key to be opened.",
//            weapons = listOf(
//                Weapon(
//                    "PP-Bizon | Night Riot",
//                    "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Night%20Riot%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Five-SeveN | Flame Test",
//                    "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Flame%20Test%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP9 | Black Sand",
//                    "https://api.steamapis.com/image/item/730/MP9%20%7C%20Black%20Sand%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P2000 | Urban Hazard",
//                    "https://api.steamapis.com/image/item/730/P2000%20%7C%20Urban%20Hazard%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "R8 Revolver | Grip",
//                    "https://api.steamapis.com/image/item/730/R8%20Revolver%20%7C%20Grip%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SG 553 | Aloha",
//                    "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Aloha%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "XM1014 | Oxide Blaze",
//                    "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Oxide%20Blaze%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Glock-18 | Moonrise",
//                    "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Moonrise%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Negev | Lionfish",
//                    "https://api.steamapis.com/image/item/730/Negev%20%7C%20Lionfish%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Nova | Wild Six",
//                    "https://api.steamapis.com/image/item/730/Nova%20%7C%20Wild%20Six%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAG-7 | SWAG-7",
//                    "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20SWAG-7%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "UMP-45 | Arctic Wolf",
//                    "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Arctic%20Wolf%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AUG | Stymphalian",
//                    "https://api.steamapis.com/image/item/730/AUG%20%7C%20Stymphalian%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | Mortis",
//                    "https://api.steamapis.com/image/item/730/AWP%20%7C%20Mortis%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "USP-S | Cortex",
//                    "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Cortex%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A4 | Neo-Noir",
//                    "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Neo-Noir%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP7 | Bloodsport",
//                    "https://api.steamapis.com/image/item/730/MP7%20%7C%20Bloodsport%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "CS%3AGO%20Weapon%20Case",
//            name = "CS:GO Weapon Case",
//            releaseDate = "14.08.2013",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/CS%3AGO%20Weapon%20Case",
//            description =
//            "The CS:GO Weapon Case is the first series of Weapon Cases introduced in Counter-Strike: Global Offensive and contains 9 Valve-made finishes during the August 14, 2013 Arms Deal update. The Weapon Case requires a standard CS:GO Case Key to be opened. Since the release of Weapon Case 2, this crate is very rarely dropped.",
//            weapons = listOf(
//                Weapon(
//                    "MP7 | Skulls",
//                    "https://api.steamapis.com/image/item/730/MP7%20%7C%20Skulls%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AUG | Wings",
//                    "https://api.steamapis.com/image/item/730/AUG%20%7C%20Wings%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SG 553 | Ultraviolet",
//                    "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Ultraviolet%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Glock-18 | Dragon Tattoo",
//                    "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Dragon%20Tattoo%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "USP-S | Dark Water",
//                    "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Dark%20Water%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A1-S | Dark Water",
//                    "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Dark%20Water%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Case Hardened",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Case%20Hardened%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Desert Eagle | Hypnotic",
//                    "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Hypnotic%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | Lightning Strike",
//                    "https://api.steamapis.com/image/item/730/AWP%20%7C%20Lightning%20Strike%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "CS%3AGO%20Weapon%20Case%202",
//            name = "CS:GO Weapon Case 2",
//            releaseDate = "08.11.2013",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/CS%3AGO%20Weapon%20Case%202",
//            description =
//            "The CSGO Weapon Case 2 was introduced to Counter-Strike: Global Offensive as part of the November 6, 2013 update, switching the CSGO Weapon Case to a rare drop. The standard CSGO Case Key can be used to open this case. Since the release of CSGO Weapon Case 3, this case is a rare drop.",
//            weapons = listOf(
//                Weapon(
//                    "Tec-9 | Blue Titanium",
//                    "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Blue%20Titanium%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A1-S | Blood Tiger",
//                    "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Blood%20Tiger%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "FAMAS | Hexane",
//                    "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Hexane%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P250 | Hive",
//                    "https://api.steamapis.com/image/item/730/P250%20%7C%20Hive%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SCAR-20 | Crimson Web",
//                    "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Crimson%20Web%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Five-SeveN | Case Hardened",
//                    "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Case%20Hardened%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP9 | Hypnotic",
//                    "https://api.steamapis.com/image/item/730/MP9%20%7C%20Hypnotic%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Nova | Graphite",
//                    "https://api.steamapis.com/image/item/730/Nova%20%7C%20Graphite%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Dual Berettas | Hemoglobin",
//                    "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Hemoglobin%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P90 | Cold Blooded",
//                    "https://api.steamapis.com/image/item/730/P90%20%7C%20Cold%20Blooded%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "USP-S | Serum",
//                    "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Serum%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SSG 08 | Blood in the Water",
//                    "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Blood%20in%20the%20Water%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "CS%3AGO%20Weapon%20Case%203",
//            name = "CS:GO Weapon Case 3",
//            releaseDate = "12.02.2014",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/CS%3AGO%20Weapon%20Case%203",
//            description =
//            "The Weapon Case 3 is a case featured in Counter-Strike: Global Offensive, released as part of the February 12, 2014 update when the CZ75-Auto was released as a pistol-exclusive weapon case. This case requires the standard CS:GO Case Key to open.",
//            weapons = listOf(
//                Weapon(
//                    "CZ75-Auto | Crimson Web",
//                    "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Crimson%20Web%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P2000 | Red FragCam",
//                    "https://api.steamapis.com/image/item/730/P2000%20%7C%20Red%20FragCam%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Dual Berettas | Panther",
//                    "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Panther%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "USP-S | Stainless",
//                    "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Stainless%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Glock-18 | Blue Fissure",
//                    "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Blue%20Fissure%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "CZ75-Auto | Tread Plate",
//                    "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Tread%20Plate%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Tec-9 | Titanium Bit",
//                    "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Titanium%20Bit%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Desert Eagle | Heirloom",
//                    "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Heirloom%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Five-SeveN | Copper Galaxy",
//                    "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Copper%20Galaxy%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "CZ75-Auto | The Fuschia Is Now",
//                    "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20The%20Fuschia%20Is%20Now%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P250 | Undertow",
//                    "https://api.steamapis.com/image/item/730/P250%20%7C%20Undertow%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "CZ75-Auto | Victoria",
//                    "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Victoria%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "CS20%20Case",
//            name = "CS20 Case",
//            releaseDate = "18.10.2019",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/CS20%20Case",
//            description =
//            "The CS20 Case is a weapon case featuring 17 community-made skins made for the CS20 event that have a Counter-Strike theme to it. It features the Classic Knife in 13 different finishes. It was released during the October 18, 2019 in the CS20 event, along with the CS20 Sticker Capsule. There is a tiny chance to unbox the Classic Knife.",
//            weapons = listOf(
//                Weapon(
//                    "Dual Berettas | Elite 1.6",
//                    "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Elite%201.6%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Tec-9 | Flash Out",
//                    "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Flash%20Out%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAC-10 | Classic Crate",
//                    "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Classic%20Crate%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAG-7 | Popdog",
//                    "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Popdog%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SCAR-20 | Assault",
//                    "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Assault%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "FAMAS | Decommissioned",
//                    "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Decommissioned%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Glock-18 | Sacrifice",
//                    "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Sacrifice%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M249 | Aztec",
//                    "https://api.steamapis.com/image/item/730/M249%20%7C%20Aztec%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP5-SD | Agent",
//                    "https://api.steamapis.com/image/item/730/MP5-SD%20%7C%20Agent%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Five-SeveN | Buddy",
//                    "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Buddy%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P250 | Inferno",
//                    "https://api.steamapis.com/image/item/730/P250%20%7C%20Inferno%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "UMP-45 | Plastique",
//                    "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Plastique%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP9 | Hydra",
//                    "https://api.steamapis.com/image/item/730/MP9%20%7C%20Hydra%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P90 | Nostalgia",
//                    "https://api.steamapis.com/image/item/730/P90%20%7C%20Nostalgia%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AUG | Death by Puppy",
//                    "https://api.steamapis.com/image/item/730/AUG%20%7C%20Death%20by%20Puppy%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | Wildfire",
//                    "https://api.steamapis.com/image/item/730/AWP%20%7C%20Wildfire%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "FAMAS | Commemoration",
//                    "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Commemoration%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Danger%20Zone%20Case",
//            name = "Danger Zone Case",
//            releaseDate = "06.12.2018",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Danger%20Zone%20Case",
//            description =
//            "The Danger Zone Case is a weapon case of community created weapon skins released in the December 6, 2018 update. It requires a Danger Zone Case Key to be opened. There is also a small chance to receive one of the Horizon knives when opening the case.",
//            weapons = listOf(
//                Weapon(
//                    "MP9 | Modest Threat",
//                    "https://api.steamapis.com/image/item/730/MP9%20%7C%20Modest%20Threat%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Glock-18 | Oxide Blaze",
//                    "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Oxide%20Blaze%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Nova | Wood Fired",
//                    "https://api.steamapis.com/image/item/730/Nova%20%7C%20Wood%20Fired%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A4 | Magnesium",
//                    "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Magnesium%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Sawed-Off | Black Sand",
//                    "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Black%20Sand%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SG 553 | Danger Close",
//                    "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Danger%20Close%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Tec-9 | Fubar",
//                    "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Fubar%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "G3SG1 | Scavenger",
//                    "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Scavenger%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Galil AR | Signal",
//                    "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Signal%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAC-10 | Pipe Down",
//                    "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Pipe%20Down%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P250 | Nevermore",
//                    "https://api.steamapis.com/image/item/730/P250%20%7C%20Nevermore%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "USP-S | Flashback",
//                    "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Flashback%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "UMP-45 | Momentum",
//                    "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Momentum%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Desert Eagle | Mecha Industries",
//                    "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Mecha%20Industries%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP5-SD | Phosphor",
//                    "https://api.steamapis.com/image/item/730/MP5-SD%20%7C%20Phosphor%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Asiimov",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Asiimov%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | Neo-Noir",
//                    "https://api.steamapis.com/image/item/730/AWP%20%7C%20Neo-Noir%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "eSports%202013%20Case",
//            name = "eSports 2013 Case",
//            releaseDate = "14.08.2013",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/eSports%202013%20Case",
//            description =
//            "The eSports 2013 Case is the second ever weapon crate released in Counter-Strike: Global Offensive during the August 14, 2013 Arms Deal update. A portion of the profits from the eSports key sales are given to the Counter-Strike eSports community. Since the introduction of the eSports 2013 Winter Case, the eSports 2013 Case drops very rarely.",
//            weapons = listOf(
//                Weapon(
//                    "M4A4 | Faded Zebra",
//                    "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Faded%20Zebra%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAG-7 | Memento",
//                    "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Memento%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "FAMAS | Doomkitty",
//                    "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Doomkitty%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Galil AR | Orange DDPAT",
//                    "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Orange%20DDPAT%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Sawed-Off | Orange DDPAT",
//                    "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Orange%20DDPAT%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P250 | Splash",
//                    "https://api.steamapis.com/image/item/730/P250%20%7C%20Splash%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Red Laminate",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Red%20Laminate%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | BOOM",
//                    "https://api.steamapis.com/image/item/730/AWP%20%7C%20BOOM%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P90 | Death by Kitty",
//                    "https://api.steamapis.com/image/item/730/P90%20%7C%20Death%20by%20Kitty%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "eSports%202013%20Winter%20Case",
//            name = "eSports 2013 Winter Case",
//            releaseDate = "18.12.2013",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/eSports%202013%20Winter%20Case",
//            description =
//            "The eSports 2013 Winter Case is a weapon case in Counter-Strike: Global Offensive introduced as part of the December 18, 2013 Winter Offensive update that contains 12 Valve-made skins. A portion of the profits from the eSports key sales are given to the Counter-Strike eSports community. Since the introduction of the eSports 2014 Summer Case, the eSports 2013 Winter Case drops very rarely.",
//            weapons = listOf(
//                Weapon(
//                    "Galil AR | Blue Titanium",
//                    "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Blue%20Titanium%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Five-SeveN | Nightshade",
//                    "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Nightshade%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "PP-Bizon | Water Sigil",
//                    "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Water%20Sigil%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Nova | Ghost Camo",
//                    "https://api.steamapis.com/image/item/730/Nova%20%7C%20Ghost%20Camo%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "G3SG1 | Azure Zebra",
//                    "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Azure%20Zebra%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P250 | Steel Disruption",
//                    "https://api.steamapis.com/image/item/730/P250%20%7C%20Steel%20Disruption%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Blue Laminate",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Blue%20Laminate%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P90 | Blind Spot",
//                    "https://api.steamapis.com/image/item/730/P90%20%7C%20Blind%20Spot%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "FAMAS | Afterimage",
//                    "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Afterimage%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | Electric Hive",
//                    "https://api.steamapis.com/image/item/730/AWP%20%7C%20Electric%20Hive%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Desert Eagle | Cobalt Disruption",
//                    "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Cobalt%20Disruption%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A4 | X-Ray",
//                    "https://api.steamapis.com/image/item/730/M4A4%20%7C%20X-Ray%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "eSports%202014%20Summer%20Case",
//            name = "eSports 2014 Summer Case",
//            releaseDate = "10.07.2014",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/eSports%202014%20Summer%20Case",
//            description =
//            "The eSports 2014 Summer Case is a weapon crate in Counter-Strike: Global Offensive added as part of the July, 10, 2014 update. It contains 17 weapon skins that are made by Valve. A portion of the profits from the eSports key sales are given to the Counter-Strike eSports community.",
//            weapons = listOf(
//                Weapon(
//                    "SSG 08 | Dark Water",
//                    "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Dark%20Water%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAC-10 | Ultraviolet",
//                    "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Ultraviolet%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "USP-S | Blood Tiger",
//                    "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Blood%20Tiger%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "CZ75-Auto | Hexane",
//                    "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Hexane%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Negev | Bratatat",
//                    "https://api.steamapis.com/image/item/730/Negev%20%7C%20Bratatat%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "XM1014 | Red Python",
//                    "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Red%20Python%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "PP-Bizon | Blue Streak",
//                    "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Blue%20Streak%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P90 | Virus",
//                    "https://api.steamapis.com/image/item/730/P90%20%7C%20Virus%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP7 | Ocean Foam",
//                    "https://api.steamapis.com/image/item/730/MP7%20%7C%20Ocean%20Foam%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Glock-18 | Steel Disruption",
//                    "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Steel%20Disruption%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Desert Eagle | Crimson Web",
//                    "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Crimson%20Web%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AUG | Bengal Tiger",
//                    "https://api.steamapis.com/image/item/730/AUG%20%7C%20Bengal%20Tiger%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Nova | Bloomstick",
//                    "https://api.steamapis.com/image/item/730/Nova%20%7C%20Bloomstick%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | Corticera",
//                    "https://api.steamapis.com/image/item/730/AWP%20%7C%20Corticera%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P2000 | Corticera",
//                    "https://api.steamapis.com/image/item/730/P2000%20%7C%20Corticera%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A4 | Bullet Rain",
//                    "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Bullet%20Rain%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Jaguar",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Jaguar%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Falchion%20Case",
//            name = "Falchion Case",
//            releaseDate = "26.05.2015",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Falchion%20Case",
//            description =
//            "The Falchion Case is a weapon case released on the May 26, 2015 update, alongside with Operation Bloodhound as an exclusive drop to pass holders. After Operation Bloodhound came to a close, the case was available to drop for all players. This case also introduces the case-exclusive Falchion Knife which can be unboxed at a very low chance.",
//            weapons = listOf(
//                Weapon(
//                    "Galil AR | Rocket Pop",
//                    "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Rocket%20Pop%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Glock-18 | Bunsen Burner",
//                    "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Bunsen%20Burner%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Nova | Ranger",
//                    "https://api.steamapis.com/image/item/730/Nova%20%7C%20Ranger%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P90 | Elite Build",
//                    "https://api.steamapis.com/image/item/730/P90%20%7C%20Elite%20Build%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "UMP-45 | Riot",
//                    "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Riot%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "USP-S | Torque",
//                    "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Torque%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "FAMAS | Neural Net",
//                    "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Neural%20Net%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A4 | Evil Daimyo",
//                    "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Evil%20Daimyo%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP9 | Ruby Poison Dart",
//                    "https://api.steamapis.com/image/item/730/MP9%20%7C%20Ruby%20Poison%20Dart%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Negev | Loudmouth",
//                    "https://api.steamapis.com/image/item/730/Negev%20%7C%20Loudmouth%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P2000 | Handgun",
//                    "https://api.steamapis.com/image/item/730/P2000%20%7C%20Handgun%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "CZ75-Auto | Yellow Jacket",
//                    "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Yellow%20Jacket%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP7 | Nemesis",
//                    "https://api.steamapis.com/image/item/730/MP7%20%7C%20Nemesis%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SG 553 | Cyrex",
//                    "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Cyrex%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Aquamarine Revenge",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Aquamarine%20Revenge%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | Hyper Beast",
//                    "https://api.steamapis.com/image/item/730/AWP%20%7C%20Hyper%20Beast%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Fracture%20Case",
//            name = "Fracture Case",
//            releaseDate = "07.08.2020",
//            dropStatus = "Active",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Fracture%20Case",
//            description =
//            "The Fracture Case is a weapon case featuring 17 community-designed weapon finishes and along with the Shattered Web Case knives (Paracord Knife, Survival Knife, Skeleton Knife, Nomad Knife), in the standard knife finishes.",
//            weapons = listOf(
//                Weapon(
//                    "Negev | Ultralight",
//                    "https://api.steamapis.com/image/item/730/Negev%20%7C%20Ultralight%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P2000 | Gnarled",
//                    "https://api.steamapis.com/image/item/730/P2000%20%7C%20Gnarled%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SG 553 | Ol' Rusty",
//                    "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Ol'%20Rusty%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SSG 08 | Mainframe 001",
//                    "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Mainframe%20001%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P250 | Cassette",
//                    "https://api.steamapis.com/image/item/730/P250%20%7C%20Cassette%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P90 | Freight",
//                    "https://api.steamapis.com/image/item/730/P90%20%7C%20Freight%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "PP-Bizon | Runic",
//                    "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Runic%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAG-7 | Monster Call",
//                    "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Monster%20Call%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Tec-9 | Brother",
//                    "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Brother%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAC-10 | Allure",
//                    "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Allure%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Galil AR | Connexion",
//                    "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Connexion%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP5-SD | Kitbash",
//                    "https://api.steamapis.com/image/item/730/MP5-SD%20%7C%20Kitbash%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A4 | Tooth Fairy",
//                    "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Tooth%20Fairy%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Glock-18 | Vogue",
//                    "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Vogue%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "XM1014 | Entombed",
//                    "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Entombed%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Desert Eagle | Printstream",
//                    "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Printstream%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Legion of Anubis",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Legion%20of%20Anubis%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Gamma%20Case",
//            name = "Gamma Case",
//            releaseDate = "15.06.2016",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Gamma%20Case",
//            description =
//            "The Gamma Case is a weapon case consisting of community weapons and new knife finishes released as part of the June 15, 2016 update. It requires a Gamma Case Key to be opened. On Glock-18 Wasteland Rebel, the numbers 7355608 are hidden on the back of the gun. Glock-18 Wasteland Rebel contains many hidden smaller painted messages and symbols that can be seen at a very low weapon condition, which are covered by the Kill Them All graffiti on higher conditions.",
//            weapons = listOf(
//                Weapon(
//                    "Five-SeveN | Violent Daimyo",
//                    "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Violent%20Daimyo%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAC-10 | Carnivore",
//                    "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Carnivore%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Nova | Exo",
//                    "https://api.steamapis.com/image/item/730/Nova%20%7C%20Exo%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P250 | Iron Clad",
//                    "https://api.steamapis.com/image/item/730/P250%20%7C%20Iron%20Clad%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "PP-Bizon | Harvester",
//                    "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Harvester%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SG 553 | Aerial",
//                    "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Aerial%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Tec-9 | Ice Cap",
//                    "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Ice%20Cap%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AUG | Aristocrat",
//                    "https://api.steamapis.com/image/item/730/AUG%20%7C%20Aristocrat%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | Phobos",
//                    "https://api.steamapis.com/image/item/730/AWP%20%7C%20Phobos%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P90 | Chopper",
//                    "https://api.steamapis.com/image/item/730/P90%20%7C%20Chopper%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "R8 Revolver | Reboot",
//                    "https://api.steamapis.com/image/item/730/R8%20Revolver%20%7C%20Reboot%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Sawed-Off | Limelight",
//                    "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Limelight%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A4 | Desolate Space",
//                    "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Desolate%20Space%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P2000 | Imperial Dragon",
//                    "https://api.steamapis.com/image/item/730/P2000%20%7C%20Imperial%20Dragon%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SCAR-20 | Bloodsport",
//                    "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Bloodsport%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Glock-18 | Wasteland Rebel",
//                    "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Wasteland%20Rebel%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A1-S | Mecha Industries",
//                    "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Mecha%20Industries%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Gamma%202%20Case",
//            name = "Gamma 2 Case",
//            releaseDate = "18.08.2016",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Gamma%202%20Case",
//            description =
//            "The Gamma 2 Case is a weapon case consisting of community weapons and new knife finishes released as part of the August 18, 2016 update. It requires a Gamma Case Key to be opened.",
//            weapons = listOf(
//                Weapon(
//                    "CZ75-Auto | Imprint",
//                    "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Imprint%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Five-SeveN | Scumbria",
//                    "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Scumbria%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "G3SG1 | Ventilator",
//                    "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Ventilator%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Negev | Dazzle",
//                    "https://api.steamapis.com/image/item/730/Negev%20%7C%20Dazzle%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P90 | Grim",
//                    "https://api.steamapis.com/image/item/730/P90%20%7C%20Grim%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "UMP-45 | Briefing",
//                    "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Briefing%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "XM1014 | Slipstream",
//                    "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Slipstream%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Desert Eagle | Directive",
//                    "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Directive%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Glock-18 | Weasel",
//                    "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Weasel%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAG-7 | Petroglyph",
//                    "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Petroglyph%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SCAR-20 | Powercore",
//                    "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Powercore%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SG 553 | Triarch",
//                    "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Triarch%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AUG | Syd Mead",
//                    "https://api.steamapis.com/image/item/730/AUG%20%7C%20Syd%20Mead%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP9 | Airlock",
//                    "https://api.steamapis.com/image/item/730/MP9%20%7C%20Airlock%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Tec-9 | Fuel Injector",
//                    "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Fuel%20Injector%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Neon Revolution",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Neon%20Revolution%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "FAMAS | Roll Cage",
//                    "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Roll%20Cage%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Glove%20Case",
//            name = "Glove Case",
//            releaseDate = "28.11.2016",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Glove%20Case",
//            description =
//            "The Glove Case is a weapon case consisting of community weapons and new gloves released as part of the November 28, 2016 update. It requires a Glove Case Key to be opened.",
//            weapons = listOf(
//                Weapon(
//                    "CZ75-Auto | Polymer",
//                    "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Polymer%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Glock-18 | Ironwork",
//                    "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Ironwork%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP7 | Cirrus",
//                    "https://api.steamapis.com/image/item/730/MP7%20%7C%20Cirrus%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Galil AR | Black Sand",
//                    "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Black%20Sand%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP9 | Sand Scale",
//                    "https://api.steamapis.com/image/item/730/MP9%20%7C%20Sand%20Scale%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAG-7 | Sonar",
//                    "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Sonar%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P2000 | Turf",
//                    "https://api.steamapis.com/image/item/730/P2000%20%7C%20Turf%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Dual Berettas | Royal Consorts",
//                    "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Royal%20Consorts%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "G3SG1 | Stinger",
//                    "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Stinger%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A1-S | Flashback",
//                    "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Flashback%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Nova | Gila",
//                    "https://api.steamapis.com/image/item/730/Nova%20%7C%20Gila%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "USP-S | Cyrex",
//                    "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Cyrex%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "FAMAS | Mecha Industries",
//                    "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Mecha%20Industries%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P90 | Shallow Grave",
//                    "https://api.steamapis.com/image/item/730/P90%20%7C%20Shallow%20Grave%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Sawed-Off | Wasteland Princess",
//                    "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Wasteland%20Princess%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SSG 08 | Dragonfire",
//                    "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Dragonfire%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A4 | Buzz Kill",
//                    "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Buzz%20Kill%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Horizon%20Case",
//            name = "Horizon Case",
//            releaseDate = "02.08.2018",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Horizon%20Case",
//            description =
//            "The Horizon Case is a weapon case featuring 17 community-designed weapon finishes and along Ursus Knife, Navaja Knife, Stiletto Knife, Talon Knife. Released as part of the August 3, 2018 update. It requires a Horizon Case Key to be opened.",
//            weapons = listOf(
//                Weapon(
//                    "AUG | Amber Slipstream",
//                    "https://api.steamapis.com/image/item/730/AUG%20%7C%20Amber%20Slipstream%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Dual Berettas | Shred",
//                    "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Shred%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Glock-18 | Warhawk",
//                    "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Warhawk%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP9 | Capillary",
//                    "https://api.steamapis.com/image/item/730/MP9%20%7C%20Capillary%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P90 | Traction",
//                    "https://api.steamapis.com/image/item/730/P90%20%7C%20Traction%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "R8 Revolver | Survivalist",
//                    "https://api.steamapis.com/image/item/730/R8%20Revolver%20%7C%20Survivalist%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Tec-9 | Snek-9",
//                    "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Snek-9%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "CZ75-Auto | Eco",
//                    "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Eco%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "G3SG1 | High Seas",
//                    "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20High%20Seas%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Nova | Toy Soldier",
//                    "https://api.steamapis.com/image/item/730/Nova%20%7C%20Toy%20Soldier%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | PAW",
//                    "https://api.steamapis.com/image/item/730/AWP%20%7C%20PAW%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP7 | Powercore",
//                    "https://api.steamapis.com/image/item/730/MP7%20%7C%20Powercore%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A1-S | Nightmare",
//                    "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Nightmare%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Sawed-Off | Devourer",
//                    "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Devourer%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "FAMAS | Eye of Athena",
//                    "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Eye%20of%20Athena%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Neon Rider",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Neon%20Rider%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Desert Eagle | Code Red",
//                    "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Code%20Red%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Huntsman%20Weapon%20Case",
//            name = "Huntsman Weapon Case",
//            releaseDate = "01.05.2014",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Huntsman%20Weapon%20Case",
//            description =
//            "The Huntsman Weapon Case is a weapon case consisting of 15 community-made weapon skins released as part of the May 1, 2014 update that also introduced the Bank Collection. It requires a Huntsman Weapon Case Key to be opened. There is a small chance to unbox a Huntsman Knife when opening the case. On June 11th, 2014, the Huntsman Weapon Case was updated, along with the Community Sticker Capsule 1 due to a copyright infringement[1][2][3]. The M4A4 | Howl and several other weapon skins were removed and 6 new weapon skins were added.",
//            weapons = listOf(
//                Weapon(
//                    "Tec-9 | Isaac",
//                    "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Isaac%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SSG 08 | Slashed",
//                    "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Slashed%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Galil AR | Kami",
//                    "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Kami%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "CZ75-Auto | Twist",
//                    "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Twist%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P90 | Module",
//                    "https://api.steamapis.com/image/item/730/P90%20%7C%20Module%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P2000 | Pulse",
//                    "https://api.steamapis.com/image/item/730/P2000%20%7C%20Pulse%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AUG | Torque",
//                    "https://api.steamapis.com/image/item/730/AUG%20%7C%20Torque%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "PP-Bizon | Antique",
//                    "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Antique%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "XM1014 | Heaven Guard",
//                    "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Heaven%20Guard%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAC-10 | Tatter",
//                    "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Tatter%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A1-S | Atomic Alloy",
//                    "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Atomic%20Alloy%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SCAR-20 | Cyrex",
//                    "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Cyrex%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "USP-S | Caiman",
//                    "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Caiman%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Vulcan",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Vulcan%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A4 | Desert-Strike",
//                    "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Desert-Strike%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Operation%20Bravo%20Case",
//            name = "Operation Bravo Case",
//            releaseDate = "19.09.2013",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Operation%20Bravo%20Case",
//            description =
//            "The Operation Bravo Case is a crate containing 15 Valve-made weapon skins that was released during September 19, 2013. Since the release of Operation Bravo, any player could obtain this case. However, holders of the Operation Bravo pass had a higher chance to receive the case as a drop. Like the CSGO Weapon Case, the standard weapon case key can be used to open this case. Since the end of Operation Bravo, this case drops very rarely.",
//            weapons = listOf(
//                Weapon(
//                    "SG 553 | Wave Spray",
//                    "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Wave%20Spray%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Dual Berettas | Black Limba",
//                    "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Black%20Limba%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Nova | Tempest",
//                    "https://api.steamapis.com/image/item/730/Nova%20%7C%20Tempest%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Galil AR | Shattered",
//                    "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Shattered%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "UMP-45 | Bone Pile",
//                    "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Bone%20Pile%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "G3SG1 | Demeter",
//                    "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Demeter%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "USP-S | Overgrowth",
//                    "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Overgrowth%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A4 | Zirka",
//                    "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Zirka%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAC-10 | Graven",
//                    "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Graven%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A1-S | Bright Water",
//                    "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Bright%20Water%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P90 | Emerald Dragon",
//                    "https://api.steamapis.com/image/item/730/P90%20%7C%20Emerald%20Dragon%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P2000 | Ocean Foam",
//                    "https://api.steamapis.com/image/item/730/P2000%20%7C%20Ocean%20Foam%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | Graphite",
//                    "https://api.steamapis.com/image/item/730/AWP%20%7C%20Graphite%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Fire Serpent",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Fire%20Serpent%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Desert Eagle | Golden Koi",
//                    "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Golden%20Koi%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Operation%20Breakout%20Weapon%20Case",
//            name = "Operation Breakout Weapon Case",
//            releaseDate = "01.07.2014",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Operation%20Breakout%20Weapon%20Case",
//            description =
//            "The Operation Breakout Case is a weapon case consisting of 14 community-created weapon skins released as part of Operation Breakout with the July 1, 2014 update. Like the Operation Phoenix Weapon Case during Operation Phoenix, Operation Breakout Coin holders received this case. Once the operation ended on October 2, 2014, the weapon case became available for all CS:GO players.",
//            weapons = listOf(
//                Weapon(
//                    "MP7 | Urban Hazard",
//                    "https://api.steamapis.com/image/item/730/MP7%20%7C%20Urban%20Hazard%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Negev | Desert-Strike",
//                    "https://api.steamapis.com/image/item/730/Negev%20%7C%20Desert-Strike%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P2000 | Ivory",
//                    "https://api.steamapis.com/image/item/730/P2000%20%7C%20Ivory%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SSG 08 | Abyss",
//                    "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Abyss%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "UMP-45 | Labyrinth",
//                    "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Labyrinth%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "PP-Bizon | Osiris",
//                    "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Osiris%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "CZ75-Auto | Tigris",
//                    "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Tigris%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Nova | Koi",
//                    "https://api.steamapis.com/image/item/730/Nova%20%7C%20Koi%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P250 | Supernova",
//                    "https://api.steamapis.com/image/item/730/P250%20%7C%20Supernova%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Desert Eagle | Conspiracy",
//                    "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Conspiracy%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Five-SeveN | Fowl Play",
//                    "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Fowl%20Play%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Glock-18 | Water Elemental",
//                    "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Water%20Elemental%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P90 | Asiimov",
//                    "https://api.steamapis.com/image/item/730/P90%20%7C%20Asiimov%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A1-S | Cyrex",
//                    "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Cyrex%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Operation%20Broken%20Fang%20Case",
//            name = "Operation Broken Fang Case",
//            releaseDate = "04.12.2020",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Operation%20Broken%20Fang%20Case",
//            description =
//            "The Broken Fang Case is a case that contains 17 community-made weapon skins released as part of Operation Broken Fang. There is a very small chance to unbox a pair of gloves.",
//            weapons = listOf(
//                Weapon(
//                    "CZ75-Auto | Vendetta",
//                    "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Vendetta%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P90 | Cocoa Rampage",
//                    "https://api.steamapis.com/image/item/730/P90%20%7C%20Cocoa%20Rampage%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "G3SG1 | Digital Mesh",
//                    "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Digital%20Mesh%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Galil AR | Vandal",
//                    "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Vandal%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P250 | Contaminant",
//                    "https://api.steamapis.com/image/item/730/P250%20%7C%20Contaminant%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M249 | Deep Relief",
//                    "https://api.steamapis.com/image/item/730/M249%20%7C%20Deep%20Relief%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP5-SD | Condition Zero",
//                    "https://api.steamapis.com/image/item/730/MP5-SD%20%7C%20Condition%20Zero%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | Exoskeleton",
//                    "https://api.steamapis.com/image/item/730/AWP%20%7C%20Exoskeleton%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Dual Berettas | Dezastre",
//                    "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Dezastre%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Nova | Clear Polymer",
//                    "https://api.steamapis.com/image/item/730/Nova%20%7C%20Clear%20Polymer%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SSG 08 | Parallax",
//                    "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Parallax%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "UMP-45 | Gold Bismuth",
//                    "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Gold%20Bismuth%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Five-SeveN | Fairy Tale",
//                    "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Fairy%20Tale%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A4 | Cyber Security",
//                    "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Cyber%20Security%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "USP-S | Monster Mashup",
//                    "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Monster%20Mashup%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A1-S | Printstream",
//                    "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Printstream%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Glock-18 | Neo-Noir",
//                    "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Neo-Noir%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Operation%20Hydra%20Case",
//            name = "Operation Hydra Case",
//            releaseDate = "23.05.2017",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Operation%20Hydra%20Case",
//            description =
//            "The Operation Hydra Case is a weapon case of community created weapon skins AWP Oni Taiji is likely named after the Japanese phrase 鬼退治 (おに　たいじ, Oni Taiji), which means evil spirit extermination. As each case Key in-game is worth $2.49, this is the only case where the Key only costs around $1.and new gloves released in the May 23, 2017 update, alongside with Operation Hydra as an exclusive drop to pass holders. It requires a Operation Hydra Case Key to be opened.",
//            weapons = listOf(
//                Weapon(
//                    "USP-S | Blueprint",
//                    "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Blueprint%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "FAMAS | Macabre",
//                    "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Macabre%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A1-S | Briefing",
//                    "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Briefing%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAC-10 | Aloha",
//                    "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Aloha%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAG-7 | Hard Water",
//                    "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Hard%20Water%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Tec-9 | Cut Out",
//                    "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Cut%20Out%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "UMP-45 | Metal Flowers",
//                    "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Metal%20Flowers%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Orbit Mk01",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Orbit%20Mk01%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P2000 | Woodsman",
//                    "https://api.steamapis.com/image/item/730/P2000%20%7C%20Woodsman%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P250 | Red Rock",
//                    "https://api.steamapis.com/image/item/730/P250%20%7C%20Red%20Rock%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P90 | Death Grip",
//                    "https://api.steamapis.com/image/item/730/P90%20%7C%20Death%20Grip%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SSG 08 | Death's Head",
//                    "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Death's%20Head%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Dual Berettas | Cobra Strike",
//                    "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Cobra%20Strike%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Galil AR | Sugar Rush",
//                    "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Sugar%20Rush%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A4 | Hellfire",
//                    "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Hellfire%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Five-SeveN | Hyper Beast",
//                    "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Hyper%20Beast%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | Oni Taiji",
//                    "https://api.steamapis.com/image/item/730/AWP%20%7C%20Oni%20Taiji%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Operation%20Phoenix%20Weapon%20Case",
//            name = "Operation Phoenix Weapon Case",
//            releaseDate = "20.02.2014",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Operation%20Phoenix%20Weapon%20Case",
//            description =
//            "The Operation Phoenix Case is a weapon case of 13 community-created weapon skins released on February 20, 2014 as part of Operation Phoenix. The chance for the case to drop was originally exclusive to pass owners. As of the June 11, 2014 update, the weapon case became available as a drop for all players.",
//            weapons = listOf(
//                Weapon(
//                    "MP-45 | Corporal",
//                    "https://api.steamapis.com/image/item/730/MP-45%20%7C%20Corporal%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Negev | Terrain",
//                    "https://api.steamapis.com/image/item/730/Negev%20%7C%20Terrain%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Tec-9 | Sandstorm",
//                    "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Sandstorm%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAG-7 | Heaven Guard",
//                    "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Heaven%20Guard%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAC-10 | Heat",
//                    "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Heat%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SG 553 | Pulse",
//                    "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Pulse%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "FAMAS | Sergeant",
//                    "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Sergeant%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "USP-S | Guardian",
//                    "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Guardian%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Redline",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Redline%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P90 | Trigon",
//                    "https://api.steamapis.com/image/item/730/P90%20%7C%20Trigon%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Nova | Antique",
//                    "https://api.steamapis.com/image/item/730/Nova%20%7C%20Antique%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | Asiimov",
//                    "https://api.steamapis.com/image/item/730/AWP%20%7C%20Asiimov%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AUG | Chameleon",
//                    "https://api.steamapis.com/image/item/730/AUG%20%7C%20Chameleon%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Operation%20Vanguard%20Weapon%20Case",
//            name = "Operation Vanguard Weapon Case",
//            releaseDate = "11.11.2014",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Operation%20Vanguard%20Weapon%20Case",
//            description =
//            "The Operation Vanguard Case is a weapon case consisting of 14 community-created weapon skins released as part of Operation Vanguard during the November 11, 2014 update. Like the previous operation cases, Operation Vanguard Coin holders receive exclusive case drops in addition to the normal timed drops during Operation Vanguard as well as the potential to receive a case as a mission drop.",
//            weapons = listOf(
//                Weapon(
//                    "G3SG1 | Murky",
//                    "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Murky%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAG-7 | Firestarter",
//                    "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Firestarter%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP9 | Dart",
//                    "https://api.steamapis.com/image/item/730/MP9%20%7C%20Dart%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Five-SeveN | Urban Hazard",
//                    "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Urban%20Hazard%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "UMP-45 | Delusion",
//                    "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Delusion%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Glock-18 | Grinder",
//                    "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Grinder%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A1-S | Basilisk",
//                    "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Basilisk%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A4 | Griffin",
//                    "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Griffin%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Sawed-Off | Highwayman",
//                    "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Highwayman%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P250 | Cartel",
//                    "https://api.steamapis.com/image/item/730/P250%20%7C%20Cartel%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SCAR-20 | Cardiac",
//                    "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Cardiac%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "XM1014 | Tranquility",
//                    "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Tranquility%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Wasteland Rebel",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Wasteland%20Rebel%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P2000 | Fire Elemental",
//                    "https://api.steamapis.com/image/item/730/P2000%20%7C%20Fire%20Elemental%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Operation%20Wildfire%20Case",
//            name = "Operation Wildfire Case",
//            releaseDate = "17.02.2016",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Operation%20Wildfire%20Case",
//            description =
//            "The Operation Wildfire Case is a weapon case released in the February 17, 2016 update, alongside with Operation Wildfire as an exclusive drop to pass holders. This case also introduces the case-exclusive Bowie Knife which can be awarded at a very low chance. Due to the way Valve has re-sized the Case Hardened texture for the Bowie Knife, it is now much easier to get an almost full blue gem Case Hardened Bowie knife.",
//            weapons = listOf(
//                Weapon(
//                    "PP-Bizon | Photic Zone",
//                    "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Photic%20Zone%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Dual Berettas | Cartel",
//                    "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Cartel%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAC-10 | Lapis Gator",
//                    "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Lapis%20Gator%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SSG 08 | Necropos",
//                    "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Necropos%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Tec-9 | Jambiya",
//                    "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Jambiya%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "USP-S | Lead Conduit",
//                    "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Lead%20Conduit%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "FAMAS | Valence",
//                    "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Valence%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Five-SeveN | Triumvirate",
//                    "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Triumvirate%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Glock-18 | Royal Legion",
//                    "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Royal%20Legion%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAG-7 | Praetorian",
//                    "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Praetorian%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP7 | Impire",
//                    "https://api.steamapis.com/image/item/730/MP7%20%7C%20Impire%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | Elite Build",
//                    "https://api.steamapis.com/image/item/730/AWP%20%7C%20Elite%20Build%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Desert Eagle | Kumicho Dragon",
//                    "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Kumicho%20Dragon%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Nova | Hyper Beast",
//                    "https://api.steamapis.com/image/item/730/Nova%20%7C%20Hyper%20Beast%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Fuel Injector",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Fuel%20Injector%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A4 | The Battlestar",
//                    "https://api.steamapis.com/image/item/730/M4A4%20%7C%20The%20Battlestar%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Prisma%20Case",
//            name = "Prisma Case",
//            releaseDate = "13.03.2019",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Prisma%20Case",
//            description =
//            "The Prisma Case is a weapon case featuring 17 community-designed weapon finishes and along with Ursus Knife, Navaja Knife, Stiletto Knife, and Talon Knife, in Chroma finishes. The case was released as part of the March 13, 2019 update. It requires a Prisma Case Key to be opened.",
//            weapons = listOf(
//                Weapon(
//                    "FAMAS | Crypsis",
//                    "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Crypsis%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Uncharted",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Uncharted%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAC-10 | Whitefish",
//                    "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Whitefish%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Galil AR | Akoben",
//                    "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Akoben%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP7 | Mischief",
//                    "https://api.steamapis.com/image/item/730/MP7%20%7C%20Mischief%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P250 | Verdigris",
//                    "https://api.steamapis.com/image/item/730/P250%20%7C%20Verdigris%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P90 | Off World",
//                    "https://api.steamapis.com/image/item/730/P90%20%7C%20Off%20World%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | Atheris",
//                    "https://api.steamapis.com/image/item/730/AWP%20%7C%20Atheris%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Tec-9 | Bamboozle",
//                    "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Bamboozle%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Desert Eagle | Light Rail",
//                    "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Light%20Rail%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP5-SD | Gauss",
//                    "https://api.steamapis.com/image/item/730/MP5-SD%20%7C%20Gauss%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "UMP-45 | Moonrise",
//                    "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Moonrise%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "R8 Revolver | Skull Crusher",
//                    "https://api.steamapis.com/image/item/730/R8%20Revolver%20%7C%20Skull%20Crusher%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AUG | Momentum",
//                    "https://api.steamapis.com/image/item/730/AUG%20%7C%20Momentum%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "XM1014 | Incinegator",
//                    "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Incinegator%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Five-SeveN | Angry Mob",
//                    "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Angry%20Mob%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A4 | The Emperor",
//                    "https://api.steamapis.com/image/item/730/M4A4%20%7C%20The%20Emperor%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Prisma%202%20Case",
//            name = "Prisma 2 Case",
//            releaseDate = "01.04.2020",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Prisma%202%20Case",
//            description =
//            "Case Prism 2 is a container with weapon skins in Counter-Strike: Global Offensive. To open a special key from the case Prism 2.",
//            weapons = listOf(
//                Weapon(
//                    "AUG | Tom Cat",
//                    "https://api.steamapis.com/image/item/730/AUG%20%7C%20Tom%20Cat%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | Capillary",
//                    "https://api.steamapis.com/image/item/730/AWP%20%7C%20Capillary%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "CZ75-Auto | Distressed",
//                    "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Distressed%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Desert Eagle | Blue Ply",
//                    "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Blue%20Ply%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP5-SD | Desert Strike",
//                    "https://api.steamapis.com/image/item/730/MP5-SD%20%7C%20Desert%20Strike%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Negev | Prototype",
//                    "https://api.steamapis.com/image/item/730/Negev%20%7C%20Prototype%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "R8 Revolver | Bone Forged",
//                    "https://api.steamapis.com/image/item/730/R8%20Revolver%20%7C%20Bone%20Forged%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P2000 | Acid Etched",
//                    "https://api.steamapis.com/image/item/730/P2000%20%7C%20Acid%20Etched%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Sawed-Off | Apocalypto",
//                    "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Apocalypto%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SCAR-20 | Enforcer",
//                    "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Enforcer%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SG 553 | Darkwing",
//                    "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Darkwing%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SSG 08 | Fever Dream",
//                    "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Fever%20Dream%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Phantom Disruptor",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Phantom%20Disruptor%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAC-10 | Disco Tech",
//                    "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Disco%20Tech%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAG-7 | Justice",
//                    "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Justice%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A1-S | Player Two",
//                    "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Player%20Two%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Glock-18 | Bullet Queen",
//                    "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Bullet%20Queen%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Revolver%20Case",
//            name = "Revolver Case",
//            releaseDate = "08.12.2015",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Revolver%20Case",
//            description =
//            "The Revolver Case is a weapon case consisting of 16 community-created weapon skins released as part of the December 8, 2015 update. The Revolver Case was the first case to contain skins for the R8 Revolver.",
//            weapons = listOf(
//                Weapon(
//                    "R8 Revolver | Crimson Web",
//                    "https://api.steamapis.com/image/item/730/R8%20Revolver%20%7C%20Crimson%20Web%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AUG | Ricochet",
//                    "https://api.steamapis.com/image/item/730/AUG%20%7C%20Ricochet%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Desert Eagle | Corinthian",
//                    "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Corinthian%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P2000 | Imperial",
//                    "https://api.steamapis.com/image/item/730/P2000%20%7C%20Imperial%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Sawed-Off | Yorick",
//                    "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Yorick%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SCAR-20 | Outbreak",
//                    "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Outbreak%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "PP-Bizon | Fuel Rod",
//                    "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Fuel%20Rod%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Five-SeveN | Retrobution",
//                    "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Retrobution%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Negev | Power Loader",
//                    "https://api.steamapis.com/image/item/730/Negev%20%7C%20Power%20Loader%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SG 553 | Tiger Moth",
//                    "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Tiger%20Moth%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Tec-9 | Avalanche",
//                    "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Avalanche%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "XM1014 | Teclu Burner",
//                    "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Teclu%20Burner%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Point Disarray",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Point%20Disarray%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "G3SG1 | The Executioner",
//                    "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20The%20Executioner%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P90 | Shapewood",
//                    "https://api.steamapis.com/image/item/730/P90%20%7C%20Shapewood%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A4 | Royal Paladin",
//                    "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Royal%20Paladin%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "R8 Revolver | Fade",
//                    "https://api.steamapis.com/image/item/730/R8%20Revolver%20%7C%20Fade%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Shadow%20Case",
//            name = "Shadow Case",
//            releaseDate = "17.09.2015",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Shadow%20Case",
//            description =
//            "The Shadow Case is a weapon case consisting of 16 community-made weapon skins released as part of the September 18, 2015 update. It requires a Shadow Case Key to be opened. There is a tiny chance to unbox a pair of Shadow Daggers.",
//            weapons = listOf(
//                Weapon(
//                    "Dual Berettas | Dualing Dragons",
//                    "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Dualing%20Dragons%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "FAMAS | Survivor Z",
//                    "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Survivor%20Z%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Glock-18 | Wraiths",
//                    "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Wraiths%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAC-10 | Rangeen",
//                    "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Rangeen%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAG-7 | Cobalt Core",
//                    "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Cobalt%20Core%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SCAR-20 | Green Marine",
//                    "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Green%20Marine%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "XM1014 | Scumbria",
//                    "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Scumbria%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Galil AR | Stone Cold",
//                    "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Stone%20Cold%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M249 | Nebula Crusader",
//                    "https://api.steamapis.com/image/item/730/M249%20%7C%20Nebula%20Crusader%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP7 | Special Delivery",
//                    "https://api.steamapis.com/image/item/730/MP7%20%7C%20Special%20Delivery%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P250 | Wingshot",
//                    "https://api.steamapis.com/image/item/730/P250%20%7C%20Wingshot%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Frontside Misty",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Frontside%20Misty%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "G3SG1 | Flux",
//                    "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Flux%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SSG 08 | Big Iron",
//                    "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Big%20Iron%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A1-S | Golden Coil",
//                    "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Golden%20Coil%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "USP-S | Kill Confirmed",
//                    "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Kill%20Confirmed%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Shattered%20Web%20Case",
//            name = "Shattered Web Case",
//            releaseDate = "18.11.2019",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Shattered%20Web%20Case",
//            description =
//            "The Shattered Web Cas`e is a case that contains 17 community-made weapon skins released as part of Operation Shattered Web. There is a very small chance to unbox the Nomad Knife, Skeleton Knife, Paracord Knife, and the Survival Knife each in 13 different finishes.",
//            weapons = listOf(
//                Weapon(
//                    "MP5-SD | Acid Wash",
//                    "https://api.steamapis.com/image/item/730/MP5-SD%20%7C%20Acid%20Wash%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Nova | Plume",
//                    "https://api.steamapis.com/image/item/730/Nova%20%7C%20Plume%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "G3SG1 | Black Sand",
//                    "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Black%20Sand%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "R8 Revolver | Memento",
//                    "https://api.steamapis.com/image/item/730/R8%20Revolver%20%7C%20Memento%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Dual Berettas | Balance",
//                    "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Balance%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SCAR-20 | Torn",
//                    "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Torn%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M249 | Warbird",
//                    "https://api.steamapis.com/image/item/730/M249%20%7C%20Warbird%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "PP-Bizon | Embargo",
//                    "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Embargo%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Rat Rod",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Rat%20Rod%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AUG | Arctic Wolf",
//                    "https://api.steamapis.com/image/item/730/AUG%20%7C%20Arctic%20Wolf%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP7 | Neon Ply",
//                    "https://api.steamapis.com/image/item/730/MP7%20%7C%20Neon%20Ply%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P2000 | Obsidian",
//                    "https://api.steamapis.com/image/item/730/P2000%20%7C%20Obsidian%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Tec-9 | Decimator",
//                    "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Decimator%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SG 553 | Colony IV",
//                    "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Colony%20IV%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SSG 08 | Bloodshot",
//                    "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Bloodshot%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | Containment Breach",
//                    "https://api.steamapis.com/image/item/730/AWP%20%7C%20Containment%20Breach%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAC-10 | Stalker",
//                    "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Stalker%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Snakebite%20Case",
//            name = "Snakebite Case",
//            releaseDate = "03.05.2021",
//            dropStatus = "Active",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://www.csgodatabase.com/images/containers/webp/Snakebite_Case.webp",
//            description =
//            "The Snakebite Case is a weapon case introduced on 03 May 2021 as part of the End of Broken Fang update. The weapon case contains CS:GO skins from The Snakebite Collection.",
//            weapons = listOf(
//                Weapon(
//                    "SG 553 | Heavy Metal",
//                    "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Heavy%20Metal%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Glock-18 | Clear Polymer",
//                    "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Clear%20Polymer%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M249 | O.S.I.P.R.",
//                    "https://api.steamapis.com/image/item/730/M249%20%7C%20O.S.I.P.R.%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "CZ75-Auto | Circaetus",
//                    "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Circaetus%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "UMP-45 | Oscillator",
//                    "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Oscillator%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "R8 Revolver | Junk Yard",
//                    "https://api.steamapis.com/image/item/730/R8%20Revolver%20%7C%20Junk%20Yard%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Nova | Windblown",
//                    "https://api.steamapis.com/image/item/730/Nova%20%7C%20Windblown%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P250 | Cyber Shell",
//                    "https://api.steamapis.com/image/item/730/P250%20%7C%20Cyber%20Shell%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Negev | dev_texture",
//                    "https://api.steamapis.com/image/item/730/Negev%20%7C%20dev_texture%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAC-10 | Button Masher",
//                    "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Button%20Masher%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Desert Eagle | Trigger Discipline",
//                    "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Trigger%20Discipline%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Slate",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Slate%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP9 | Food Chain",
//                    "https://api.steamapis.com/image/item/730/MP9%20%7C%20Food%20Chain%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "XM1014 | XOXO",
//                    "https://api.steamapis.com/image/item/730/XM1014%20%7C%20XOXO%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Galil AR | Chromatic Aberration",
//                    "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Chromatic%20Aberration%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "USP-S | The Traitor",
//                    "https://api.steamapis.com/image/item/730/USP-S%20%7C%20The%20Traitor%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A4 | In Living Color",
//                    "https://api.steamapis.com/image/item/730/M4A4%20%7C%20In%20Living%20Color%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Spectrum%20Case",
//            name = "Spectrum Case",
//            releaseDate = "15.03.2017",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Spectrum%20Case",
//            description =
//            "The Spectrum Case is a weapon case consisting of community weapons and new knife finishes for second generation of knives in Chroma Case released as part of the March 15, 2017 update. It requires a Spectrum Case Key to be opened.",
//            weapons = listOf(
//                Weapon(
//                    "PP-Bizon | Jungle Slipstream",
//                    "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Jungle%20Slipstream%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SCAR-20 | Blueprint",
//                    "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Blueprint%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Desert Eagle | Oxide Blaze",
//                    "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Oxide%20Blaze%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Five-SeveN | Capillary",
//                    "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Capillary%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP7 | Akoben",
//                    "https://api.steamapis.com/image/item/730/MP7%20%7C%20Akoben%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P250 | Ripple",
//                    "https://api.steamapis.com/image/item/730/P250%20%7C%20Ripple%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Sawed-Off | Zander",
//                    "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Zander%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Galil AR | Crimson Tsunami",
//                    "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Crimson%20Tsunami%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M249 | Emerald Poison Dart",
//                    "https://api.steamapis.com/image/item/730/M249%20%7C%20Emerald%20Poison%20Dart%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAC-10 | Last Dive",
//                    "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Last%20Dive%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "UMP-45 | Scaffold",
//                    "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Scaffold%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "XM1014 | Seasons",
//                    "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Seasons%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | Fever Dream",
//                    "https://api.steamapis.com/image/item/730/AWP%20%7C%20Fever%20Dream%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "CZ75-Auto | Xiangliu",
//                    "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Xiangliu%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A1-S | Decimator",
//                    "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Decimator%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Bloodsport",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Bloodsport%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "USP-S | Neo-Noir",
//                    "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Neo-Noir%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Spectrum%202%20Case",
//            name = "Spectrum 2 Case",
//            releaseDate = "14.09.2017",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Spectrum%202%20Case",
//            description =
//            "The Spectrum 2 Case is a weapon case consisting of community weapons and Chroma finishes for the later-added knives, released as part of the September 14, 2017 update. It requires a Spectrum 2 Case Key to be opened.",
//            weapons = listOf(
//                Weapon(
//                    "Sawed-Off | Morris",
//                    "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Morris%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AUG | Triqua",
//                    "https://api.steamapis.com/image/item/730/AUG%20%7C%20Triqua%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "G3SG1 | Hunter",
//                    "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Hunter%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Glock-18 | Off World",
//                    "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Off%20World%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAC-10 | Oceanic",
//                    "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Oceanic%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Tec-9 | Cracked Opal",
//                    "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Cracked%20Opal%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SCAR-20 | Jungle Slipstream",
//                    "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Jungle%20Slipstream%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP9 | Goo",
//                    "https://api.steamapis.com/image/item/730/MP9%20%7C%20Goo%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SG 553 | Phantom",
//                    "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Phantom%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "CZ75-Auto | Tacticat",
//                    "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Tacticat%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "UMP-45 | Exposure",
//                    "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Exposure%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "XM1014 | Ziggy",
//                    "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Ziggy%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "PP-Bizon | High Roller",
//                    "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20High%20Roller%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A1-S | Leaded Glass",
//                    "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Leaded%20Glass%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "R8 Revolver | Llama Cannon",
//                    "https://api.steamapis.com/image/item/730/R8%20Revolver%20%7C%20Llama%20Cannon%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | The Empress",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20The%20Empress%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P250 | See Ya Later",
//                    "https://api.steamapis.com/image/item/730/P250%20%7C%20See%20Ya%20Later%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Winter%20Offensive%20Weapon%20Case",
//            name = "Winter Offensive Weapon Case",
//            releaseDate = "18.12.2013",
//            dropStatus = "Inactive (Rare)",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Winter%20Offensive%20Weapon%20Case",
//            description =
//            "The Winter Offensive Weapon Case is a weapon case containing 12 community-created skins. It was released as part of the December 18, 2013 update and requires a Winter Offensive Case Key to open. Since the release of Operation Vanguard, this crate is very rarely dropped. It can also be bought in the Steam Community Market.",
//            weapons = listOf(
//                Weapon(
//                    "Galil AR | Sandstorm",
//                    "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Sandstorm%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Five-SeveN | Kami",
//                    "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Kami%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M249 | Magma",
//                    "https://api.steamapis.com/image/item/730/M249%20%7C%20Magma%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "PP-Bizon | Cobalt Halftone",
//                    "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Cobalt%20Halftone%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "FAMAS | Pulse",
//                    "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Pulse%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Dual Berettas | Marina",
//                    "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Marina%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP9 | Rose Iron",
//                    "https://api.steamapis.com/image/item/730/MP9%20%7C%20Rose%20Iron%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Nova | Rising Skull",
//                    "https://api.steamapis.com/image/item/730/Nova%20%7C%20Rising%20Skull%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A1-S | Guardian",
//                    "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Guardian%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P250 | Mehndi",
//                    "https://api.steamapis.com/image/item/730/P250%20%7C%20Mehndi%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | Redline",
//                    "https://api.steamapis.com/image/item/730/AWP%20%7C%20Redline%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A4 | Asiimov",
//                    "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Asiimov%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Sawed-Off | The Kraken",
//                    "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20The%20Kraken%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Dreams%20%26%20Nightmares%20Case",
//            name = "Dreams & Nightmares Case",
//            releaseDate = "20.01.2022",
//            dropStatus = "Active",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Dreams%20%26%20Nightmares%20Case",
//            description =
//            "The Dreams & Nightmares Case is a weapon case introduced on 20 January 2022 as part of the Dreams & Nightmares Case update. The weapon case contains CS:GO skins from The Dreams & Nightmares Collection. The case contains 17 skins, all of which were selected from the Dreams & Nightmares contest which ran from 22 July 2021 through to 21 October 2021. The rare special items in this case are the second generation Gamma Knives which first appeared in the Operation Riptide case.",
//            weapons = listOf(
//                Weapon(
//                    "Five-SeveN | Scrawl",
//                    "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Scrawl%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAC-10 | Ensnared",
//                    "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Ensnared%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAG-7 | Foresight",
//                    "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Foresight%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP5-SD | Necro Jr.",
//                    "https://api.steamapis.com/image/item/730/MP5-SD%20%7C%20Necro%20Jr.%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P2000 | Lifted Spirits",
//                    "https://api.steamapis.com/image/item/730/P2000%20%7C%20Lifted%20Spirits%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SCAR-20 | Poultrygeist",
//                    "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Poultrygeist%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Sawed-Off | Spirit Board",
//                    "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Spirit%20Board%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "PP-Bizon | Space Cat",
//                    "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Space%20Cat%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "G3SG1 | Dream Glade",
//                    "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Dream%20Glade%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A1-S | Night Terror",
//                    "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Night%20Terror%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "XM1014 | Zombie Offensive",
//                    "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Zombie%20Offensive%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "USP-S | Ticket to Hell",
//                    "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Ticket%20to%20Hell%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Dual Berettas | Melondrama",
//                    "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Melondrama%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "FAMAS | Rapid Eye Movement",
//                    "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Rapid%20Eye%20Movement%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP7 | Abyssal Apparition",
//                    "https://api.steamapis.com/image/item/730/MP7%20%7C%20Abyssal%20Apparition%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Nightwish",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Nightwish%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MP9 | Starlight Protector",
//                    "https://api.steamapis.com/image/item/730/MP9%20%7C%20Starlight%20Protector%20%28Factory%20New%29"
//                )
//            )
//        ),
//        CaseDbo(
//            caseAccess = "Recoil%20Case",
//            name = "Recoil Case",
//            releaseDate = "01.07.2022",
//            dropStatus = "Active",
//            lowestPrice = 00.00,
//            volume = 0,
//            medianPrice = 00.00,
//            imageUrl = "https://api.steamapis.com/image/item/730/Recoil%20Case",
//            description =
//            "The Recoil Case is a weapon case introduced on 01 July 2022 as part of the A New Cassssssse update. The weapon case contains CS:GO skins from The Recoil Collection. The rare special items in this case are the Broken Fang gloves which first appeared in the Operation Broken Fang case and also appear in the Snakebite case.",
//            weapons = listOf(
//                Weapon(
//                    "FAMAS | Meow 36",
//                    "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Meow%2036%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Galil AR | Destroyer",
//                    "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Destroyer%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M4A4 | Poly Mag",
//                    "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Poly%20Mag%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "MAC-10 | Monkeyflage",
//                    "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Monkeyflage%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Negev | Drop Me",
//                    "https://api.steamapis.com/image/item/730/Negev%20%7C%20Drop%20Me%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "UMP-45 | Roadblock",
//                    "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Roadblock%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Glock-18 | Winterized",
//                    "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Winterized%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "R8 Revolver | Crazy 8",
//                    "https://api.steamapis.com/image/item/730/R8%20Revolver%20%7C%20Crazy%208%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "M249 | Downtown",
//                    "https://api.steamapis.com/image/item/730/M249%20%7C%20Downtown%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "SG 553 | Dragon Tech",
//                    "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Dragon%20Tech%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P90 | Vent Rush",
//                    "https://api.steamapis.com/image/item/730/P90%20%7C%20Vent%20Rush%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Dual Berettas | Flora Carnivora",
//                    "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Flora%20Carnivora%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AK-47 | Ice Coaled",
//                    "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Ice%20Coaled%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "P250 | Visions",
//                    "https://api.steamapis.com/image/item/730/P250%20%7C%20Visions%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "Sawed-Off | Kiss♥Love",
//                    "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Kiss♥Love%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "USP-S | Printstream",
//                    "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Printstream%20%28Factory%20New%29"
//                ),
//                Weapon(
//                    "AWP | Chromatic Aberration",
//                    "AWP%20%7C%20Chromatic%20Aberration%20%28Factory%20New%29"
//                )
//            )
//        )
//    )


}