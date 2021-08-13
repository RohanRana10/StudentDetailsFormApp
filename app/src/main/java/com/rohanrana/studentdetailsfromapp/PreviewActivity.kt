package com.rohanrana.studentdetailsfromapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {
    private lateinit var student: Student
    private lateinit var messagePreviewText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        retrieveDetails()
        displayMessage()
        setupSendButton()

    }


    private fun retrieveDetails() {
        student = intent.getSerializableExtra("Student") as Student
    }

    private fun displayMessage() {

        messagePreviewText = """
            Please find attached the student details :
            
            Name : ${student.fullName}
            Branch: ${student.branch}
            Year : ${student.year}
            Enrollment No. : ${student.enrollmentNo}
            College ID : ${student.collegeId}
            Date of Birth : ${student.dob}
            
        """.trimIndent()
        text_view_message.text = messagePreviewText

    }

    private fun setupSendButton() {
        button_send_message.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: 7292012124")  // This ensures only SMS apps respond
                putExtra("sms_body", messagePreviewText)
            }
            startActivity(intent)
        }
    }
}