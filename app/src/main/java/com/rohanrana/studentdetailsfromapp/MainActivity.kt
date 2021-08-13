package com.rohanrana.studentdetailsfromapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupSpinner()
        setupButton()

    }

    private fun setupSpinner() {
        val branchSpinner = arrayOf("CSE","ME","IT","EC")
        val branchAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,branchSpinner)
        spinner_branch.adapter = branchAdapter

    }

    private fun setupButton() {
        button_create_preview.setOnClickListener {
            generateDetails()
        }

    }

    private fun generateDetails() {

        val student = Student(
            edit_text_full_name.text.toString(),
            spinner_branch.selectedItem as String,
            edit_text_year.text.toString(),
            edit_text_enrollment_number.text.toString(),
            edit_text_college_id.text.toString(),
            edit_text_dob.text.toString()
        )

        val intent = Intent(this,PreviewActivity::class.java)
        intent.putExtra("Student",student)
        startActivity(intent)

    }
}