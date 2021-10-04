package co.touchlab.kmm.todos.count.dependency.domain

import app.cash.turbine.test
import co.touchlab.core.common.TimestampProvider
import co.touchlab.core.test.BaseTest
import co.touchlab.kmm.todos.list.api.data.Todo
import co.touchlab.kmm.todos.list.api.domain.GetTodos
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class RetrieveCorrectCount : BaseTest() {

    private lateinit var getTodos: GetTodos
    private lateinit var timestampProvider: TimestampProvider
    private lateinit var getCount: GetTodoCountFromList

    @BeforeTest
    fun setUp() {
        timestampProvider = object : TimestampProvider {
            override fun getMilliseconds(): Long  = 0
        }
        getTodos = GetTodosFake(listOf(Todo("1", 0), Todo("2", 0)))
        getCount = GetTodoCountFromList(getTodos, timestampProvider)
    }

    @Test
    fun `Retrieves the count based on the todos list`() = runTest {
        val result = getCount()

        result.test {
            assertEquals(2, awaitItem().value)

            cancelAndIgnoreRemainingEvents()
        }
    }
}

class GetTodosFake(private val todos: List<Todo>) : GetTodos {

    override fun invoke(): Flow<List<Todo>> {
        return flowOf(todos)
    }
}