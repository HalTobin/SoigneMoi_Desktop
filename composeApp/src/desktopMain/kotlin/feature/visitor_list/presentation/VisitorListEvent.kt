package feature.visitor_list.presentation

sealed class VisitorListEvent {
    data class CheckVisitorDetails(val visitorId: Int): VisitorListEvent()
}