package pt.ipg.trabalhofinal

import android.database.Cursor
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.loader.app.LoaderManager
import androidx.loader.content.Loader
import pt.ipg.trabalhofinal.databinding.FragmentInserirCarrosBinding
import pt.ipg.trabalhofinal.databinding.FragmentListaCarrosBinding
/**
 * A simple [Fragment] subclass.
 * Use the [InserirLivroFragment.newInstance] factory method to
 * create an instance of this fragment.
 */


class InserirCarrosFragment : Fragment() {

    private var _binding: FragmentListaCarrosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      _binding = FragmentListaCarrosBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inserir_carros, container, false)
    }

    companion object {

    }
}