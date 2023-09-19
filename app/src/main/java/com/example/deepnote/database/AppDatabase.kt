package com.example.deepnote.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.deepnote.database.dao.NotaDao
import com.example.deepnote.migrations.MIGRATION_1_2
import com.example.deepnote.migrations.MIGRATION_2_3
import com.example.deepnote.migrations.MIGRATION_3_4
import com.example.deepnote.model.Nota

@Database(
    version = 4,
    entities = [Nota::class],
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun notaDao(): NotaDao

    companion object {
        @Volatile
        private var db: AppDatabase? = null

        fun instancia(context: Context): AppDatabase {
            return db ?: Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "ceep.db"
            ).addMigrations(
                MIGRATION_1_2,
                MIGRATION_2_3,
                MIGRATION_3_4
            ).build()
        }
    }

}