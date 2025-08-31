package nekirovt.myapporganizador.ui.home

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import nekirovt.myapporganizador.R
import nekirovt.myapporganizador.databinding.FragmentSimpleTextBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentSimpleTextBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSimpleTextBinding.inflate(inflater, container, false)
        binding.textView.text = "Bienvenido a Inicio"
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Cambia el título de la Toolbar cuando estás en Inicio
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Inicio"

        // Menú propio de este fragment
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menu.clear()
                menuInflater.inflate(R.menu.menu_home, menu)

                val searchItem = menu.findItem(R.id.action_search)
                val searchView = searchItem.actionView as SearchView
                searchView.queryHint = "Buscar en Inicio…"
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        // Aquí puedes filtrar una lista o hacer la búsqueda
                        return true
                    }
                    override fun onQueryTextChange(newText: String?): Boolean = false
                })
            }

            override fun onMenuItemSelected(item: MenuItem): Boolean {
                return when (item.itemId) {
                    R.id.action_about -> {
                        MaterialAlertDialogBuilder(requireContext())
                            .setTitle("Acerca de")
                            .setMessage(
                                "Bienvenido a MiAppOrganizador \n\n" +
                                        "Pantalla de Inicio\n" +
                                        "Versión 1.0\n" +
                                        "Devoleper: NekiroVT"
                            )
                            .setPositiveButton("OK", null)
                            .show()
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
