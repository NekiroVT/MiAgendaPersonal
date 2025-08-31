package nekirovt.myapporganizador.ui.agenda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import nekirovt.myapporganizador.databinding.FragmentSimpleTextBinding

class TareasCompletadasFragment : Fragment() {
    private var _b: FragmentSimpleTextBinding? = null
    private val b get() = _b!!

    override fun onCreateView(i: LayoutInflater, c: ViewGroup?, s: Bundle?): View {
        _b = FragmentSimpleTextBinding.inflate(i, c, false)
        b.textView.text = "Completadas"
        return b.root
    }
    override fun onDestroyView() { super.onDestroyView(); _b = null }
}
