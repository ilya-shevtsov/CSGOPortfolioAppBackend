package features.caseoverview

import features.caseanalytics.data.entities.CaseWeaponDbo

class WeaponRepository {

    fun insertInitialData() {
        val weapons = listOf(
            CaseWeaponDbo(
                caseId = 1,
                caseName = "Chroma Case",
                weaponName = "Glock-18 | Catacombs",
                weaponImage = "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Catacombs%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 1,
                caseName = "Chroma Case",
                weaponName = "M249 | System Lock",
                weaponImage = "https://api.steamapis.com/image/item/730/M249%20%7C%20System%20Lock%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 1,
                caseName = "Chroma Case",
                weaponName = "MP9 | Deadly Poison",
                weaponImage = "https://api.steamapis.com/image/item/730/MP9%20%7C%20Deadly%20Poison%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 1,
                caseName = "Chroma Case",
                weaponName = "SCAR-20 | Grotto",
                weaponImage = "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Grotto%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 1,
                caseName = "Chroma Case",
                weaponName = "XM1014 | Quicksilver",
                weaponImage = "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Quicksilver%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 1,
                caseName = "Chroma Case",
                weaponName = "Dual Berettas | Urban Shock",
                weaponImage = "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Urban%20Shock%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 1,
                caseName = "Chroma Case",
                weaponName = "Desert Eagle | Naga",
                weaponImage = "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Naga%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 1,
                caseName = "Chroma Case",
                "MAC-10 | Malachite",
                "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Malachite%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 1,
                caseName = "Chroma Case",
                "Sawed-Off | Serenity",
                "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Serenity%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 1,
                caseName = "Chroma Case",
                "AK-47 | Cartel",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Cartel%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 1,
                caseName = "Chroma Case",
                "M4A4 | 龍王 (Dragon King)",
                "https://api.steamapis.com/image/item/730/M4A4%20%7C%20龍王%20(Dragon%20King)%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 1,
                caseName = "Chroma Case",
                "P250 | Muertos",
                "https://api.steamapis.com/image/item/730/P250%20%7C%20Muertos%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 1,
                caseName = "Chroma Case",
                "AWP | Man-o'-war",
                "https://api.steamapis.com/image/item/730/AWP%20%7C%20Man-o'-war%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 1,
                caseName = "Chroma Case",
                "Galil AR | Chatterbox",
                "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Chatterbox%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 2,
                caseName = "Chroma 2 Case",
                "AK-47 | Elite Build",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Elite%20Build%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 2,
                caseName = "Chroma 2 Case",
                "MP7 | Armor Core",
                "https://api.steamapis.com/image/item/730/MP7%20%7C%20Armor%20Core%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 2,
                caseName = "Chroma 2 Case",
                "Desert Eagle | Bronze Deco",
                "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Bronze%20Deco%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 2,
                caseName = "Chroma 2 Case",
                "P250 | Valence",
                "https://api.steamapis.com/image/item/730/P250%20%7C%20Valence%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 2,
                caseName = "Chroma 2 Case",
                "Negev | Man-o'-war",
                "https://api.steamapis.com/image/item/730/Negev%20%7C%20Man-o'-war%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 2,
                caseName = "Chroma 2 Case",
                "Sawed-Off | Origami",
                "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Origami%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 2,
                caseName = "Chroma 2 Case",
                "AWP | Worm God",
                "https://api.steamapis.com/image/item/730/AWP%20%7C%20Worm%20God%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 2,
                caseName = "Chroma 2 Case",
                "MAG-7 | Heat",
                "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Heat%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 2,
                caseName = "Chroma 2 Case",
                "CZ75-Auto | Pole Position",
                "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Pole%20Position%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 2,
                caseName = "Chroma 2 Case",
                "UMP-45 | Grand Prix",
                "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Grand%20Prix%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 2,
                caseName = "Chroma 2 Case",
                "Five-SeveN | Monkey Business",
                "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Monkey%20Business%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 2,
                caseName = "Chroma 2 Case",
                "Galil AR | Eco",
                "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Eco%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 2,
                caseName = "Chroma 2 Case",
                "FAMAS | Djinn",
                "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Djinn%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 2,
                caseName = "Chroma 2 Case",
                "M4A1-S | Hyper Beast",
                "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Hyper%20Beast%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 2,
                caseName = "Chroma 2 Case",
                "MAC-10 | Neon Rider",
                "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Neon%20Rider%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 3,
                caseName = "Chroma 3 Case",
                "Dual Berettas | Ventilators",
                "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Ventilators%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 3,
                caseName = "Chroma 3 Case",
                "G3SG1 | Orange Crash",
                "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Orange%20Crash%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 3,
                caseName = "Chroma 3 Case",
                "M249 | Spectre",
                "https://api.steamapis.com/image/item/730/M249%20%7C%20Spectre%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 3,
                caseName = "Chroma 3 Case",
                "MP9 | Bioleak",
                "https://api.steamapis.com/image/item/730/MP9%20%7C%20Bioleak%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 3,
                caseName = "Chroma 3 Case",
                "P2000 | Oceanic",
                "https://api.steamapis.com/image/item/730/P2000%20%7C%20Oceanic%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 3,
                caseName = "Chroma 3 Case",
                "Sawed-Off | Fubar",
                "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Fubar%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 3,
                caseName = "Chroma 3 Case",
                "SG 553 | Atlas",
                "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Atlas%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 3,
                caseName = "Chroma 3 Case",
                "CZ75-Auto | Red Astor",
                "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Red%20Astor%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 3,
                caseName = "Chroma 3 Case",
                "Galil AR | Firefight",
                "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Firefight%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 3,
                caseName = "Chroma 3 Case",
                "SSG 08 | Ghost Crusader",
                "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Ghost%20Crusader%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 3,
                caseName = "Chroma 3 Case",
                "Tec-9 | Re-Entry",
                "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Re-Entry%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 3,
                caseName = "Chroma 3 Case",
                "XM1014 | Black Tie",
                "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Black%20Tie%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 3,
                caseName = "Chroma 3 Case",
                "AUG | Fleet Flock",
                "https://api.steamapis.com/image/item/730/AUG%20%7C%20Fleet%20Flock%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 3,
                caseName = "Chroma 3 Case",
                "P250 | Asiimov",
                "https://api.steamapis.com/image/item/730/P250%20%7C%20Asiimov%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 3,
                caseName = "Chroma 3 Case",
                "UMP-45 | Primal Saber",
                "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Primal%20Saber%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 3,
                caseName = "Chroma 3 Case",
                "PP-Bizon | Judgement of Anubis",
                "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Judgement%20of%20Anubis%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 3,
                caseName = "Chroma 3 Case",
                "M4A1-S | Chantico's Fire",
                "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Chantico's%20Fire%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 4,
                caseName = "Clutch Case",
                "PP-Bizon | Night Riot",
                "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Night%20Riot%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 4,
                caseName = "Clutch Case",
                "Five-SeveN | Flame Test",
                "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Flame%20Test%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 4,
                caseName = "Clutch Case",
                "MP9 | Black Sand",
                "https://api.steamapis.com/image/item/730/MP9%20%7C%20Black%20Sand%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 4,
                caseName = "Clutch Case",
                "P2000 | Urban Hazard",
                "https://api.steamapis.com/image/item/730/P2000%20%7C%20Urban%20Hazard%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 4,
                caseName = "Clutch Case",
                "R8 Revolver | Grip",
                "https://api.steamapis.com/image/item/730/R8%20Revolver%20%7C%20Grip%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 4,
                caseName = "Clutch Case",
                "SG 553 | Aloha",
                "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Aloha%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 4,
                caseName = "Clutch Case",
                "XM1014 | Oxide Blaze",
                "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Oxide%20Blaze%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 4,
                caseName = "Clutch Case",
                "Glock-18 | Moonrise",
                "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Moonrise%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 4,
                caseName = "Clutch Case",
                "Negev | Lionfish",
                "https://api.steamapis.com/image/item/730/Negev%20%7C%20Lionfish%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 4,
                caseName = "Clutch Case",
                "Nova | Wild Six",
                "https://api.steamapis.com/image/item/730/Nova%20%7C%20Wild%20Six%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 4,
                caseName = "Clutch Case",
                "MAG-7 | SWAG-7",
                "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20SWAG-7%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 4,
                caseName = "Clutch Case",
                "UMP-45 | Arctic Wolf",
                "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Arctic%20Wolf%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 4,
                caseName = "Clutch Case",
                "AUG | Stymphalian",
                "https://api.steamapis.com/image/item/730/AUG%20%7C%20Stymphalian%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 4,
                caseName = "Clutch Case",
                "AWP | Mortis",
                "https://api.steamapis.com/image/item/730/AWP%20%7C%20Mortis%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 4,
                caseName = "Clutch Case",
                "USP-S | Cortex",
                "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Cortex%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 4,
                caseName = "Clutch Case",
                "M4A4 | Neo-Noir",
                "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Neo-Noir%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 4,
                caseName = "Clutch Case",
                "MP7 | Bloodsport",
                "https://api.steamapis.com/image/item/730/MP7%20%7C%20Bloodsport%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 5,
                caseName = "CS:GO Weapon Case",
                "MP7 | Skulls",
                "https://api.steamapis.com/image/item/730/MP7%20%7C%20Skulls%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 5,
                caseName = "CS:GO Weapon Case",
                "AUG | Wings",
                "https://api.steamapis.com/image/item/730/AUG%20%7C%20Wings%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 5,
                caseName = "CS:GO Weapon Case",
                "SG 553 | Ultraviolet",
                "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Ultraviolet%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 5,
                caseName = "CS:GO Weapon Case",
                "Glock-18 | Dragon Tattoo",
                "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Dragon%20Tattoo%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 5,
                caseName = "CS:GO Weapon Case",
                "USP-S | Dark Water",
                "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Dark%20Water%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 5,
                caseName = "CS:GO Weapon Case",
                "M4A1-S | Dark Water",
                "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Dark%20Water%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 5,
                caseName = "CS:GO Weapon Case",
                "AK-47 | Case Hardened",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Case%20Hardened%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 5,
                caseName = "CS:GO Weapon Case",
                "Desert Eagle | Hypnotic",
                "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Hypnotic%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 5,
                caseName = "CS:GO Weapon Case",
                "AWP | Lightning Strike",
                "https://api.steamapis.com/image/item/730/AWP%20%7C%20Lightning%20Strike%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 7,
                caseName = "CS:GO Weapon Case 3",
                "CZ75-Auto | Crimson Web",
                "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Crimson%20Web%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 7,
                caseName = "CS:GO Weapon Case 3",
                "P2000 | Red FragCam",
                "https://api.steamapis.com/image/item/730/P2000%20%7C%20Red%20FragCam%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 7,
                caseName = "CS:GO Weapon Case 3",
                "Dual Berettas | Panther",
                "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Panther%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 7,
                caseName = "CS:GO Weapon Case 3",
                "USP-S | Stainless",
                "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Stainless%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 7,
                caseName = "CS:GO Weapon Case 3",
                "Glock-18 | Blue Fissure",
                "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Blue%20Fissure%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 7,
                caseName = "CS:GO Weapon Case 3",
                "CZ75-Auto | Tread Plate",
                "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Tread%20Plate%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 7,
                caseName = "CS:GO Weapon Case 3",
                "Tec-9 | Titanium Bit",
                "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Titanium%20Bit%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 7,
                caseName = "CS:GO Weapon Case 3",
                "Desert Eagle | Heirloom",
                "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Heirloom%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 7,
                caseName = "CS:GO Weapon Case 3",
                "Five-SeveN | Copper Galaxy",
                "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Copper%20Galaxy%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 7,
                caseName = "CS:GO Weapon Case 3",
                "CZ75-Auto | The Fuschia Is Now",
                "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20The%20Fuschia%20Is%20Now%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 7,
                caseName = "CS:GO Weapon Case 3",
                "P250 | Undertow",
                "https://api.steamapis.com/image/item/730/P250%20%7C%20Undertow%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 7,
                caseName = "CS:GO Weapon Case 3",
                "CZ75-Auto | Victoria",
                "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Victoria%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 8,
                caseName = "CS20 Case",
                "Dual Berettas | Elite 1.6",
                "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Elite%201.6%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 8,
                caseName = "CS20 Case",
                "Tec-9 | Flash Out",
                "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Flash%20Out%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 8,
                caseName = "CS20 Case",
                "MAC-10 | Classic Crate",
                "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Classic%20Crate%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 8,
                caseName = "CS20 Case",
                "MAG-7 | Popdog",
                "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Popdog%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 8,
                caseName = "CS20 Case",
                "SCAR-20 | Assault",
                "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Assault%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 8,
                caseName = "CS20 Case",
                "FAMAS | Decommissioned",
                "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Decommissioned%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 8,
                caseName = "CS20 Case",
                "Glock-18 | Sacrifice",
                "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Sacrifice%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 8,
                caseName = "CS20 Case",
                "M249 | Aztec",
                "https://api.steamapis.com/image/item/730/M249%20%7C%20Aztec%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 8,
                caseName = "CS20 Case",
                "MP5-SD | Agent",
                "https://api.steamapis.com/image/item/730/MP5-SD%20%7C%20Agent%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 8,
                caseName = "CS20 Case",
                "Five-SeveN | Buddy",
                "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Buddy%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 8,
                caseName = "CS20 Case",
                "P250 | Inferno",
                "https://api.steamapis.com/image/item/730/P250%20%7C%20Inferno%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 8,
                caseName = "CS20 Case",
                "UMP-45 | Plastique",
                "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Plastique%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 8,
                caseName = "CS20 Case",
                "MP9 | Hydra",
                "https://api.steamapis.com/image/item/730/MP9%20%7C%20Hydra%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 8,
                caseName = "CS20 Case",
                "P90 | Nostalgia",
                "https://api.steamapis.com/image/item/730/P90%20%7C%20Nostalgia%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 8,
                caseName = "CS20 Case",
                "AUG | Death by Puppy",
                "https://api.steamapis.com/image/item/730/AUG%20%7C%20Death%20by%20Puppy%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 8,
                caseName = "CS20 Case",
                "AWP | Wildfire",
                "https://api.steamapis.com/image/item/730/AWP%20%7C%20Wildfire%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 8,
                caseName = "CS20 Case",
                "FAMAS | Commemoration",
                "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Commemoration%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 9,
                caseName = "Danger Zone Case",
                "MP9 | Modest Threat",
                "https://api.steamapis.com/image/item/730/MP9%20%7C%20Modest%20Threat%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 9,
                caseName = "Danger Zone Case",
                "Glock-18 | Oxide Blaze",
                "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Oxide%20Blaze%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 9,
                caseName = "Danger Zone Case",
                "Nova | Wood Fired",
                "https://api.steamapis.com/image/item/730/Nova%20%7C%20Wood%20Fired%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 9,
                caseName = "Danger Zone Case",
                "M4A4 | Magnesium",
                "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Magnesium%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 9,
                caseName = "Danger Zone Case",
                "Sawed-Off | Black Sand",
                "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Black%20Sand%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 9,
                caseName = "Danger Zone Case",
                "SG 553 | Danger Close",
                "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Danger%20Close%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 9,
                caseName = "Danger Zone Case",
                "Tec-9 | Fubar",
                "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Fubar%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 9,
                caseName = "Danger Zone Case",
                "G3SG1 | Scavenger",
                "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Scavenger%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 9,
                caseName = "Danger Zone Case",
                "Galil AR | Signal",
                "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Signal%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 9,
                caseName = "Danger Zone Case",
                "MAC-10 | Pipe Down",
                "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Pipe%20Down%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 9,
                caseName = "Danger Zone Case",
                "P250 | Nevermore",
                "https://api.steamapis.com/image/item/730/P250%20%7C%20Nevermore%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 9,
                caseName = "Danger Zone Case",
                "USP-S | Flashback",
                "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Flashback%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 9,
                caseName = "Danger Zone Case",
                "UMP-45 | Momentum",
                "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Momentum%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 9,
                caseName = "Danger Zone Case",
                "Desert Eagle | Mecha Industries",
                "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Mecha%20Industries%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 9,
                caseName = "Danger Zone Case",
                "MP5-SD | Phosphor",
                "https://api.steamapis.com/image/item/730/MP5-SD%20%7C%20Phosphor%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 9,
                caseName = "Danger Zone Case",
                "AK-47 | Asiimov",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Asiimov%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 9,
                caseName = "Danger Zone Case",
                "AWP | Neo-Noir",
                "https://api.steamapis.com/image/item/730/AWP%20%7C%20Neo-Noir%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 10,
                caseName = "eSports 2013 Case",
                "M4A4 | Faded Zebra",
                "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Faded%20Zebra%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 10,
                caseName = "eSports 2013 Case",
                "MAG-7 | Memento",
                "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Memento%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 10,
                caseName = "eSports 2013 Case",
                "FAMAS | Doomkitty",
                "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Doomkitty%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 10,
                caseName = "eSports 2013 Case",
                "Galil AR | Orange DDPAT",
                "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Orange%20DDPAT%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 10,
                caseName = "eSports 2013 Case",
                "Sawed-Off | Orange DDPAT",
                "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Orange%20DDPAT%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 10,
                caseName = "eSports 2013 Case",
                "P250 | Splash",
                "https://api.steamapis.com/image/item/730/P250%20%7C%20Splash%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 10,
                caseName = "eSports 2013 Case",
                "AK-47 | Red Laminate",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Red%20Laminate%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 10,
                caseName = "eSports 2013 Case",
                "AWP | BOOM",
                "https://api.steamapis.com/image/item/730/AWP%20%7C%20BOOM%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 10,
                caseName = "eSports 2013 Case",
                "P90 | Death by Kitty",
                "https://api.steamapis.com/image/item/730/P90%20%7C%20Death%20by%20Kitty%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 11,
                caseName = "eSports 2013 Winter Case",
                "Galil AR | Blue Titanium",
                "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Blue%20Titanium%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 11,
                caseName = "eSports 2013 Winter Case",
                "Five-SeveN | Nightshade",
                "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Nightshade%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 11,
                caseName = "eSports 2013 Winter Case",
                "PP-Bizon | Water Sigil",
                "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Water%20Sigil%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 11,
                caseName = "eSports 2013 Winter Case",
                "Nova | Ghost Camo",
                "https://api.steamapis.com/image/item/730/Nova%20%7C%20Ghost%20Camo%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 11,
                caseName = "eSports 2013 Winter Case",
                "G3SG1 | Azure Zebra",
                "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Azure%20Zebra%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 11,
                caseName = "eSports 2013 Winter Case",
                "P250 | Steel Disruption",
                "https://api.steamapis.com/image/item/730/P250%20%7C%20Steel%20Disruption%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 11,
                caseName = "eSports 2013 Winter Case",
                "AK-47 | Blue Laminate",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Blue%20Laminate%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 11,
                caseName = "eSports 2013 Winter Case",
                "P90 | Blind Spot",
                "https://api.steamapis.com/image/item/730/P90%20%7C%20Blind%20Spot%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 11,
                caseName = "eSports 2013 Winter Case",
                "FAMAS | Afterimage",
                "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Afterimage%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 11,
                caseName = "eSports 2013 Winter Case",
                "AWP | Electric Hive",
                "https://api.steamapis.com/image/item/730/AWP%20%7C%20Electric%20Hive%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 11,
                caseName = "eSports 2013 Winter Case",
                "Desert Eagle | Cobalt Disruption",
                "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Cobalt%20Disruption%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 11,
                caseName = "eSports 2013 Winter Case",
                "M4A4 | X-Ray",
                "https://api.steamapis.com/image/item/730/M4A4%20%7C%20X-Ray%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 12,
                caseName = "eSports 2014 Summer Case",
                "SSG 08 | Dark Water",
                "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Dark%20Water%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 12,
                caseName = "eSports 2014 Summer Case",
                "MAC-10 | Ultraviolet",
                "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Ultraviolet%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 12,
                caseName = "eSports 2014 Summer Case",
                "USP-S | Blood Tiger",
                "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Blood%20Tiger%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 12,
                caseName = "eSports 2014 Summer Case",
                "CZ75-Auto | Hexane",
                "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Hexane%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 12,
                caseName = "eSports 2014 Summer Case",
                "Negev | Bratatat",
                "https://api.steamapis.com/image/item/730/Negev%20%7C%20Bratatat%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 12,
                caseName = "eSports 2014 Summer Case",
                "Negev | Bratatat",
                "https://api.steamapis.com/image/item/730/Negev%20%7C%20Bratatat%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 12,
                caseName = "eSports 2014 Summer Case",
                "XM1014 | Red Python",
                "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Red%20Python%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 12,
                caseName = "eSports 2014 Summer Case",
                "PP-Bizon | Blue Streak",
                "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Blue%20Streak%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 12,
                caseName = "eSports 2014 Summer Case",
                "P90 | Virus",
                "https://api.steamapis.com/image/item/730/P90%20%7C%20Virus%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 12,
                caseName = "eSports 2014 Summer Case",
                "MP7 | Ocean Foam",
                "https://api.steamapis.com/image/item/730/MP7%20%7C%20Ocean%20Foam%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 12,
                caseName = "eSports 2014 Summer Case",
                "Glock-18 | Steel Disruption",
                "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Steel%20Disruption%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 12,
                caseName = "eSports 2014 Summer Case",
                "Desert Eagle | Crimson Web",
                "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Crimson%20Web%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 12,
                caseName = "eSports 2014 Summer Case",
                "AUG | Bengal Tiger",
                "https://api.steamapis.com/image/item/730/AUG%20%7C%20Bengal%20Tiger%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 12,
                caseName = "eSports 2014 Summer Case",
                "Nova | Bloomstick",
                "https://api.steamapis.com/image/item/730/Nova%20%7C%20Bloomstick%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 12,
                caseName = "eSports 2014 Summer Case",
                "AWP | Corticera",
                "https://api.steamapis.com/image/item/730/AWP%20%7C%20Corticera%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 12,
                caseName = "eSports 2014 Summer Case",
                "P2000 | Corticera",
                "https://api.steamapis.com/image/item/730/P2000%20%7C%20Corticera%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 12,
                caseName = "eSports 2014 Summer Case",
                "M4A4 | Bullet Rain",
                "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Bullet%20Rain%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 12,
                caseName = "eSports 2014 Summer Case",
                "AK-47 | Jaguar",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Jaguar%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 13,
                caseName = "Falchion Case",
                "Galil AR | Rocket Pop",
                "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Rocket%20Pop%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 13,
                caseName = "Falchion Case",
                "Glock-18 | Bunsen Burner",
                "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Bunsen%20Burner%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 13,
                caseName = "Falchion Case",
                "Nova | Ranger",
                "https://api.steamapis.com/image/item/730/Nova%20%7C%20Ranger%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 13,
                caseName = "Falchion Case",
                "P90 | Elite Build",
                "https://api.steamapis.com/image/item/730/P90%20%7C%20Elite%20Build%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 13,
                caseName = "Falchion Case",
                "UMP-45 | Riot",
                "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Riot%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 13,
                caseName = "Falchion Case",
                "USP-S | Torque",
                "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Torque%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 13,
                caseName = "Falchion Case",
                "FAMAS | Neural Net",
                "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Neural%20Net%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 13,
                caseName = "Falchion Case",
                "M4A4 | Evil Daimyo",
                "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Evil%20Daimyo%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 13,
                caseName = "Falchion Case",
                "MP9 | Ruby Poison Dart",
                "https://api.steamapis.com/image/item/730/MP9%20%7C%20Ruby%20Poison%20Dart%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 13,
                caseName = "Falchion Case",
                "Negev | Loudmouth",
                "https://api.steamapis.com/image/item/730/Negev%20%7C%20Loudmouth%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 13,
                caseName = "Falchion Case",
                "P2000 | Handgun",
                "https://api.steamapis.com/image/item/730/P2000%20%7C%20Handgun%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 13,
                caseName = "Falchion Case",
                "CZ75-Auto | Yellow Jacket",
                "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Yellow%20Jacket%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 13,
                caseName = "Falchion Case",
                "MP7 | Nemesis",
                "https://api.steamapis.com/image/item/730/MP7%20%7C%20Nemesis%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 13,
                caseName = "Falchion Case",
                "SG 553 | Cyrex",
                "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Cyrex%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 13,
                caseName = "Falchion Case",
                "AK-47 | Aquamarine Revenge",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Aquamarine%20Revenge%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 13,
                caseName = "Falchion Case",
                "AWP | Hyper Beast",
                "https://api.steamapis.com/image/item/730/AWP%20%7C%20Hyper%20Beast%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 14,
                caseName = "Fracture Case",
                "Negev | Ultralight",
                "https://api.steamapis.com/image/item/730/Negev%20%7C%20Ultralight%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 14,
                caseName = "Fracture Case",
                "P2000 | Gnarled",
                "https://api.steamapis.com/image/item/730/P2000%20%7C%20Gnarled%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 14,
                caseName = "Fracture Case",
                "SG 553 | Ol' Rusty",
                "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Ol'%20Rusty%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 14,
                caseName = "Fracture Case",
                "SSG 08 | Mainframe 001",
                "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Mainframe%20001%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 14,
                caseName = "Fracture Case",
                "P250 | Cassette",
                "https://api.steamapis.com/image/item/730/P250%20%7C%20Cassette%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 14,
                caseName = "Fracture Case",
                "P90 | Freight",
                "https://api.steamapis.com/image/item/730/P90%20%7C%20Freight%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 14,
                caseName = "Fracture Case",
                "PP-Bizon | Runic",
                "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Runic%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 14,
                caseName = "Fracture Case",
                "MAG-7 | Monster Call",
                "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Monster%20Call%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 14,
                caseName = "Fracture Case",
                "Tec-9 | Brother",
                "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Brother%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 14,
                caseName = "Fracture Case",
                "MAC-10 | Allure",
                "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Allure%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 14,
                caseName = "Fracture Case",
                "Galil AR | Connexion",
                "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Connexion%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 14,
                caseName = "Fracture Case",
                "MP5-SD | Kitbash",
                "https://api.steamapis.com/image/item/730/MP5-SD%20%7C%20Kitbash%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 14,
                caseName = "Fracture Case",
                "M4A4 | Tooth Fairy",
                "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Tooth%20Fairy%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 14,
                caseName = "Fracture Case",
                "Glock-18 | Vogue",
                "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Vogue%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 14,
                caseName = "Fracture Case",
                "XM1014 | Entombed",
                "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Entombed%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 14,
                caseName = "Fracture Case",
                "Desert Eagle | Printstream",
                "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Printstream%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 14,
                caseName = "Fracture Case",
                "AK-47 | Legion of Anubis",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Legion%20of%20Anubis%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 15,
                caseName = "Gamma Case",
                "Five-SeveN | Violent Daimyo",
                "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Violent%20Daimyo%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 15,
                caseName = "Gamma Case",
                "MAC-10 | Carnivore",
                "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Carnivore%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 15,
                caseName = "Gamma Case",
                "Nova | Exo",
                "https://api.steamapis.com/image/item/730/Nova%20%7C%20Exo%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 15,
                caseName = "Gamma Case",
                "P250 | Iron Clad",
                "https://api.steamapis.com/image/item/730/P250%20%7C%20Iron%20Clad%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 15,
                caseName = "Gamma Case",
                "PP-Bizon | Harvester",
                "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Harvester%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 15,
                caseName = "Gamma Case",
                "SG 553 | Aerial",
                "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Aerial%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 15,
                caseName = "Gamma Case",
                "Tec-9 | Ice Cap",
                "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Ice%20Cap%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 15,
                caseName = "Gamma Case",
                "AUG | Aristocrat",
                "https://api.steamapis.com/image/item/730/AUG%20%7C%20Aristocrat%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 15,
                caseName = "Gamma Case",
                "AWP | Phobos",
                "https://api.steamapis.com/image/item/730/AWP%20%7C%20Phobos%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 15,
                caseName = "Gamma Case",
                "P90 | Chopper",
                "https://api.steamapis.com/image/item/730/P90%20%7C%20Chopper%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 15,
                caseName = "Gamma Case",
                "R8 Revolver | Reboot",
                "https://api.steamapis.com/image/item/730/R8%20Revolver%20%7C%20Reboot%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 15,
                caseName = "Gamma Case",
                "Sawed-Off | Limelight",
                "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Limelight%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 15,
                caseName = "Gamma Case",
                "M4A4 | Desolate Space",
                "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Desolate%20Space%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 15,
                caseName = "Gamma Case",
                "P2000 | Imperial Dragon",
                "https://api.steamapis.com/image/item/730/P2000%20%7C%20Imperial%20Dragon%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 15,
                caseName = "Gamma Case",
                "SCAR-20 | Bloodsport",
                "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Bloodsport%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 15,
                caseName = "Gamma Case",
                "Glock-18 | Wasteland Rebel",
                "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Wasteland%20Rebel%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 15,
                caseName = "Gamma Case",
                "M4A1-S | Mecha Industries",
                "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Mecha%20Industries%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 16,
                caseName = "Gamma Case 2",
                "CZ75-Auto | Imprint",
                "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Imprint%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 16,
                caseName = "Gamma Case 2",
                "Five-SeveN | Scumbria",
                "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Scumbria%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 16,
                caseName = "Gamma Case 2",
                "G3SG1 | Ventilator",
                "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Ventilator%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 16,
                caseName = "Gamma Case 2",
                "Negev | Dazzle",
                "https://api.steamapis.com/image/item/730/Negev%20%7C%20Dazzle%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 16,
                caseName = "Gamma Case 2",
                "P90 | Grim",
                "https://api.steamapis.com/image/item/730/P90%20%7C%20Grim%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 16,
                caseName = "Gamma Case 2",
                "UMP-45 | Briefing",
                "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Briefing%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 16,
                caseName = "Gamma Case 2",
                "XM1014 | Slipstream",
                "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Slipstream%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 16,
                caseName = "Gamma Case 2",
                "Desert Eagle | Directive",
                "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Directive%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 16,
                caseName = "Gamma Case 2",
                "Glock-18 | Weasel",
                "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Weasel%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 16,
                caseName = "Gamma Case 2",
                "MAG-7 | Petroglyph",
                "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Petroglyph%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 16,
                caseName = "Gamma Case 2",
                "SCAR-20 | Powercore",
                "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Powercore%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 16,
                caseName = "Gamma Case 2",
                "SG 553 | Triarch",
                "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Triarch%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 16,
                caseName = "Gamma Case 2",
                "AUG | Syd Mead",
                "https://api.steamapis.com/image/item/730/AUG%20%7C%20Syd%20Mead%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 16,
                caseName = "Gamma Case 2",
                "MP9 | Airlock",
                "https://api.steamapis.com/image/item/730/MP9%20%7C%20Airlock%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 16,
                caseName = "Gamma Case 2",
                "Tec-9 | Fuel Injector",
                "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Fuel%20Injector%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 16,
                caseName = "Gamma Case 2",
                "AK-47 | Neon Revolution",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Neon%20Revolution%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 16,
                caseName = "Gamma Case 2",
                "FAMAS | Roll Cage",
                "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Roll%20Cage%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 17,
                caseName = "Glove Case",
                "CZ75-Auto | Polymer",
                "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Polymer%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 17,
                caseName = "Glove Case",
                "Glock-18 | Ironwork",
                "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Ironwork%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 17,
                caseName = "Glove Case",
                "MP7 | Cirrus",
                "https://api.steamapis.com/image/item/730/MP7%20%7C%20Cirrus%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 17,
                caseName = "Glove Case",
                "Galil AR | Black Sand",
                "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Black%20Sand%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 17,
                caseName = "Glove Case",
                "MP9 | Sand Scale",
                "https://api.steamapis.com/image/item/730/MP9%20%7C%20Sand%20Scale%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 17,
                caseName = "Glove Case",
                "MAG-7 | Sonar",
                "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Sonar%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 17,
                caseName = "Glove Case",
                "MAG-7 | Sonar",
                "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Sonar%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 17,
                caseName = "Glove Case",
                "P2000 | Turf",
                "https://api.steamapis.com/image/item/730/P2000%20%7C%20Turf%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 17,
                caseName = "Glove Case",
                "Dual Berettas | Royal Consorts",
                "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Royal%20Consorts%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 17,
                caseName = "Glove Case",
                "G3SG1 | Stinger",
                "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Stinger%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 17,
                caseName = "Glove Case",
                "M4A1-S | Flashback",
                "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Flashback%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 17,
                caseName = "Glove Case",
                "Nova | Gila",
                "https://api.steamapis.com/image/item/730/Nova%20%7C%20Gila%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 17,
                caseName = "Glove Case",
                "FAMAS | Mecha Industries",
                "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Mecha%20Industries%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 17,
                caseName = "Glove Case",
                "P90 | Shallow Grave",
                "https://api.steamapis.com/image/item/730/P90%20%7C%20Shallow%20Grave%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 17,
                caseName = "Glove Case",
                "Sawed-Off | Wasteland Princess",
                "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Wasteland%20Princess%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 17,
                caseName = "Glove Case",
                "SSG 08 | Dragonfire",
                "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Dragonfire%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 17,
                caseName = "Glove Case",
                "M4A4 | Buzz Kill",
                "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Buzz%20Kill%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 18,
                caseName = "Horizon Case",
                "AUG | Amber Slipstream",
                "https://api.steamapis.com/image/item/730/AUG%20%7C%20Amber%20Slipstream%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 18,
                caseName = "Horizon Case",
                "Dual Berettas | Shred",
                "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Shred%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 18,
                caseName = "Horizon Case",
                "Glock-18 | Warhawk",
                "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Warhawk%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 18,
                caseName = "Horizon Case",
                "MP9 | Capillary",
                "https://api.steamapis.com/image/item/730/MP9%20%7C%20Capillary%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 18,
                caseName = "Horizon Case",
                "P90 | Traction",
                "https://api.steamapis.com/image/item/730/P90%20%7C%20Traction%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 18,
                caseName = "Horizon Case",
                "R8 Revolver | Survivalist",
                "https://api.steamapis.com/image/item/730/R8%20Revolver%20%7C%20Survivalist%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 18,
                caseName = "Horizon Case",
                "Tec-9 | Snek-9",
                "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Snek-9%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 18,
                caseName = "Horizon Case",
                "CZ75-Auto | Eco",
                "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Eco%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 18,
                caseName = "Horizon Case",
                "G3SG1 | High Seas",
                "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20High%20Seas%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 18,
                caseName = "Horizon Case",
                "Nova | Toy Soldier",
                "https://api.steamapis.com/image/item/730/Nova%20%7C%20Toy%20Soldier%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 18,
                caseName = "Horizon Case",
                "AWP | PAW",
                "https://api.steamapis.com/image/item/730/AWP%20%7C%20PAW%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 18,
                caseName = "Horizon Case",
                "MP7 | Powercore",
                "https://api.steamapis.com/image/item/730/MP7%20%7C%20Powercore%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 18,
                caseName = "Horizon Case",
                "M4A1-S | Nightmare",
                "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Nightmare%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 18,
                caseName = "Horizon Case",
                "Sawed-Off | Devourer",
                "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Devourer%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 18,
                caseName = "Horizon Case",
                "FAMAS | Eye of Athena",
                "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Eye%20of%20Athena%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 18,
                caseName = "Horizon Case",
                "AK-47 | Neon Rider",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Neon%20Rider%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 18,
                caseName = "Horizon Case",
                "Desert Eagle | Code Red",
                "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Code%20Red%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 19,
                caseName = "Huntsman Weapon Case",
                "Tec-9 | Isaac",
                "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Isaac%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 19,
                caseName = "Huntsman Weapon Case",
                "SSG 08 | Slashed",
                "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Slashed%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 19,
                caseName = "Huntsman Weapon Case",
                "Galil AR | Kami",
                "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Kami%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 19,
                caseName = "Huntsman Weapon Case",
                "CZ75-Auto | Twist",
                "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Twist%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 19,
                caseName = "Huntsman Weapon Case",
                "P90 | Module",
                "https://api.steamapis.com/image/item/730/P90%20%7C%20Module%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 19,
                caseName = "Huntsman Weapon Case",
                "P2000 | Pulse",
                "https://api.steamapis.com/image/item/730/P2000%20%7C%20Pulse%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 19,
                caseName = "Huntsman Weapon Case",
                "AUG | Torque",
                "https://api.steamapis.com/image/item/730/AUG%20%7C%20Torque%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 19,
                caseName = "Huntsman Weapon Case",
                "PP-Bizon | Antique",
                "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Antique%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 19,
                caseName = "Huntsman Weapon Case",
                "XM1014 | Heaven Guard",
                "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Heaven%20Guard%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 19,
                caseName = "Huntsman Weapon Case",
                "MAC-10 | Tatter",
                "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Tatter%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 19,
                caseName = "Huntsman Weapon Case",
                "M4A1-S | Atomic Alloy",
                "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Atomic%20Alloy%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 19,
                caseName = "Huntsman Weapon Case",
                "SCAR-20 | Cyrex",
                "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Cyrex%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 19,
                caseName = "Huntsman Weapon Case",
                "USP-S | Caiman",
                "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Caiman%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 19,
                caseName = "Huntsman Weapon Case",
                "AK-47 | Vulcan",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Vulcan%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 19,
                caseName = "Huntsman Weapon Case",
                "M4A4 | Desert-Strike",
                "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Desert-Strike%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 20,
                caseName = "Operation Bravo Case",
                "SG 553 | Wave Spray",
                "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Wave%20Spray%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 20,
                caseName = "Operation Bravo Case",
                "Dual Berettas | Black Limba",
                "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Black%20Limba%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 20,
                caseName = "Operation Bravo Case",
                "Nova | Tempest",
                "https://api.steamapis.com/image/item/730/Nova%20%7C%20Tempest%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 20,
                caseName = "Operation Bravo Case",
                "Galil AR | Shattered",
                "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Shattered%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 20,
                caseName = "Operation Bravo Case",
                "UMP-45 | Bone Pile",
                "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Bone%20Pile%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 20,
                caseName = "Operation Bravo Case",
                "G3SG1 | Demeter",
                "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Demeter%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 20,
                caseName = "Operation Bravo Case",
                "USP-S | Overgrowth",
                "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Overgrowth%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 20,
                caseName = "Operation Bravo Case",
                "M4A4 | Zirka",
                "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Zirka%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 20,
                caseName = "Operation Bravo Case",
                "MAC-10 | Graven",
                "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Graven%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 20,
                caseName = "Operation Bravo Case",
                "M4A1-S | Bright Water",
                "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Bright%20Water%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 20,
                caseName = "Operation Bravo Case",
                "P90 | Emerald Dragon",
                "https://api.steamapis.com/image/item/730/P90%20%7C%20Emerald%20Dragon%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 20,
                caseName = "Operation Bravo Case",
                "P2000 | Ocean Foam",
                "https://api.steamapis.com/image/item/730/P2000%20%7C%20Ocean%20Foam%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 20,
                caseName = "Operation Bravo Case",
                "AWP | Graphite",
                "https://api.steamapis.com/image/item/730/AWP%20%7C%20Graphite%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 20,
                caseName = "Operation Bravo Case",
                "AK-47 | Fire Serpent",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Fire%20Serpent%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 20,
                caseName = "Operation Bravo Case",
                "Desert Eagle | Golden Koi",
                "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Golden%20Koi%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 21,
                caseName = "Operation Breakout Weapon Case",
                "MP7 | Urban Hazard",
                "https://api.steamapis.com/image/item/730/MP7%20%7C%20Urban%20Hazard%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 21,
                caseName = "Operation Breakout Weapon Case",
                "Negev | Desert-Strike",
                "https://api.steamapis.com/image/item/730/Negev%20%7C%20Desert-Strike%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 21,
                caseName = "Operation Breakout Weapon Case",
                "P2000 | Ivory",
                "https://api.steamapis.com/image/item/730/P2000%20%7C%20Ivory%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 21,
                caseName = "Operation Breakout Weapon Case",
                "P2000 | Ivory",
                "https://api.steamapis.com/image/item/730/P2000%20%7C%20Ivory%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 21,
                caseName = "Operation Breakout Weapon Case",
                "SSG 08 | Abyss",
                "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Abyss%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 21,
                caseName = "Operation Breakout Weapon Case",
                "UMP-45 | Labyrinth",
                "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Labyrinth%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 21,
                caseName = "Operation Breakout Weapon Case",
                "PP-Bizon | Osiris",
                "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Osiris%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 21,
                caseName = "Operation Breakout Weapon Case",
                "CZ75-Auto | Tigris",
                "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Tigris%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 21,
                caseName = "Operation Breakout Weapon Case",
                "Nova | Koi",
                "https://api.steamapis.com/image/item/730/Nova%20%7C%20Koi%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 21,
                caseName = "Operation Breakout Weapon Case",
                "P250 | Supernova",
                "https://api.steamapis.com/image/item/730/P250%20%7C%20Supernova%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 21,
                caseName = "Operation Breakout Weapon Case",
                "Desert Eagle | Conspiracy",
                "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Conspiracy%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 21,
                caseName = "Operation Breakout Weapon Case",
                "Five-SeveN | Fowl Play",
                "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Fowl%20Play%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 21,
                caseName = "Operation Breakout Weapon Case",
                "Glock-18 | Water Elemental",
                "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Water%20Elemental%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 21,
                caseName = "Operation Breakout Weapon Case",
                "P90 | Asiimov",
                "https://api.steamapis.com/image/item/730/P90%20%7C%20Asiimov%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 21,
                caseName = "Operation Breakout Weapon Case",
                "M4A1-S | Cyrex",
                "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Cyrex%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 22,
                caseName = "Operation Broken Fang Case",
                "CZ75-Auto | Vendetta",
                "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Vendetta%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 22,
                caseName = "Operation Broken Fang Case",
                "P90 | Cocoa Rampage",
                "https://api.steamapis.com/image/item/730/P90%20%7C%20Cocoa%20Rampage%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 22,
                caseName = "Operation Broken Fang Case",
                "G3SG1 | Digital Mesh",
                "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Digital%20Mesh%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 22,
                caseName = "Operation Broken Fang Case",
                "Galil AR | Vandal",
                "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Vandal%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 22,
                caseName = "Operation Broken Fang Case",
                "P250 | Contaminant",
                "https://api.steamapis.com/image/item/730/P250%20%7C%20Contaminant%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 22,
                caseName = "Operation Broken Fang Case",
                "M249 | Deep Relief",
                "https://api.steamapis.com/image/item/730/M249%20%7C%20Deep%20Relief%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 22,
                caseName = "Operation Broken Fang Case",
                "MP5-SD | Condition Zero",
                "https://api.steamapis.com/image/item/730/MP5-SD%20%7C%20Condition%20Zero%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 22,
                caseName = "Operation Broken Fang Case",
                "AWP | Exoskeleton",
                "https://api.steamapis.com/image/item/730/AWP%20%7C%20Exoskeleton%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 22,
                caseName = "Operation Broken Fang Case",
                "Dual Berettas | Dezastre",
                "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Dezastre%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 22,
                caseName = "Operation Broken Fang Case",
                "Nova | Clear Polymer",
                "https://api.steamapis.com/image/item/730/Nova%20%7C%20Clear%20Polymer%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 22,
                caseName = "Operation Broken Fang Case",
                "SSG 08 | Parallax",
                "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Parallax%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 22,
                caseName = "Operation Broken Fang Case",
                "UMP-45 | Gold Bismuth",
                "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Gold%20Bismuth%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 22,
                caseName = "Operation Broken Fang Case",
                "Five-SeveN | Fairy Tale",
                "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Fairy%20Tale%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 22,
                caseName = "Operation Broken Fang Case",
                "M4A4 | Cyber Security",
                "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Cyber%20Security%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 22,
                caseName = "Operation Broken Fang Case",
                "USP-S | Monster Mashup",
                "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Monster%20Mashup%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 22,
                caseName = "Operation Broken Fang Case",
                "M4A1-S | Printstream",
                "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Printstream%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 22,
                caseName = "Operation Broken Fang Case",
                "Glock-18 | Neo-Noir",
                "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Neo-Noir%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 23,
                caseName = "Operation Hydra Case",
                "USP-S | Blueprint",
                "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Blueprint%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 23,
                caseName = "Operation Hydra Case",
                "FAMAS | Macabre",
                "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Macabre%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 23,
                caseName = "Operation Hydra Case",
                "M4A1-S | Briefing",
                "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Briefing%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 23,
                caseName = "Operation Hydra Case",
                "MAC-10 | Aloha",
                "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Aloha%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 23,
                caseName = "Operation Hydra Case",
                "MAG-7 | Hard Water",
                "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Hard%20Water%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 23,
                caseName = "Operation Hydra Case",
                "Tec-9 | Cut Out",
                "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Cut%20Out%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 23,
                caseName = "Operation Hydra Case",
                "UMP-45 | Metal Flowers",
                "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Metal%20Flowers%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 23,
                caseName = "Operation Hydra Case",
                "AK-47 | Orbit Mk01",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Orbit%20Mk01%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 23,
                caseName = "Operation Hydra Case",
                "AK-47 | Orbit Mk01",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Orbit%20Mk01%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 23,
                caseName = "Operation Hydra Case",
                "P2000 | Woodsman",
                "https://api.steamapis.com/image/item/730/P2000%20%7C%20Woodsman%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 23,
                caseName = "Operation Hydra Case",
                "P250 | Red Rock",
                "https://api.steamapis.com/image/item/730/P250%20%7C%20Red%20Rock%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 23,
                caseName = "Operation Hydra Case",
                "P90 | Death Grip",
                "https://api.steamapis.com/image/item/730/P90%20%7C%20Death%20Grip%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 23,
                caseName = "Operation Hydra Case",
                "SSG 08 | Death's Head",
                "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Death's%20Head%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 23,
                caseName = "Operation Hydra Case",
                "Dual Berettas | Cobra Strike",
                "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Cobra%20Strike%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 23,
                caseName = "Operation Hydra Case",
                "Galil AR | Sugar Rush",
                "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Sugar%20Rush%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 23,
                caseName = "Operation Hydra Case",
                "M4A4 | Hellfire",
                "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Hellfire%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 23,
                caseName = "Operation Hydra Case",
                "Five-SeveN | Hyper Beast",
                "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Hyper%20Beast%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 23,
                caseName = "Operation Hydra Case",
                "AWP | Oni Taiji",
                "https://api.steamapis.com/image/item/730/AWP%20%7C%20Oni%20Taiji%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 24,
                caseName = "Operation Phoenix Weapon Case",
                "MP-45 | Corporal",
                "https://api.steamapis.com/image/item/730/MP-45%20%7C%20Corporal%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 24,
                caseName = "Operation Phoenix Weapon Case",
                "Negev | Terrain",
                "https://api.steamapis.com/image/item/730/Negev%20%7C%20Terrain%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 24,
                caseName = "Operation Phoenix Weapon Case",
                "Tec-9 | Sandstorm",
                "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Sandstorm%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 24,
                caseName = "Operation Phoenix Weapon Case",
                "MAG-7 | Heaven Guard",
                "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Heaven%20Guard%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 24,
                caseName = "Operation Phoenix Weapon Case",
                "MAC-10 | Heat",
                "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Heat%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 24,
                caseName = "Operation Phoenix Weapon Case",
                "SG 553 | Pulse",
                "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Pulse%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 24,
                caseName = "Operation Phoenix Weapon Case",
                "FAMAS | Sergeant",
                "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Sergeant%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 24,
                caseName = "Operation Phoenix Weapon Case",
                "USP-S | Guardian",
                "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Guardian%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 24,
                caseName = "Operation Phoenix Weapon Case",
                "AK-47 | Redline",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Redline%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 24,
                caseName = "Operation Phoenix Weapon Case",
                "P90 | Trigon",
                "https://api.steamapis.com/image/item/730/P90%20%7C%20Trigon%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 24,
                caseName = "Operation Phoenix Weapon Case",
                "Nova | Antique",
                "https://api.steamapis.com/image/item/730/Nova%20%7C%20Antique%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 24,
                caseName = "Operation Phoenix Weapon Case",
                "AWP | Asiimov",
                "https://api.steamapis.com/image/item/730/AWP%20%7C%20Asiimov%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 24,
                caseName = "Operation Phoenix Weapon Case",
                "AUG | Chameleon",
                "https://api.steamapis.com/image/item/730/AUG%20%7C%20Chameleon%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 25,
                caseName = "Operation Vanguard Weapon Case",
                "G3SG1 | Murky",
                "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Murky%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 25,
                caseName = "Operation Vanguard Weapon Case",
                "MAG-7 | Firestarter",
                "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Firestarter%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 25,
                caseName = "Operation Vanguard Weapon Case",
                "MP9 | Dart",
                "https://api.steamapis.com/image/item/730/MP9%20%7C%20Dart%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 25,
                caseName = "Operation Vanguard Weapon Case",
                "Five-SeveN | Urban Hazard",
                "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Urban%20Hazard%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 25,
                caseName = "Operation Vanguard Weapon Case",
                "UMP-45 | Delusion",
                "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Delusion%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 25,
                caseName = "Operation Vanguard Weapon Case",
                "Glock-18 | Grinder",
                "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Grinder%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 25,
                caseName = "Operation Vanguard Weapon Case",
                "M4A1-S | Basilisk",
                "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Basilisk%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 25,
                caseName = "Operation Vanguard Weapon Case",
                "M4A4 | Griffin",
                "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Griffin%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 25,
                caseName = "Operation Vanguard Weapon Case",
                "Sawed-Off | Highwayman",
                "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Highwayman%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 25,
                caseName = "Operation Vanguard Weapon Case",
                "P250 | Cartel",
                "https://api.steamapis.com/image/item/730/P250%20%7C%20Cartel%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 25,
                caseName = "Operation Vanguard Weapon Case",
                "SCAR-20 | Cardiac",
                "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Cardiac%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 25,
                caseName = "Operation Vanguard Weapon Case",
                "XM1014 | Tranquility",
                "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Tranquility%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 25,
                caseName = "Operation Vanguard Weapon Case",
                "AK-47 | Wasteland Rebel",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Wasteland%20Rebel%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 25,
                caseName = "Operation Vanguard Weapon Case",
                "P2000 | Fire Elemental",
                "https://api.steamapis.com/image/item/730/P2000%20%7C%20Fire%20Elemental%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 26,
                caseName = "Operation Wildfire Case",
                "PP-Bizon | Photic Zone",
                "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Photic%20Zone%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 26,
                caseName = "Operation Wildfire Case",
                "Dual Berettas | Cartel",
                "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Cartel%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 26,
                caseName = "Operation Wildfire Case",
                "MAC-10 | Lapis Gator",
                "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Lapis%20Gator%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 26,
                caseName = "Operation Wildfire Case",
                "SSG 08 | Necropos",
                "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Necropos%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 26,
                caseName = "Operation Wildfire Case",
                "Tec-9 | Jambiya",
                "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Jambiya%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 26,
                caseName = "Operation Wildfire Case",
                "USP-S | Lead Conduit",
                "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Lead%20Conduit%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 26,
                caseName = "Operation Wildfire Case",
                "FAMAS | Valence",
                "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Valence%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 26,
                caseName = "Operation Wildfire Case",
                "Five-SeveN | Triumvirate",
                "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Triumvirate%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 26,
                caseName = "Operation Wildfire Case",
                "Glock-18 | Royal Legion",
                "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Royal%20Legion%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 26,
                caseName = "Operation Wildfire Case",
                "MAG-7 | Praetorian",
                "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Praetorian%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 26,
                caseName = "Operation Wildfire Case",
                "MP7 | Impire",
                "https://api.steamapis.com/image/item/730/MP7%20%7C%20Impire%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 26,
                caseName = "Operation Wildfire Case",
                "AWP | Elite Build",
                "https://api.steamapis.com/image/item/730/AWP%20%7C%20Elite%20Build%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 26,
                caseName = "Operation Wildfire Case",
                "Desert Eagle | Kumicho Dragon",
                "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Kumicho%20Dragon%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 26,
                caseName = "Operation Wildfire Case",
                "Nova | Hyper Beast",
                "https://api.steamapis.com/image/item/730/Nova%20%7C%20Hyper%20Beast%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 26,
                caseName = "Operation Wildfire Case",
                "AK-47 | Fuel Injector",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Fuel%20Injector%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 26,
                caseName = "Operation Wildfire Case",
                "M4A4 | The Battlestar",
                "https://api.steamapis.com/image/item/730/M4A4%20%7C%20The%20Battlestar%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 27,
                caseName = "Prisma Case",
                "FAMAS | Crypsis",
                "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Crypsis%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 27,
                caseName = "Prisma Case",
                "AK-47 | Uncharted",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Uncharted%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 27,
                caseName = "Prisma Case",
                "MAC-10 | Whitefish",
                "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Whitefish%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 27,
                caseName = "Prisma Case",
                "Galil AR | Akoben",
                "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Akoben%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 27,
                caseName = "Prisma Case",
                "MP7 | Mischief",
                "https://api.steamapis.com/image/item/730/MP7%20%7C%20Mischief%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 27,
                caseName = "Prisma Case",
                "P250 | Verdigris",
                "https://api.steamapis.com/image/item/730/P250%20%7C%20Verdigris%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 27,
                caseName = "Prisma Case",
                "P90 | Off World",
                "https://api.steamapis.com/image/item/730/P90%20%7C%20Off%20World%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 27,
                caseName = "Prisma Case",
                "AWP | Atheris",
                "https://api.steamapis.com/image/item/730/AWP%20%7C%20Atheris%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 27,
                caseName = "Prisma Case",
                "Tec-9 | Bamboozle",
                "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Bamboozle%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 27,
                caseName = "Prisma Case",
                "Desert Eagle | Light Rail",
                "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Light%20Rail%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 27,
                caseName = "Prisma Case",
                "MP5-SD | Gauss",
                "https://api.steamapis.com/image/item/730/MP5-SD%20%7C%20Gauss%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 27,
                caseName = "Prisma Case",
                "UMP-45 | Moonrise",
                "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Moonrise%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 27,
                caseName = "Prisma Case",
                "R8 Revolver | Skull Crusher",
                "https://api.steamapis.com/image/item/730/R8%20Revolver%20%7C%20Skull%20Crusher%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 27,
                caseName = "Prisma Case",
                "AUG | Momentum",
                "https://api.steamapis.com/image/item/730/AUG%20%7C%20Momentum%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 27,
                caseName = "Prisma Case",
                "XM1014 | Incinegator",
                "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Incinegator%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 27,
                caseName = "Prisma Case",
                "Five-SeveN | Angry Mob",
                "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Angry%20Mob%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 27,
                caseName = "Prisma Case",
                "M4A4 | The Emperor",
                "https://api.steamapis.com/image/item/730/M4A4%20%7C%20The%20Emperor%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 28,
                caseName = "Prisma 2 Case",
                "AUG | Tom Cat",
                "https://api.steamapis.com/image/item/730/AUG%20%7C%20Tom%20Cat%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 28,
                caseName = "Prisma 2 Case",
                "AWP | Capillary",
                "https://api.steamapis.com/image/item/730/AWP%20%7C%20Capillary%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 28,
                caseName = "Prisma 2 Case",
                "CZ75-Auto | Distressed",
                "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Distressed%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 28,
                caseName = "Prisma 2 Case",
                "Desert Eagle | Blue Ply",
                "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Blue%20Ply%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 28,
                caseName = "Prisma 2 Case",
                "MP5-SD | Desert Strike",
                "https://api.steamapis.com/image/item/730/MP5-SD%20%7C%20Desert%20Strike%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 28,
                caseName = "Prisma 2 Case",
                "Negev | Prototype",
                "https://api.steamapis.com/image/item/730/Negev%20%7C%20Prototype%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 28,
                caseName = "Prisma 2 Case",
                "R8 Revolver | Bone Forged",
                "https://api.steamapis.com/image/item/730/R8%20Revolver%20%7C%20Bone%20Forged%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 28,
                caseName = "Prisma 2 Case",
                "P2000 | Acid Etched",
                "https://api.steamapis.com/image/item/730/P2000%20%7C%20Acid%20Etched%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 28,
                caseName = "Prisma 2 Case",
                "Sawed-Off | Apocalypto",
                "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Apocalypto%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 28,
                caseName = "Prisma 2 Case",
                "SCAR-20 | Enforcer",
                "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Enforcer%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 28,
                caseName = "Prisma 2 Case",
                "SG 553 | Darkwing",
                "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Darkwing%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 28,
                caseName = "Prisma 2 Case",
                "SSG 08 | Fever Dream",
                "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Fever%20Dream%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 28,
                caseName = "Prisma 2 Case",
                "AK-47 | Phantom Disruptor",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Phantom%20Disruptor%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 28,
                caseName = "Prisma 2 Case",
                "MAC-10 | Disco Tech",
                "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Disco%20Tech%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 28,
                caseName = "Prisma 2 Case",
                "MAG-7 | Justice",
                "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Justice%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 28,
                caseName = "Prisma 2 Case",
                "M4A1-S | Player Two",
                "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Player%20Two%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 28,
                caseName = "Prisma 2 Case",
                "Glock-18 | Bullet Queen",
                "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Bullet%20Queen%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 29,
                caseName = "Revolver Case",
                "R8 Revolver | Crimson Web",
                "https://api.steamapis.com/image/item/730/R8%20Revolver%20%7C%20Crimson%20Web%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 29,
                caseName = "Revolver Case",
                "AUG | Ricochet",
                "https://api.steamapis.com/image/item/730/AUG%20%7C%20Ricochet%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 29,
                caseName = "Revolver Case",
                "Desert Eagle | Corinthian",
                "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Corinthian%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 29,
                caseName = "Revolver Case",
                "P2000 | Imperial",
                "https://api.steamapis.com/image/item/730/P2000%20%7C%20Imperial%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 29,
                caseName = "Revolver Case",
                "Sawed-Off | Yorick",
                "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Yorick%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 29,
                caseName = "Revolver Case",
                "SCAR-20 | Outbreak",
                "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Outbreak%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 29,
                caseName = "Revolver Case",
                "PP-Bizon | Fuel Rod",
                "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Fuel%20Rod%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 29,
                caseName = "Revolver Case",
                "Five-SeveN | Retrobution",
                "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Retrobution%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 29,
                caseName = "Revolver Case",
                "Negev | Power Loader",
                "https://api.steamapis.com/image/item/730/Negev%20%7C%20Power%20Loader%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 29,
                caseName = "Revolver Case",
                "SG 553 | Tiger Moth",
                "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Tiger%20Moth%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 29,
                caseName = "Revolver Case",
                "Tec-9 | Avalanche",
                "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Avalanche%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 29,
                caseName = "Revolver Case",
                "XM1014 | Teclu Burner",
                "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Teclu%20Burner%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 29,
                caseName = "Revolver Case",
                "AK-47 | Point Disarray",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Point%20Disarray%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 29,
                caseName = "Revolver Case",
                "G3SG1 | The Executioner",
                "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20The%20Executioner%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 29,
                caseName = "Revolver Case",
                "P90 | Shapewood",
                "https://api.steamapis.com/image/item/730/P90%20%7C%20Shapewood%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 29,
                caseName = "Revolver Case",
                "M4A4 | Royal Paladin",
                "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Royal%20Paladin%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 29,
                caseName = "Revolver Case",
                "R8 Revolver | Fade",
                "https://api.steamapis.com/image/item/730/R8%20Revolver%20%7C%20Fade%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 30,
                caseName = "Shadow Case",
                "Dual Berettas | Dualing Dragons",
                "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Dualing%20Dragons%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 30,
                caseName = "Shadow Case",
                "FAMAS | Survivor Z",
                "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Survivor%20Z%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 30,
                caseName = "Shadow Case",
                "Glock-18 | Wraiths",
                "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Wraiths%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 30,
                caseName = "Shadow Case",
                "MAC-10 | Rangeen",
                "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Rangeen%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 30,
                caseName = "Shadow Case",
                "MAG-7 | Cobalt Core",
                "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Cobalt%20Core%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 30,
                caseName = "Shadow Case",
                "SCAR-20 | Green Marine",
                "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Green%20Marine%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 30,
                caseName = "Shadow Case",
                "XM1014 | Scumbria",
                "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Scumbria%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 30,
                caseName = "Shadow Case",
                "Galil AR | Stone Cold",
                "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Stone%20Cold%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 30,
                caseName = "Shadow Case",
                "M249 | Nebula Crusader",
                "https://api.steamapis.com/image/item/730/M249%20%7C%20Nebula%20Crusader%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 30,
                caseName = "Shadow Case",
                "MP7 | Special Delivery",
                "https://api.steamapis.com/image/item/730/MP7%20%7C%20Special%20Delivery%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 30,
                caseName = "Shadow Case",
                "P250 | Wingshot",
                "https://api.steamapis.com/image/item/730/P250%20%7C%20Wingshot%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 30,
                caseName = "Shadow Case",
                "AK-47 | Frontside Misty",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Frontside%20Misty%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 30,
                caseName = "Shadow Case",
                "G3SG1 | Flux",
                "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Flux%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 30,
                caseName = "Shadow Case",
                "SSG 08 | Big Iron",
                "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Big%20Iron%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 30,
                caseName = "Shadow Case",
                "M4A1-S | Golden Coil",
                "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Golden%20Coil%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 30,
                caseName = "Shadow Case",
                "USP-S | Kill Confirmed",
                "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Kill%20Confirmed%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 31,
                caseName = "Shattered Web Case",
                "MP5-SD | Acid Wash",
                "https://api.steamapis.com/image/item/730/MP5-SD%20%7C%20Acid%20Wash%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 31,
                caseName = "Shattered Web Case",
                "Nova | Plume",
                "https://api.steamapis.com/image/item/730/Nova%20%7C%20Plume%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 31,
                caseName = "Shattered Web Case",
                "G3SG1 | Black Sand",
                "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Black%20Sand%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 31,
                caseName = "Shattered Web Case",
                "R8 Revolver | Memento",
                "https://api.steamapis.com/image/item/730/R8%20Revolver%20%7C%20Memento%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 31,
                caseName = "Shattered Web Case",
                "Dual Berettas | Balance",
                "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Balance%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 31,
                caseName = "Shattered Web Case",
                "SCAR-20 | Torn",
                "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Torn%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 31,
                caseName = "Shattered Web Case",
                "M249 | Warbird",
                "https://api.steamapis.com/image/item/730/M249%20%7C%20Warbird%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 31,
                caseName = "Shattered Web Case",
                "PP-Bizon | Embargo",
                "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Embargo%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 31,
                caseName = "Shattered Web Case",
                "AK-47 | Rat Rod",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Rat%20Rod%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 31,
                caseName = "Shattered Web Case",
                "AUG | Arctic Wolf",
                "https://api.steamapis.com/image/item/730/AUG%20%7C%20Arctic%20Wolf%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 31,
                caseName = "Shattered Web Case",
                "MP7 | Neon Ply",
                "https://api.steamapis.com/image/item/730/MP7%20%7C%20Neon%20Ply%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 31,
                caseName = "Shattered Web Case",
                "P2000 | Obsidian",
                "https://api.steamapis.com/image/item/730/P2000%20%7C%20Obsidian%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 31,
                caseName = "Shattered Web Case",
                "Tec-9 | Decimator",
                "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Decimator%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 31,
                caseName = "Shattered Web Case",
                "SG 553 | Colony IV",
                "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Colony%20IV%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 31,
                caseName = "Shattered Web Case",
                "SSG 08 | Bloodshot",
                "https://api.steamapis.com/image/item/730/SSG%2008%20%7C%20Bloodshot%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 31,
                caseName = "Shattered Web Case",
                "AWP | Containment Breach",
                "https://api.steamapis.com/image/item/730/AWP%20%7C%20Containment%20Breach%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 31,
                caseName = "Shattered Web Case",
                "MAC-10 | Stalker",
                "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Stalker%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 32,
                caseName = "Spectrum Case",
                "PP-Bizon | Jungle Slipstream",
                "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Jungle%20Slipstream%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 32,
                caseName = "Spectrum Case",
                "SCAR-20 | Blueprint",
                "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Blueprint%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 32,
                caseName = "Spectrum Case",
                "Desert Eagle | Oxide Blaze",
                "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Oxide%20Blaze%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 32,
                caseName = "Spectrum Case",
                "Five-SeveN | Capillary",
                "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Capillary%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 32,
                caseName = "Spectrum Case",
                "MP7 | Akoben",
                "https://api.steamapis.com/image/item/730/MP7%20%7C%20Akoben%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 32,
                caseName = "Spectrum Case",
                "P250 | Ripple",
                "https://api.steamapis.com/image/item/730/P250%20%7C%20Ripple%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 32,
                caseName = "Spectrum Case",
                "Sawed-Off | Zander",
                "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Zander%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 32,
                caseName = "Spectrum Case",
                "Galil AR | Crimson Tsunami",
                "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Crimson%20Tsunami%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 32,
                caseName = "Spectrum Case",
                "M249 | Emerald Poison Dart",
                "https://api.steamapis.com/image/item/730/M249%20%7C%20Emerald%20Poison%20Dart%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 32,
                caseName = "Spectrum Case",
                "MAC-10 | Last Dive",
                "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Last%20Dive%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 32,
                caseName = "Spectrum Case",
                "UMP-45 | Scaffold",
                "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Scaffold%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 32,
                caseName = "Spectrum Case",
                "XM1014 | Seasons",
                "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Seasons%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 32,
                caseName = "Spectrum Case",
                "AWP | Fever Dream",
                "https://api.steamapis.com/image/item/730/AWP%20%7C%20Fever%20Dream%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 32,
                caseName = "Spectrum Case",
                "CZ75-Auto | Xiangliu",
                "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Xiangliu%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 32,
                caseName = "Spectrum Case",
                "M4A1-S | Decimator",
                "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Decimator%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 32,
                caseName = "Spectrum Case",
                "AK-47 | Bloodsport",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Bloodsport%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 32,
                caseName = "Spectrum Case",
                "USP-S | Neo-Noir",
                "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Neo-Noir%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 33,
                caseName = "Spectrum 2 Case",
                "Sawed-Off | Morris",
                "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Morris%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 33,
                caseName = "Spectrum 2 Case",
                "AUG | Triqua",
                "https://api.steamapis.com/image/item/730/AUG%20%7C%20Triqua%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 33,
                caseName = "Spectrum 2 Case",
                "G3SG1 | Hunter",
                "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Hunter%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 33,
                caseName = "Spectrum 2 Case",
                "Glock-18 | Off World",
                "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Off%20World%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 33,
                caseName = "Spectrum 2 Case",
                "MAC-10 | Oceanic",
                "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Oceanic%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 33,
                caseName = "Spectrum 2 Case",
                "Tec-9 | Cracked Opal",
                "https://api.steamapis.com/image/item/730/Tec-9%20%7C%20Cracked%20Opal%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 33,
                caseName = "Spectrum 2 Case",
                "SCAR-20 | Jungle Slipstream",
                "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Jungle%20Slipstream%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 33,
                caseName = "Spectrum 2 Case",
                "MP9 | Goo",
                "https://api.steamapis.com/image/item/730/MP9%20%7C%20Goo%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 33,
                caseName = "Spectrum 2 Case",
                "SG 553 | Phantom",
                "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Phantom%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 33,
                caseName = "Spectrum 2 Case",
                "CZ75-Auto | Tacticat",
                "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Tacticat%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 33,
                caseName = "Spectrum 2 Case",
                "UMP-45 | Exposure",
                "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Exposure%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 33,
                caseName = "Spectrum 2 Case",
                "XM1014 | Ziggy",
                "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Ziggy%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 33,
                caseName = "Spectrum 2 Case",
                "PP-Bizon | High Roller",
                "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20High%20Roller%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 33,
                caseName = "Spectrum 2 Case",
                "M4A1-S | Leaded Glass",
                "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Leaded%20Glass%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 33,
                caseName = "Spectrum 2 Case",
                "R8 Revolver | Llama Cannon",
                "https://api.steamapis.com/image/item/730/R8%20Revolver%20%7C%20Llama%20Cannon%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 33,
                caseName = "Spectrum 2 Case",
                "AK-47 | The Empress",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20The%20Empress%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 33,
                caseName = "Spectrum 2 Case",
                "P250 | See Ya Later",
                "https://api.steamapis.com/image/item/730/P250%20%7C%20See%20Ya%20Later%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 34,
                caseName = "Winter Offensive Weapon Case",
                "Galil AR | Sandstorm",
                "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Sandstorm%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 34,
                caseName = "Winter Offensive Weapon Case",
                "Five-SeveN | Kami",
                "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Kami%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 34,
                caseName = "Winter Offensive Weapon Case",
                "M249 | Magma",
                "https://api.steamapis.com/image/item/730/M249%20%7C%20Magma%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 34,
                caseName = "Winter Offensive Weapon Case",
                "PP-Bizon | Cobalt Halftone",
                "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Cobalt%20Halftone%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 34,
                caseName = "Winter Offensive Weapon Case",
                "FAMAS | Pulse",
                "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Pulse%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 34,
                caseName = "Winter Offensive Weapon Case",
                "Dual Berettas | Marina",
                "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Marina%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 34,
                caseName = "Winter Offensive Weapon Case",
                "MP9 | Rose Iron",
                "https://api.steamapis.com/image/item/730/MP9%20%7C%20Rose%20Iron%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 34,
                caseName = "Winter Offensive Weapon Case",
                "Nova | Rising Skull",
                "https://api.steamapis.com/image/item/730/Nova%20%7C%20Rising%20Skull%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 34,
                caseName = "Winter Offensive Weapon Case",
                "M4A1-S | Guardian",
                "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Guardian%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 34,
                caseName = "Winter Offensive Weapon Case",
                "P250 | Mehndi",
                "https://api.steamapis.com/image/item/730/P250%20%7C%20Mehndi%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 34,
                caseName = "Winter Offensive Weapon Case",
                "AWP | Redline",
                "https://api.steamapis.com/image/item/730/AWP%20%7C%20Redline%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 34,
                caseName = "Winter Offensive Weapon Case",
                "M4A4 | Asiimov",
                "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Asiimov%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 34,
                caseName = "Winter Offensive Weapon Case",
                "Sawed-Off | The Kraken",
                "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20The%20Kraken%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 35,
                caseName = "Snakebite Case",
                "SG 553 | Heavy Metal",
                "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Heavy%20Metal%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 35,
                caseName = "Snakebite Case",
                "Glock-18 | Clear Polymer",
                "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Clear%20Polymer%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 35,
                caseName = "Snakebite Case",
                "M249 | O.S.I.P.R.",
                "https://api.steamapis.com/image/item/730/M249%20%7C%20O.S.I.P.R.%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 35,
                caseName = "Snakebite Case",
                "CZ75-Auto | Circaetus",
                "https://api.steamapis.com/image/item/730/CZ75-Auto%20%7C%20Circaetus%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 35,
                caseName = "Snakebite Case",
                "UMP-45 | Oscillator",
                "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Oscillator%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 35,
                caseName = "Snakebite Case",
                "R8 Revolver | Junk Yard",
                "https://api.steamapis.com/image/item/730/R8%20Revolver%20%7C%20Junk%20Yard%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 35,
                caseName = "Snakebite Case",
                "Nova | Windblown",
                "https://api.steamapis.com/image/item/730/Nova%20%7C%20Windblown%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 35,
                caseName = "Snakebite Case",
                "P250 | Cyber Shell",
                "https://api.steamapis.com/image/item/730/P250%20%7C%20Cyber%20Shell%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 35,
                caseName = "Snakebite Case",
                "Negev | dev_texture",
                "https://api.steamapis.com/image/item/730/Negev%20%7C%20dev_texture%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 35,
                caseName = "Snakebite Case",
                "MAC-10 | Button Masher",
                "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Button%20Masher%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 35,
                caseName = "Snakebite Case",
                "Desert Eagle | Trigger Discipline",
                "https://api.steamapis.com/image/item/730/Desert%20Eagle%20%7C%20Trigger%20Discipline%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 35,
                caseName = "Snakebite Case",
                "AK-47 | Slate",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Slate%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 35,
                caseName = "Snakebite Case",
                "MP9 | Food Chain",
                "https://api.steamapis.com/image/item/730/MP9%20%7C%20Food%20Chain%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 35,
                caseName = "Snakebite Case",
                "XM1014 | XOXO",
                "https://api.steamapis.com/image/item/730/XM1014%20%7C%20XOXO%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 35,
                caseName = "Snakebite Case",
                "Galil AR | Chromatic Aberration",
                "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Chromatic%20Aberration%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 35,
                caseName = "Snakebite Case",
                "USP-S | The Traitor",
                "https://api.steamapis.com/image/item/730/USP-S%20%7C%20The%20Traitor%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 35,
                caseName = "Snakebite Case",
                "M4A4 | In Living Color",
                "https://api.steamapis.com/image/item/730/M4A4%20%7C%20In%20Living%20Color%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 36,
                caseName = "Dreams & Nightmares Case",
                "Five-SeveN | Scrawl",
                "https://api.steamapis.com/image/item/730/Five-SeveN%20%7C%20Scrawl%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 36,
                caseName = "Dreams & Nightmares Case",
                "MAC-10 | Ensnared",
                "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Ensnared%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 36,
                caseName = "Dreams & Nightmares Case",
                "MAG-7 | Foresight",
                "https://api.steamapis.com/image/item/730/MAG-7%20%7C%20Foresight%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 36,
                caseName = "Dreams & Nightmares Case",
                "MP5-SD | Necro Jr.",
                "https://api.steamapis.com/image/item/730/MP5-SD%20%7C%20Necro%20Jr.%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 36,
                caseName = "Dreams & Nightmares Case",
                "P2000 | Lifted Spirits",
                "https://api.steamapis.com/image/item/730/P2000%20%7C%20Lifted%20Spirits%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 36,
                caseName = "Dreams & Nightmares Case",
                "SCAR-20 | Poultrygeist",
                "https://api.steamapis.com/image/item/730/SCAR-20%20%7C%20Poultrygeist%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 36,
                caseName = "Dreams & Nightmares Case",
                "Sawed-Off | Spirit Board",
                "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Spirit%20Board%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 36,
                caseName = "Dreams & Nightmares Case",
                "PP-Bizon | Space Cat",
                "https://api.steamapis.com/image/item/730/PP-Bizon%20%7C%20Space%20Cat%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 36,
                caseName = "Dreams & Nightmares Case",
                "G3SG1 | Dream Glade",
                "https://api.steamapis.com/image/item/730/G3SG1%20%7C%20Dream%20Glade%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 36,
                caseName = "Dreams & Nightmares Case",
                "M4A1-S | Night Terror",
                "https://api.steamapis.com/image/item/730/M4A1-S%20%7C%20Night%20Terror%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 36,
                caseName = "Dreams & Nightmares Case",
                "XM1014 | Zombie Offensive",
                "https://api.steamapis.com/image/item/730/XM1014%20%7C%20Zombie%20Offensive%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 36,
                caseName = "Dreams & Nightmares Case",
                "USP-S | Ticket to Hell",
                "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Ticket%20to%20Hell%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 36,
                caseName = "Dreams & Nightmares Case",
                "Dual Berettas | Melondrama",
                "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Melondrama%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 36,
                caseName = "Dreams & Nightmares Case",
                "FAMAS | Rapid Eye Movement",
                "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Rapid%20Eye%20Movement%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 36,
                caseName = "Dreams & Nightmares Case",
                "MP7 | Abyssal Apparition",
                "https://api.steamapis.com/image/item/730/MP7%20%7C%20Abyssal%20Apparition%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 36,
                caseName = "Dreams & Nightmares Case",
                "AK-47 | Nightwish",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Nightwish%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 36,
                caseName = "Dreams & Nightmares Case",
                "MP9 | Starlight Protector",
                "https://api.steamapis.com/image/item/730/MP9%20%7C%20Starlight%20Protector%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 37,
                caseName = "Recoil Case",
                "FAMAS | Meow 36",
                "https://api.steamapis.com/image/item/730/FAMAS%20%7C%20Meow%2036%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 37,
                caseName = "Recoil Case",
                "Galil AR | Destroyer",
                "https://api.steamapis.com/image/item/730/Galil%20AR%20%7C%20Destroyer%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 37,
                caseName = "Recoil Case",
                "M4A4 | Poly Mag",
                "https://api.steamapis.com/image/item/730/M4A4%20%7C%20Poly%20Mag%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 37,
                caseName = "Recoil Case",
                "MAC-10 | Monkeyflage",
                "https://api.steamapis.com/image/item/730/MAC-10%20%7C%20Monkeyflage%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 37,
                caseName = "Recoil Case",
                "Negev | Drop Me",
                "https://api.steamapis.com/image/item/730/Negev%20%7C%20Drop%20Me%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 37,
                caseName = "Recoil Case",
                "UMP-45 | Roadblock",
                "https://api.steamapis.com/image/item/730/UMP-45%20%7C%20Roadblock%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 37,
                caseName = "Recoil Case",
                "Glock-18 | Winterized",
                "https://api.steamapis.com/image/item/730/Glock-18%20%7C%20Winterized%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 37,
                caseName = "Recoil Case",
                "R8 Revolver | Crazy 8",
                "https://api.steamapis.com/image/item/730/R8%20Revolver%20%7C%20Crazy%208%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 37,
                caseName = "Recoil Case",
                "M249 | Downtown",
                "https://api.steamapis.com/image/item/730/M249%20%7C%20Downtown%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 37,
                caseName = "Recoil Case",
                "SG 553 | Dragon Tech",
                "https://api.steamapis.com/image/item/730/SG%20553%20%7C%20Dragon%20Tech%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 37,
                caseName = "Recoil Case",
                "P90 | Vent Rush",
                "https://api.steamapis.com/image/item/730/P90%20%7C%20Vent%20Rush%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 37,
                caseName = "Recoil Case",
                "Dual Berettas | Flora Carnivora",
                "https://api.steamapis.com/image/item/730/Dual%20Berettas%20%7C%20Flora%20Carnivora%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 37,
                caseName = "Recoil Case",
                "AK-47 | Ice Coaled",
                "https://api.steamapis.com/image/item/730/AK-47%20%7C%20Ice%20Coaled%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 37,
                caseName = "Recoil Case",
                "P250 | Visions",
                "https://api.steamapis.com/image/item/730/P250%20%7C%20Visions%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 37,
                caseName = "Recoil Case",
                "Sawed-Off | Kiss♥Love",
                "https://api.steamapis.com/image/item/730/Sawed-Off%20%7C%20Kiss♥Love%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 37,
                caseName = "Recoil Case",
                "USP-S | Printstream",
                "https://api.steamapis.com/image/item/730/USP-S%20%7C%20Printstream%20%28Factory%20New%29"
            ),
            CaseWeaponDbo(
                caseId = 37,
                caseName = "Recoil Case",
                "AWP | Chromatic Aberration",
                "AWP%20%7C%20Chromatic%20Aberration%20%28Factory%20New%29"
            ),
        )
        weapons.map { item -> WeaponStorage.insertWeaponTable(item) }
    }
}