package com.ebookfrenzy.namesave2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ebookfrenzy.namesave2.databinding.FragmentFirstBinding
import androidx.lifecycle.ViewModelProvider
import androidx.databinding.DataBindingUtil
import com.ebookfrenzy.namesave2.BR.myViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    lateinit var binding: FragmentFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_first, container, false)
        binding.lifecycleOwner = this

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (viewModel.output.isEmpty()) {
            binding.outputText.text = "No Names to Display"
        } else {
            binding.outputText.text = viewModel.output.toString()
        }

        binding.setVariable(myViewModel, viewModel)

        binding.addNameButton.setOnClickListener {
            if (binding.inputText.text.isNotEmpty()) {
                viewModel.addName(binding.inputText.text.toString())
                binding.outputText.text = viewModel.output.toString()
            } else {
                binding.outputText.text = "No Name Entered"
            }
        }

    }

}