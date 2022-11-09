package com.kola.basic.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import com.kola.basic.data.local.room.tables.SampleEntity
import com.kola.basic.databinding.FragmentHomeBinding
import com.kola.basic.util.observeLiveData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val sampleViewModel: SampleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sampleViewModel.getSample()


        viewLifecycleOwner.lifecycle.coroutineScope.launch {
            sampleViewModel.insertSample(SampleEntity(id= 12, name = "Leslie"))
        }

        observeLiveData(sampleViewModel.sampleResponse){
            Toast.makeText(requireContext(), "List->>>${it}", Toast.LENGTH_SHORT).show()
        }
    }
}