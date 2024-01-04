package com.example.soignemoi.feature.patient_details.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import feature.visitor_list.presentation.VisitorListState
import feature.visitor_list.presentation.component.PrescriptionItem

@Composable
fun PrescriptionPage(
    modifier: Modifier = Modifier,
    state: VisitorListState
) {

    state.patientData?.let { data ->
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(data.prescriptions.sortedByDescending { it.start }) { prescription ->
                Column {
                    PrescriptionItem(prescription = prescription)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }

}