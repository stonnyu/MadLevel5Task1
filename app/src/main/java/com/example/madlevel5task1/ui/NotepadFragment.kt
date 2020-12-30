package com.example.madlevel5task1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.madlevel5task1.R
import com.example.madlevel5task1.model.NoteViewModel
import kotlinx.android.synthetic.main.fragment_notes.*

class NotepadFragment : Fragment() {

    private val viewModel: NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeAddNoteResult()
    }

    private fun observeAddNoteResult() {
        viewModel.note.observe(viewLifecycleOwner, Observer{ note ->
            note?.let {
                tvNoteTitle.text = it.title
                tvLastUpdated.text = getString(R.string.overview_last_updated, it.lastUpdated.toString())
                    tvNoteText.text = it.text
            }
        })

    }
}