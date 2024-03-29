package com.example.soignemoi.feature.prescription.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import data.model.Frequency
import data.model.PrescriptionEntry

@Composable
fun PrescriptionEntryItem(
    modifier: Modifier = Modifier,
    entry: PrescriptionEntry
) {

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(8.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.titleMedium,
                text = entry.medicine.title
            )
            Text(text = "${entry.dosage} / ${Frequency.getFromId(entry.frequency).title}")
        }
        Text(text = entry.note)
    }
    Spacer(modifier = Modifier.height(16.dp))

}