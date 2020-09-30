package com.github.cronokirby.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.github.cronokirby.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
        binding.nicknameText.setOnClickListener {
            updateNickname(it)
        }
    }

    private fun updateNickname(view: View) {
        view.visibility = View.GONE
        binding.apply {
            doneButton.visibility = View.VISIBLE
            nicknameEdit.visibility = View.VISIBLE
            nicknameEdit.requestFocus()
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(nicknameEdit, 0)
        }
    }

    private fun addNickname(view: View) {
        binding.apply {
            nicknameText.text = nicknameEdit.text
            nicknameText.visibility = View.VISIBLE
            nicknameEdit.visibility = View.GONE
        }
        view.visibility = View.GONE

        // Hide the keyboard.
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}