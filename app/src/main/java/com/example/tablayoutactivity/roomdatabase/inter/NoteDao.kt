package com.example.roomdatabase.inter

import androidx.room.*
import com.example.roomdatabase.dataclass.Contact


@Dao
interface NoteDao {

    @Insert
    fun addNote(note: Contact)

    @Query("SELECT * FROM Contact")
    fun getNotes(): List<Contact>

    @Query("SELECT * FROM Contact WHERE id = :userName")
    fun isDataExist(userName: String?): Int

    @Query("SELECT COUNT(*) FROM Contact where id = :email OR name = :phone OR course = :licence")
    fun agentsCount(email: Int?, phone: String?, licence: String?): Int


}