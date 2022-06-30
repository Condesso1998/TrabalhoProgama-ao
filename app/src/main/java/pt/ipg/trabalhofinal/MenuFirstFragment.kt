package pt.ipg.trabalhofinal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import pt.ipg.trabalhofinal.databinding.ActivityMainBinding.inflate
import pt.ipg.trabalhofinal.databinding.FragmentMenuPrincipalBinding


class MenuFirstFragment: Fragment() {

    private var _binding: FragmentMenuPrincipalBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMenuPrincipalBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonCliente.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

            val activity = activity as MainActivity
            activity.idMenuAtual = R.menu.menu_main
    }

     fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
}