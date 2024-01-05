package com.example.soignemoi.feature.patient_details.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.model.Prescription
import feature.visitor_list.presentation.VisitorListState
import feature.visitor_list.presentation.component.PrescriptionDialog
import feature.visitor_list.presentation.component.PrescriptionItem

@Composable
fun PrescriptionPage(
    modifier: Modifier = Modifier,
    state: VisitorListState
) {

    var selectedPrescription by remember { mutableStateOf<Prescription?>(null) }

    selectedPrescription?.let {
        PrescriptionDialog(
            prescription = it,
            onDismiss = { selectedPrescription = null }
        )
    }

    state.patientData?.let { data ->
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(data.prescriptions.sortedByDescending { it.start }) { prescription ->
                Column {
                    PrescriptionItem(
                        prescription = prescription,
                        onSelect = { selectedPrescription = it }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }

}