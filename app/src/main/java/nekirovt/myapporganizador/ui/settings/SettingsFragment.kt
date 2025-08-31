package nekirovt.myapporganizador.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import nekirovt.myapporganizador.databinding.FragmentSimpleTextBinding

class SettingsFragment : Fragment() {
    private var _binding: FragmentSimpleTextBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(i: LayoutInflater, c: ViewGroup?, s: Bundle?): View {
        _binding = FragmentSimpleTextBinding.inflate(i, c, false)
        binding.textView.text = "Pantalla de Configuración"
        return binding.root
    }
    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}
