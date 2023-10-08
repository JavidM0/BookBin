package com.example.presentation.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.presentation.databinding.FragmentBookBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookFragment : Fragment() {

    private var _binding: FragmentBookBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<BookViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.composeView.setContent {
            BookScreen(
                viewModel = viewModel,
                navigateToBookDetail = {
                    findNavController().navigate(
                        BookFragmentDirections.actionBookFragmentToBookDetailFragment(
                            bookItem = it
                        )
                    )
                }
            )
        }
    }
}
