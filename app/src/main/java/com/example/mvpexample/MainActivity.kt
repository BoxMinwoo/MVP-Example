package com.example.mvpexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainImpl.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter = MainPresenter(this)

        btn_update_skill_set.setOnClickListener {
            presenter.updateSkillSet()
        }
    }

    override fun showSkillSet(mapSkilSet: Map<String, String>) {
        var strSkillSet = ""
        for ((key, value) in mapSkilSet) {
            strSkillSet += "[${key}]\n${value}\n\n"
        }
        txt_skill_set.text = strSkillSet

    }
}