package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs

import com.example.fragment.databinding.FragmentHalamanProfilBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HalamanProfil.newInstance] factory method to
 * create an instance of this fragment.
 */
class HalamanProfil : Fragment() {
    val args : HalamanProfilArgs by navArgs()
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding : FragmentHalamanProfilBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_halaman_profil , container , false)

        val namaDepan = args.namaDepan
        val namaBelakang = args.namaBelakang

        binding.tvName.text = "$namaDepan $namaBelakang"

        binding.button2.setOnClickListener {
            it.findNavController().navigate(R.id.action_halamanProfil_to_fragmentKetiga)
        }

        return binding.root
    }


}