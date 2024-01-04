package feature.visitor_list.presentation

import data.api.PatientService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class VisitorListController(
    patientService: PatientService
) {

    private val _state = MutableStateFlow(VisitorListState())
    val state = _state.asStateFlow()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            val patients = patientService.getPatients()
            _state.update { it.copy(patients = patients) }
        }
    }

    fun onEvent(event: VisitorListEvent) {
        when (event) {
            is VisitorListEvent.CheckVisitorDetails -> TODO()
        }
    }

}