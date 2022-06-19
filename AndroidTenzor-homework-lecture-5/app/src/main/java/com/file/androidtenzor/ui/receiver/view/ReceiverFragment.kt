package com.file.androidtenzor.ui.receiver.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.file.androidtenzor.R
import com.file.androidtenzor.databinding.FragmentReceiverBinding
import com.file.androidtenzor.ui.receiver.viewmodel.ReceiverViewModel

class ReceiverFragment : Fragment() {

    private lateinit var binding: FragmentReceiverBinding

    private val viewModel: ReceiverViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentReceiverBinding.inflate(inflater, container, false).run {
        binding = this
        root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.run {
            getString(ARG_MESSAGE)?.let { message -> viewModel.setMessage(message) }
            remove(ARG_MESSAGE)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        initObservers()
    }

    private fun initListeners() {
        binding.readMessage.setOnClickListener {
            viewModel.setMessage(requireContext().getString(R.string.receiver_messages_read))
        }
    }

    private fun initObservers() {
        viewModel.message.observe(viewLifecycleOwner) { message ->
            binding.receiverMessage.text = message
        }
    }

    companion object {

        private const val ARG_MESSAGE = "arg_message"

        fun newInstance(message: String) = ReceiverFragment().apply {
            arguments = bundleOf(ARG_MESSAGE to message)
        }
    }
}
