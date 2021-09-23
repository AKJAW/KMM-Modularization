package co.touchlab.kmm.todos.list.dependency.domain

import co.touchlab.core.common.TimestampProvider
import co.touchlab.kmm.todos.list.api.data.Todo
import co.touchlab.kmm.todos.list.api.domain.AddTodo
import co.touchlab.kmm.todos.list.dependency.data.InMemoryTodosRepository

internal class AddTodoToMemory(
    private val repository: InMemoryTodosRepository,
    private val timestampProvider: TimestampProvider,
) : AddTodo {

    companion object {
        private val tasks = listOf(
            "Cook a cuisine from a different country",
            "Get Uber Eats food delivered",
            "Eat meat-free meals for an entire month to help combat climate change",
            "Make up a new cocktail",
            "Do a spring clean of the entire house",
            "Give the backyard a makeover",
            "Teach your pet a new trick",
            "Do a DNA test",
            "Drink a gallon (3.8 litres) of water per day for a month",
            "Watch an Arthouse film",
            "Buy something to make working from home more comfortable",
            "Buy a new travel item",
            "Donate to a charity or someone in need",
            "Eat healthy for 2 months",
            "Relax in a bath",
            "Make a list of things you grateful for",
            "Bake something delicious",
            "Create some art for the home",
            "Have a plastic-free week",
            "Rearrange a room in your home",
            "Do a spring clean of your computer",
            "Decorate with nostalgic travel memorabilia",
            "Brew your own kombucha, beer or alcohol",
            "Do a zoom chat or connect with an elderly relative",
            "Video call with a long-distance friend",
            "Do karaoke at home",
            "Stay off social media for a week",
            "Write an entertaining story or poem from your life",
            "Watch an Anime film",
            "Watch a series on travel",
            "Go to the movies or a drive-in cinema",
            "Do 10 hours of language learning on Duolingo",
            "Make a memory book",
            "Start a journal",
            "Read a book you’ve always wanted",
            "Read a book about travel",
            "Read a graphic novel",
            "Meditate for an hour",
            "Write a hand-written letter to someone special and post it",
            "Do something kind for someone and pay it forward",
            "Compliment a stranger",
            "Color in a page from an adult coloring book",
            "Give up alcohol for 1 month",
            "Take an online course to learn a new skill",
            "Make and post a Tik Tok video",
            "Buy a gift card for your favorite local business",
            "Play a board game",
            "Buy a weighted blanket to get better sleep",
            "Buy a houseplant from a local nursery",
            "Paint a plant pot",
        )
    }

    override suspend fun invoke() {
        val currentTimestamp = timestampProvider.getMilliseconds()
        val task = tasks.random()
        val todo = Todo(name = task, timestamp = currentTimestamp)
        repository.add(todo)
    }
}