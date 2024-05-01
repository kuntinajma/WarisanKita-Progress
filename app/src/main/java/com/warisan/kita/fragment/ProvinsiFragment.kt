package com.warisan.kita.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.warisan.kita.Data
import com.warisan.kita.R
import com.warisan.kita.adapter.ProvinsiAdapter
import com.warisan.kita.databinding.FragmentProvinsiBinding
import com.warisan.kita.model.Provinsi

class ProvinsiFragment : Fragment() {
    private lateinit var binding:FragmentProvinsiBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentProvinsiBinding.inflate(inflater,container,false)
        with(binding){
            rvProvinsi.layoutManager = LinearLayoutManager(requireContext())
            rvProvinsi.adapter = ProvinsiAdapter(Data.LIST_PROVINSI,object : ProvinsiAdapter.ProvinsiAdapterListener{
                override fun onClick(provinsi: Provinsi) {
                    val b = Bundle()
                    b.putSerializable("provinsi",provinsi)
                    findNavController().navigate(R.id.action_provinsiFragment_to_destinasiFragment,b)
                }
            })
        }
        return binding.root
    }
}