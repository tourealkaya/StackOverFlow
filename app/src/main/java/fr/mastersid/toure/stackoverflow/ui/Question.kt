package fr.mastersid.toure.stackoverflow.ui

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
@Entity(tableName = "question_table")
@Parcelize
data class Question(
    @PrimaryKey val id: Int,
    val title: String,
    val answerCount: Int,


    ):Parcelable
