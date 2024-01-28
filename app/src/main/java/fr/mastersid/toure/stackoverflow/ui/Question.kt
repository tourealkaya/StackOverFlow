package fr.mastersid.toure.stackoverflow.ui

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Question(
    //Ajoutez une propri ́et ́e ≪ body ≫ `a la data class Question, permettant d’afficher le d ́ebut du corps de la question.
    val id: Int,
    val title: String,
    val answerCount: Int,
  

    ):Parcelable
