package invest.data.common

class CommonRepository {

    fun assignId(caseName: String): Int {
        return when (caseName) {
            "Chroma Case" -> 1
            "Chroma 2 Case" -> 2
            "Chroma 3 Case" -> 3
            "Clutch Case" -> 4
            "CSGO Weapon Case" -> 5
            "CSGO Weapon Case 2" -> 6
            "CSGO Weapon Case 3" -> 7
            "CS20 Case" -> 8
            "Danger Zone Case" -> 9
            "eSports 2013 Case" -> 10
            "eSports 2013 Winter Case" -> 11
            "eSports 2014 Summer Case" -> 12
            "Falchion Case" -> 13
            "Fracture Case" -> 14
            "Gamma Case" -> 15
            "Gamma 2 Case" -> 16
            "Glove Case" -> 17
            "Horizon Case" -> 18
            "Huntsman Weapon Case" -> 19
            "Operation Bravo Case" -> 20
            "Operation Breakout Weapon Case" -> 21
            "Operation Broken Fang Case" -> 22
            "Operation Hydra Case" -> 23
            "Operation Phoenix Weapon Case" -> 24
            "Operation Vanguard Weapon Case" -> 25
            "Operation Wildfire Case" -> 26
            "Prisma Case" -> 27
            "Prisma 2 Case" -> 28
            "Revolver Case" -> 29
            "Shadow Case" -> 30
            "Shattered Web Case" -> 31
            "Spectrum Case" -> 32
            "Spectrum 2 Case" -> 33
            "Winter Offensive Weapon Case" -> 34
            "Snakebite Case" -> 35
            "Dreams & Nightmares Case" -> 36
            "Recoil Case" ->37
//            else -> throw Throwable("Error! $caseName is not supported as a case name")
            else -> 38
        }
    }
}