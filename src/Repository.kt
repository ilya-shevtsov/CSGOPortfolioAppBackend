package com.ilya.shevtsov.casewatcher

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class Repository {

    private val caseNameList = listOf(
        "Chroma%20Case",
        "Chroma%202%20Case",
        "Chroma%203%20Case",
        "Clutch%20Case",
        "CS%3AGO%20Weapon%20Case",
        "CS%3AGO%20Weapon%20Case%202",
        "CS%3AGO%20Weapon%20Case%203",
        "CS20%20Case",
        "Danger%20Zone%20Case",
        "eSports%202013%20Case",
        "eSports%202013%20Winter%20Case",
        "eSports%202014%20Summer%20Case",
        "Falchion%20Case",
        "Fracture%20Case",
        "Gamma%202%20Case",
        "Gamma%20Case",
        "Glove%20Case",
        "Horizon%20Case",
        "Huntsman%20Weapon%20Case",
        "Operation%20Bravo%20Case",
        "Operation%20Breakout%20Weapon%20Case",
        "Operation%20Broken%20Fang%20Case",
        "Operation%20Hydra%20Case",
        "Operation%20Phoenix%20Weapon%20Case",
        "Operation%20Vanguard%20Weapon%20Case",
        "Operation%20Wildfire%20Case",
        "Prisma%20Case",
        "Prisma%202%20Case",
        "Revolver%20Case",
        "Shadow%20Case",
        "Shattered%20Web%20Case",
        "Spectrum%202%20Case",
        "Spectrum%20Case",
        "Winter%20Offensive%20Weapon%20Case"
    )

    fun getCaseList(): String {
        return "haha"
    }
//
//    private fun Observable<List<String>>.toListOfCaseDto(): Single<List<Pair<CasePreviewDto, String>>> =
//            flatMap { caseNameList -> Observable.fromIterable(caseNameList) }
//                    .concatMap { caseName ->
//                        ApiTools.getApiService()
//                                .getCase(
//                                        appId = 730,
//                                        currency = 5,
//                                        caseName = caseName
//                                ).toObservable().map { caseDto ->
//                                    caseDto to caseName
//
//                                }
//                                .retryWhen {
//                                    Observable.timer(60, TimeUnit.SECONDS)
//                                }
//                    }
//                    .toList()
//
//    private fun Single<List<Pair<CasePreviewDto, String>>>.toListOfCase(): Single<List<CasePreview>> =
//            map { listOfCaseDto ->
//                listOfCaseDto.map { (caseDto, caseName) ->
//                    CasePreviewMapper.map(caseDto, caseName)
//                }
//            }
}

