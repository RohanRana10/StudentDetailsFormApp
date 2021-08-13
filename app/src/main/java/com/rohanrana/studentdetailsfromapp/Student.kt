package com.rohanrana.studentdetailsfromapp

import java.io.Serializable

data class Student(
    val fullName: String,
    val branch: String,
    val year: String,
    val enrollmentNo: String,
    val collegeId: String,
    val dob: String
) : Serializable


