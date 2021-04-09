package core

import domain.repository.Repository
import data.database.CaseDatabase
import domain.model.CaseDto
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class Server {

    private val repository = Repository()

    private fun insertData() {
        CaseDatabase.insert {
            it[caseAccess] = "Chroma%20Case"
            it[name] = "Chroma Case"
            it[releaseDate] = "08.01.2015"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 64.23
            it[volume] = 3803
            it[medianPrice] = 62.54
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Chroma%20Case"
            it[description] =
                "The Chroma Case is a weapon case consisting of 14 community-desgined weapon skins released as part of the January 8, 2015 update. It requires a Chroma Case Key to be opened. The Chroma Case also has six exclusive community created knife finishes: Damascus Steel, Doppler, Marble Fade, Tiger Tooth, Rust Coat, and Ultraviolet. The Spectrum Case and Spectrum 2 Case includes these Chroma finishes on the Huntsman Knife, Butterfly Knife, Falchion Knife, Shadow Daggers and the Bowie Knife. The Prisma Case contains these Chroma finishes on the Navaja Knife, Stiletto Knife, Talon Knife, and the Ursus Knife."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Chroma%202%20Case"
            it[name] = "Chroma 2 Case"
            it[releaseDate] = "15.04.2015"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Chroma%202%20Case"
            it[description] =
                "The Chroma 2 Case is a weapon case consisting of 15 community-made weapon skins released as part of the April 15, 2015 update. It requires a Chroma 2 Case Key to be opened."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Chroma%203%20Case"
            it[name] = "Chroma 3 Case"
            it[releaseDate] = "20.04.2016"
            it[dropStatus] = "Active (Non-Prime)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Chroma%203%20Case"
            it[description] =
                "The Chroma 3 Case is a weapon case consisting of community weapons released as part of the April 27, 2016 update. It requires a Chroma 3 Case Key to be opened."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Clutch%20Case"
            it[name] = "Clutch Case"
            it[releaseDate] = "15.02.2018"
            it[dropStatus] = "Active (Prime)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Clutch%20Case"
            it[description] =
                "The Clutch Case is a weapon case featuring 17 community-designed weapon finishes and 24 new glove finishes. Released as part of the February 15, 2018 update. It requires a Clutch Case Key to be opened."
        }
        CaseDatabase.insert {
            it[caseAccess] = "CS%3AGO%20Weapon%20Case"
            it[name] = "CS:GO Weapon Case"
            it[releaseDate] = "14.08.2013"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/CS%3AGO%20Weapon%20Case"
            it[description] =
                "The CS:GO Weapon Case is the first series of Weapon Cases introduced in Counter-Strike: Global Offensive and contains 9 Valve-made finishes during the August 14, 2013 Arms Deal update. The Weapon Case requires a standard CS:GO Case Key to be opened. Since the release of Weapon Case 2, this crate is very rarely dropped."
        }
        CaseDatabase.insert {
            it[caseAccess] = "CS%3AGO%20Weapon%20Case%202"
            it[name] = "CS:GO Weapon Case 2"
            it[releaseDate] = "08.11.2013"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/CS%3AGO%20Weapon%20Case%202"
            it[description] =
                "The CSGO Weapon Case 2 was introduced to Counter-Strike: Global Offensive as part of the November 6, 2013 update, switching the CSGO Weapon Case to a rare drop. The standard CSGO Case Key can be used to open this case. Since the release of CSGO Weapon Case 3, this case is a rare drop."
        }
        CaseDatabase.insert {
            it[caseAccess] = "CS%3AGO%20Weapon%20Case%203"
            it[name] = "CS:GO Weapon Case 3"
            it[releaseDate] = "12.02.2014"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/CS%3AGO%20Weapon%20Case%203"
            it[description] =
                "The Weapon Case 3 is a case featured in Counter-Strike: Global Offensive, released as part of the February 12, 2014 update when the CZ75-Auto was released as a pistol-exclusive weapon case. This case requires the standard CS:GO Case Key to open."
        }
        CaseDatabase.insert {
            it[caseAccess] = "CS20%20Case"
            it[name] = "CS20 Case"
            it[releaseDate] = "18.10.2019"
            it[dropStatus] = "Active (Non-Prime)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/CS20%20Case"
            it[description] =
                "The CS20 Case is a weapon case featuring 17 community-made skins made for the CS20 event that have a Counter-Strike theme to it. It features the Classic Knife in 13 different finishes. It was released during the October 18, 2019 in the CS20 event, along with the CS20 Sticker Capsule. There is a tiny chance to unbox the Classic Knife."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Danger%20Zone%20Case"
            it[name] = "Danger Zone Case"
            it[releaseDate] = "06.12.2018"
            it[dropStatus] = "Active (Prime)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Danger%20Zone%20Case"
            it[description] =
                "The Danger Zone Case is a weapon case of community created weapon skins released in the December 6, 2018 update. It requires a Danger Zone Case Key to be opened. There is also a small chance to receive one of the Horizon knives when opening the case."
        }
        CaseDatabase.insert {
            it[caseAccess] = "eSports%202013%20Case"
            it[name] = "eSports 2013 Case"
            it[releaseDate] = "14.08.2013"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/eSports%202013%20Case"
            it[description] =
                "The eSports 2013 Case is the second ever weapon crate released in Counter-Strike: Global Offensive during the August 14, 2013 Arms Deal update. A portion of the profits from the eSports key sales are given to the Counter-Strike eSports community. Since the introduction of the eSports 2013 Winter Case, the eSports 2013 Case drops very rarely."
        }
        CaseDatabase.insert {
            it[caseAccess] = "eSports%202013%20Winter%20Case"
            it[name] = "eSports 2013 Winter Case"
            it[releaseDate] = "18.12.2013"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/eSports%202013%20Winter%20Case"
            it[description] =
                "The eSports 2013 Winter Case is a weapon case in Counter-Strike: Global Offensive introduced as part of the December 18, 2013 Winter Offensive update that contains 12 Valve-made skins. A portion of the profits from the eSports key sales are given to the Counter-Strike eSports community. Since the introduction of the eSports 2014 Summer Case, the eSports 2013 Winter Case drops very rarely."
        }
        CaseDatabase.insert {
            it[caseAccess] = "eSports%202014%20Summer%20Case"
            it[name] = "eSports 2014 Summer Case"
            it[releaseDate] = "10.07.2014"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/eSports%202014%20Summer%20Case"
            it[description] =
                "The eSports 2014 Summer Case is a weapon crate in Counter-Strike: Global Offensive added as part of the July, 10, 2014 update. It contains 17 weapon skins that are made by Valve. A portion of the profits from the eSports key sales are given to the Counter-Strike eSports community."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Falchion%20Case"
            it[name] = "Falchion Case"
            it[releaseDate] = "26.05.2015"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Falchion%20Case"
            it[description] =
                "The Falchion Case is a weapon case released on the May 26, 2015 update, alongside with Operation Bloodhound as an exclusive drop to pass holders. After Operation Bloodhound came to a close, the case was available to drop for all players. This case also introduces the case-exclusive Falchion Knife which can be unboxed at a very low chance."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Fracture%20Case"
            it[name] = "Fracture Case"
            it[releaseDate] = "07.08.2020"
            it[dropStatus] = "Active (Prime)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Fracture%20Case"
            it[description] =
                "The Fracture Case is a weapon case featuring 17 community-designed weapon finishes and along with the Shattered Web Case knives (Paracord Knife, Survival Knife, Skeleton Knife, Nomad Knife), in the standard knife finishes."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Gamma%20Case"
            it[name] = "Gamma Case"
            it[releaseDate] = "15.06.2016"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Gamma%20Case"
            it[description] =
                "The Gamma Case is a weapon case consisting of community weapons and new knife finishes released as part of the June 15, 2016 update. It requires a Gamma Case Key to be opened. On Glock-18 Wasteland Rebel, the numbers 7355608 are hidden on the back of the gun. Glock-18 Wasteland Rebel contains many hidden smaller painted messages and symbols that can be seen at a very low weapon condition, which are covered by the Kill Them All graffiti on higher conditions."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Gamma%202%20Case"
            it[name] = "Gamma 2 Case"
            it[releaseDate] = "18.08.2016"
            it[dropStatus] = "Active (Non-Prime)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Gamma%202%20Case"
            it[description] =
                "The Gamma 2 Case is a weapon case consisting of community weapons and new knife finishes released as part of the August 18, 2016 update. It requires a Gamma Case Key to be opened."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Glove%20Case"
            it[name] = "Glove Case"
            it[releaseDate] = "28.11.2016"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Glove%20Case"
            it[description] =
                "The Glove Case is a weapon case consisting of community weapons and new gloves released as part of the November 28, 2016 update. It requires a Glove Case Key to be opened."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Horizon%20Case"
            it[name] = "Horizon Case"
            it[releaseDate] = "02.08.2018"
            it[dropStatus] = "Active (Non-Prime)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Horizon%20Case"
            it[description] =
                "The Horizon Case is a weapon case featuring 17 community-designed weapon finishes and along Ursus Knife, Navaja Knife, Stiletto Knife, Talon Knife. Released as part of the August 3, 2018 update. It requires a Horizon Case Key to be opened."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Huntsman%20Weapon%20Case"
            it[name] = "Huntsman Weapon Case"
            it[releaseDate] = "01.05.2014"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Huntsman%20Weapon%20Case"
            it[description] =
                "The Huntsman Weapon Case is a weapon case consisting of 15 community-made weapon skins released as part of the May 1, 2014 update that also introduced the Bank Collection. It requires a Huntsman Weapon Case Key to be opened. There is a small chance to unbox a Huntsman Knife when opening the case. On June 11th, 2014, the Huntsman Weapon Case was updated, along with the Community Sticker Capsule 1 due to a copyright infringement[1][2][3]. The M4A4 | Howl and several other weapon skins were removed and 6 new weapon skins were added."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Operation%20Bravo%20Case"
            it[name] = "Operation Bravo Case"
            it[releaseDate] = "19.09.2013"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Operation%20Bravo%20Case"
            it[description] =
                "The Operation Bravo Case is a crate containing 15 Valve-made weapon skins that was released during September 19, 2013. Since the release of Operation Bravo, any player could obtain this case. However, holders of the Operation Bravo pass had a higher chance to receive the case as a drop. Like the CSGO Weapon Case, the standard weapon case key can be used to open this case. Since the end of Operation Bravo, this case drops very rarely."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Operation%20Breakout%20Weapon%20Case"
            it[name] = "Operation Breakout Weapon Case"
            it[releaseDate] = "01.07.2014"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Operation%20Breakout%20Weapon%20Case"
            it[description] =
                "The Operation Breakout Case is a weapon case consisting of 14 community-created weapon skins released as part of Operation Breakout with the July 1, 2014 update. Like the Operation Phoenix Weapon Case during Operation Phoenix, Operation Breakout Coin holders received this case. Once the operation ended on October 2, 2014, the weapon case became available for all CS:GO players."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Operation%20Broken%20Fang%20Case"
            it[name] = "Operation Broken Fang Case"
            it[releaseDate] = "04.12.2020"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Operation%20Broken%20Fang%20Case"
            it[description] =
                "The Broken Fang Case is a case that contains 17 community-made weapon skins released as part of Operation Broken Fang. There is a very small chance to unbox a pair of gloves."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Operation%20Hydra%20Case"
            it[name] = "Operation Hydra Case"
            it[releaseDate] = "23.05.2017"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Operation%20Hydra%20Case"
            it[description] =
                "The Operation Hydra Case is a weapon case of community created weapon skins AWP Oni Taiji is likely named after the Japanese phrase 鬼退治 (おに　たいじ, Oni Taiji), which means evil spirit extermination. As each case Key in-game is worth $2.49, this is the only case where the Key only costs around $1.and new gloves released in the May 23, 2017 update, alongside with Operation Hydra as an exclusive drop to pass holders. It requires a Operation Hydra Case Key to be opened."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Operation%20Phoenix%20Weapon%20Case"
            it[name] = "Operation Phoenix Weapon Case"
            it[releaseDate] = "20.02.2014"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Operation%20Phoenix%20Weapon%20Case"
            it[description] =
                "The Operation Phoenix Case is a weapon case of 13 community-created weapon skins released on February 20, 2014 as part of Operation Phoenix. The chance for the case to drop was originally exclusive to pass owners. As of the June 11, 2014 update, the weapon case became available as a drop for all players."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Operation%20Vanguard%20Weapon%20Case"
            it[name] = "Operation Vanguard Weapon Case"
            it[releaseDate] = "11.11.2014"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Operation%20Vanguard%20Weapon%20Case"
            it[description] =
                "The Operation Vanguard Case is a weapon case consisting of 14 community-created weapon skins released as part of Operation Vanguard during the November 11, 2014 update. Like the previous operation cases, Operation Vanguard Coin holders receive exclusive case drops in addition to the normal timed drops during Operation Vanguard as well as the potential to receive a case as a mission drop."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Operation%20Wildfire%20Case"
            it[name] = "Operation Wildfire Case"
            it[releaseDate] = "17.02.2016"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Operation%20Wildfire%20Case"
            it[description] =
                "The Operation Wildfire Case is a weapon case released in the February 17, 2016 update, alongside with Operation Wildfire as an exclusive drop to pass holders. This case also introduces the case-exclusive Bowie Knife which can be awarded at a very low chance. Due to the way Valve has re-sized the Case Hardened texture for the Bowie Knife, it is now much easier to get an almost full blue gem Case Hardened Bowie knife."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Prisma%20Case"
            it[name] = "Prisma Case"
            it[releaseDate] = "13.03.2019"
            it[dropStatus] = "Active (Prime)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Prisma%20Case"
            it[description] =
                "The Prisma Case is a weapon case featuring 17 community-designed weapon finishes and along with Ursus Knife, Navaja Knife, Stiletto Knife, and Talon Knife, in Chroma finishes. The case was released as part of the March 13, 2019 update. It requires a Prisma Case Key to be opened."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Prisma%202%20Case"
            it[name] = "Prisma 2 Case"
            it[releaseDate] = "01.04.2020"
            it[dropStatus] = "Active (Prime)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Prisma%202%20Case"
            it[description] =
                "Case Prism 2 is a container with weapon skins in Counter-Strike: Global Offensive. To open a special key from the case Prism 2."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Revolver%20Case"
            it[name] = "Revolver Case"
            it[releaseDate] = "08.12.2015"
            it[dropStatus] = "Active (Non-Prime)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Revolver%20Case"
            it[description] =
                "The Revolver Case is a weapon case consisting of 16 community-created weapon skins released as part of the December 8, 2015 update. The Revolver Case was the first case to contain skins for the R8 Revolver."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Shadow%20Case"
            it[name] = "Shadow Case"
            it[releaseDate] = "17.09.2015"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Shadow%20Case"
            it[description] =
                "The Shadow Case is a weapon case consisting of 16 community-made weapon skins released as part of the September 18, 2015 update. It requires a Shadow Case Key to be opened. There is a tiny chance to unbox a pair of Shadow Daggers."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Shattered%20Web%20Case"
            it[name] = "Shattered Web Case"
            it[releaseDate] = "18.11.2019"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Shattered%20Web%20Case"
            it[description] =
                "The Shattered Web Case is a case that contains 17 community-made weapon skins released as part of Operation Shattered Web. There is a very small chance to unbox the Nomad Knife, Skeleton Knife, Paracord Knife, and the Survival Knife each in 13 different finishes."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Spectrum%20Case"
            it[name] = "Spectrum Case"
            it[releaseDate] = "15.03.2017"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Spectrum%20Case"
            it[description] =
                "The Spectrum Case is a weapon case consisting of community weapons and new knife finishes for second generation of knives in Chroma Case released as part of the March 15, 2017 update. It requires a Spectrum Case Key to be opened."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Spectrum%202%20Case"
            it[name] = "Spectrum 2 Case"
            it[releaseDate] = "14.09.2017"
            it[dropStatus] = "Active (Non-Prime)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Spectrum%202%20Case"
            it[description] =
                "The Spectrum 2 Case is a weapon case consisting of community weapons and Chroma finishes for the later-added knives, released as part of the September 14, 2017 update. It requires a Spectrum 2 Case Key to be opened."
        }
        CaseDatabase.insert {
            it[caseAccess] = "Winter%20Offensive%20Weapon%20Case"
            it[name] = "Winter Offensive Weapon Case"
            it[releaseDate] = "18.12.2013"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Winter%20Offensive%20Weapon%20Case"
            it[description] =
                "The Winter Offensive Weapon Case is a weapon case containing 12 community-created skins. It was released as part of the December 18, 2013 update and requires a Winter Offensive Case Key to open. Since the release of Operation Vanguard, this crate is very rarely dropped. It can also be bought in the Steam Community Market."
        }
    }


    private fun initDatabase() {
        Database.connect("jdbc:h2:mem:regular;DB_CLOSE_DELAY=-1;", "org.h2.Driver")
        transaction {
            SchemaUtils.create(CaseDatabase)
            insertData()
        }
    }

    private suspend fun getCaseResponse(): List<CaseDto> {
        repository.updateInfo()
        return transaction {
            CaseDatabase.selectAll().map { CaseDatabase.toCaseDbo(it) }
        }.map { case -> repository.toCaseDto(case) }
    }

    fun start() {
        initDatabase()
        embeddedServer(Netty, 8080) {
            install(ContentNegotiation) { json() }
            routing {
                get("/getCase") {
                    val response = getCaseResponse()
                    call.respond(response)
                }
            }
        }.start(wait = true)
    }
}

