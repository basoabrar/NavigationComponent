package com.example.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavAction
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.fragment.databinding.FragmentHalamanKategoriBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HalamanKategori.newInstance] factory method to
 * create an instance of this fragment.
 */
class HalamanKategori : Fragment() {
    private lateinit var  drawerLayoutInflater : DrawerLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding : FragmentHalamanKategoriBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_halaman_kategori , container , false)

        val menuHost : MenuHost = requireActivity()





        binding.button.setOnClickListener {
            var namaDepan =  binding.edtNamaDepan.text.toString()
            var namaBelakang = binding.edtNamaBelakang.text.toString()
            it.findNavController()
                .navigate(HalamanKategoriDirections.actionHalamanKategoriToHalamanProfil(namaDepan,namaBelakang))
        }
        menuHost.addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.overflow_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return NavigationUI.onNavDestinationSelected(menuItem , requireView().findNavController())
            }

        } , viewLifecycleOwner)

        return binding.root

    }
}