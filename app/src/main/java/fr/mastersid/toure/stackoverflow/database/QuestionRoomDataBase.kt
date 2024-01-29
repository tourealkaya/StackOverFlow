package fr.mastersid.toure.stackoverflow.database

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.mastersid.toure.stackoverflow.ui.Question


@Database(
    entities = [Question::class], version = 1,
    exportSchema = false
)
abstract class QuestionRoomDataBase: RoomDatabase() {
    abstract fun questionDao(): QuestionDao

}