package com.example.barbershop.ui.schedules.barber.barberdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.barbershop.data.items.Comment
import com.example.barbershop.data.items.Feedback

class BarberDetailViewModel : ViewModel() {

    private val _ItemFeedbackList = MutableLiveData<List<Feedback>>()
    val ItemFeedbackList : LiveData<List<Feedback>> get() = _ItemFeedbackList

    private val _itemComment = MutableLiveData<List<Comment>>()
    val itemComment : LiveData<List<Comment>> get() = _itemComment

    init {

        var dummyData = listOf(Feedback("Pontualidade", 142),
                                         Feedback("Ótimo papo", 119),
                                         Feedback("Atendimento", 119),
                                         Feedback("Respeitoso", 99)
            )

        var dummyComment = listOf(Comment("Como sempre nota máxima", "2 dias atrás"),
                                  Comment("Profissional excelente", "3 dias atrás"),
                                  Comment("Atendimento excelente", "4 dias atrás"),
                                  Comment("Ótimo atendimento desde a recepção até o fim do serviço. Profissional é de algo calibre e confiabilidade", "2 dias atrás")
            )

        _ItemFeedbackList.value = dummyData

        _itemComment.value = dummyComment


    }


}