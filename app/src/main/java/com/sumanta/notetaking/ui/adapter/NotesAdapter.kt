package com.sumanta.notetaking.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.sumanta.notetaking.R
import com.sumanta.notetaking.db.Note
import com.sumanta.notetaking.ui.HomeFragmentDirections
import kotlinx.android.synthetic.main.note_layout.view.*

class NotesAdapter(val note: List<Note>) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    class NoteViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.note_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return note.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.view.text_view_title.text = note[position].title
        holder.view.text_view_note.text = note[position].note


        holder.view.setOnClickListener {
            val action = HomeFragmentDirections.actionAddNote()
            action.note = note[position]
            Navigation.findNavController(it).navigate(action)
        }
    }
}