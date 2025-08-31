package nekirovt.myapporganizador.ui.agenda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import nekirovt.myapporganizador.databinding.FragmentAgendaBinding

class AgendaFragment : Fragment() {

    private var _binding: FragmentAgendaBinding? = null
    private val binding get() = _binding!!

    private val tabTitles = listOf("Pendientes", "En progreso", "Completadas")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAgendaBinding.inflate(inflater, container, false)

        binding.viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = 3
            override fun createFragment(position: Int) = when (position) {
                0 -> TareasPendientesFragment()
                1 -> TareasEnProgresoFragment()
                else -> TareasCompletadasFragment()
            }
        }

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
            tab.text = tabTitles[pos]
        }.attach()

        return binding.root
    }

    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}
