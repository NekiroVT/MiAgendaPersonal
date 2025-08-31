package nekirovt.myapporganizador.ui.agenda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import nekirovt.myapporganizador.databinding.FragmentSimpleTextBinding

class TareasPendientesFragment : Fragment() {
    private var _b: FragmentSimpleTextBinding? = null
    private val b get() = _b!!

    override fun onCreateView(i: LayoutInflater, c: ViewGroup?, s: Bundle?): View {
        _b = FragmentSimpleTextBinding.inflate(i, c, false)
        b.textView.text = "Pendientes"
        return b.root
    }
    override fun onDestroyView() { super.onDestroyView(); _b = null }
}
