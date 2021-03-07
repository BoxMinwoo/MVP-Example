package com.example.mvpexample

class MainPresenter : MainImpl.Presenter {
    lateinit var view: MainImpl.View

    constructor(view: MainImpl.View) {
        this.view = view
    }

    override fun updateSkillSet() {
        /** DB 접근하거나, API를 호출하여 데이터를 얻어오는 Business Logic 부분에
         *  지금은 하드코딩으로 간단한 Business Logic을 구
        **/
        val mapSkilSet:Map<String, String> = mutableMapOf(
                                    "Platform" to "Android, .NET",
                                    "Language" to "Kotlin, Java, C#, C++, Python",
                                    "SoftwareDesignPattern" to "MVP, MVC, MVVM",
                                    "Communication" to "HTTP, TCP/IP, RS232C, FTP")

        view.showSkillSet(mapSkilSet)
    }
}