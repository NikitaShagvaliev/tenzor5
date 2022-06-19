package com.file.androidtenzor.ui.sender.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.file.androidtenzor.R
import com.file.androidtenzor.databinding.FragmentSenderBinding
import com.file.androidtenzor.ui.receiver.view.ReceiverFragment

class SenderFragment : Fragment() {

    private lateinit var binding: FragmentSenderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentSenderBinding.inflate(inflater, container, false).run {
        binding = this
        root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sendMessage.setOnClickListener {
            val fragment = ReceiverFragment.newInstance(binding.textInput.text.toString())

            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit()
        }
    }
}
