package com.samrraa.qurioapp.model

class FakeQuizRepository {
    fun getQuestions(): List<String> {
        return listOf(
            "If animals could talk, which one would be the rudest?",
            "Would you rather fight one horse-sized duck or 100 duck-sized horses?",
            "If you were a vegetable, which one would you be?",
            "What’s the worst name you could give to a new planet?",
            "If pizza didn’t exist, what food would rule the world?",
            "If you could replace your nose with anything, what would you choose?",
            "If you were invisible for a day, what’s the silliest thing you would do?"
        )
    }
}