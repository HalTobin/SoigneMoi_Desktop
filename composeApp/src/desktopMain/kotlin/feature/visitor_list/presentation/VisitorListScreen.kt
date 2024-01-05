package feature.visitor_list.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.soignemoi.feature.patient_details.presentation.components.PrescriptionPage
import data.Strings
import feature.visitor_list.presentation.PatientDetailsTab.Companion.TAB_ITEMS
import feature.visitor_list.presentation.component.NotePage
import feature.visitor_list.presentation.component.PatientItem
import feature.visitor_list.presentation.component.PrescriptionDialog
import kotlinx.coroutines.launch
import ui.component.DisconnectHeader
import ui.component.PatientHeader
import ui.util.NavController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VisitorListScreen(
    navController: NavController,
    state: VisitorListState,
    onEvent: (VisitorListEvent) -> Unit,
) {

    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val pagerState = rememberPagerState { TAB_ITEMS.size }

    val scope = rememberCoroutineScope()

    Scaffold {
        Column(modifier = Modifier.fillMaxSize()) {
            DisconnectHeader(onDisconnect = { navController.navigateBack() })
            Row {
                Column(
                    modifier = Modifier.padding(top = 16.dp).width(310.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = Strings.PATIENT_LIST.uppercase(),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Divider(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                        thickness = 1.dp)
                    LazyColumn {
                        itemsIndexed(state.patients) { index, patient ->
                            Column(modifier = Modifier
                                .background(if (state.patientData?.id == patient.id) Color.LightGray else MaterialTheme.colorScheme.background)
                                .clickable {
                                    onEvent(VisitorListEvent.CheckVisitorDetails(patient.id))
                                }) {
                                PatientItem(patient = patient)
                                if (index < state.patients.lastIndex) Divider(modifier = Modifier
                                    .padding(horizontal = 8.dp)
                                    .fillMaxWidth(),
                                    thickness = 1.dp)
                            }
                        }
                    }
                }
                Divider(Modifier.width(1.dp).fillMaxHeight(), thickness = 1.dp)
                Column(modifier = Modifier.weight(1f)) {
                    if (state.patientData != null) {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            PatientHeader(patient = state.patientData)
                            Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp)
                            TabRow(selectedTabIndex = selectedTabIndex) {
                                TAB_ITEMS.forEach() { item ->
                                    Tab(
                                        selected = (item.id == selectedTabIndex),
                                        onClick = {
                                            selectedTabIndex = item.id
                                            scope.launch { pagerState.animateScrollToPage(selectedTabIndex) }
                                        },
                                        text = { Text(item.title.uppercase()) }
                                    )
                                }
                            }
                            HorizontalPager(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                                userScrollEnabled = true,
                                state = pagerState) { index ->
                                when (index) {
                                    PatientDetailsTab.Notes.id -> NotePage(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .weight(1f),
                                        state = state
                                    )
                                    PatientDetailsTab.Prescriptions.id -> PrescriptionPage(
                                        modifier = Modifier.fillMaxWidth().weight(1f),
                                        state = state
                                    )
                                }
                            }
                        }
                    }
                    else {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(Strings.SELECT_PATIENT)
                        }
                    }
                }
            }
        }
    }
}

sealed class PatientDetailsTab(val title: String, val id: Int) {
    object Notes: PatientDetailsTab(title = "Notes", id = 0)
    object Prescriptions: PatientDetailsTab(title = "Prescriptions", id = 1)

    companion object {
        val TAB_ITEMS: List<PatientDetailsTab> = listOf(Notes, Prescriptions)
    }
}