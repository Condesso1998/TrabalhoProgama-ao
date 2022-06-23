package pt.ipg.trabalhofinal


import android.database.Cursor
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.loader.app.LoaderManager
import androidx.loader.content.Loader
import androidx.navigation.fragment.findNavController
import pt.ipg.trabalhofinal.databinding.FragmentListaCarrosBinding



/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ListaCarrosFragment : Fragment() {

    private var _binding: FragmentListaCarrosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentListaCarrosBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

   //     binding.buttonSecond.setOnClickListener {
     //       findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
      //  }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}