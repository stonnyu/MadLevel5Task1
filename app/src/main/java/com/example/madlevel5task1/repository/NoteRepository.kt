package com.example.madlevel5task1.repository

import android.content.Context
import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import com.example.madlevel5task1.dao.NoteDao
import com.example.madlevel5task1.database.NotepadRoomDatabase
import com.example.madlevel5task1.model.Note

class NoteRepository(context: Context) {

    private val noteDao: NoteDao

    init {
        val database = NotepadRoomDatabase.getDatabase(context)
        noteDao = database!!.noteDao()
    }

    fun getNotepad(): LiveData<Note?> {
        return noteDao.getNotepad()
    }

    suspend fun updateNotepad(note: Note) {
        noteDao.updateNote(note)
    }

}
