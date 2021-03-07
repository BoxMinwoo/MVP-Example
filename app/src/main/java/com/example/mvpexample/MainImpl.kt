package com.example.mvpexample

interface MainImpl {

    interface View {
        fun showSkillSet(mapSkilSet:Map<String, String>)
    }
    interface Presenter {
        fun updateSkillSet()
    }
}