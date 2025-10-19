package com.vendavo.eps.todos.service

import com.vendavo.eps.todos.client.IExternalUserClient
import com.vendavo.eps.todos.domain.Todo
import com.vendavo.eps.todos.domain.User
import spock.lang.Specification

class TodoServiceSpecTest extends Specification {

    private TodoService service
    private IExternalUserClient client

    def setup() {
        client = Mock(IExternalUserClient)
        service = new TodoService(client)
    }

    def "test getTodos"() {
        given:
        def todos = [Stub(Todo) { getId() >> 1 }, Stub(Todo) { getId() >> 2 }, Stub(Todo) { getId() >> 3 }]

        when:
        def result = service.getTodos()

        then:
        result == todos
        1 * client.getTodos() >> todos
    }

    def "test getTodosByUserName"() {
        given:
        def users = [
                Stub(User) { getId() >> 1; getUsername() >> "Alice" },
                Stub(User) { getId() >> 2; getUsername() >> "Bob" },
                Stub(User) { getId() >> 3; getUsername() >> "Charlie" }
        ]

        def todos = [
                Stub(Todo) { getId() >> 1; getUserId() >> 1 },
                Stub(Todo) { getId() >> 2; getUserId() >> 2 },
                Stub(Todo) { getId() >> 3; getUserId() >> 1 }
        ]

        when:
        def result = service.getTodosByUserName(userName)

        then:
        result*.id == expectedIds
        1 * client.getUsers() >> users
        1 * client.getTodos() >> todos

        where:
        userName  || expectedIds
        "Alice"   || [1, 3]
        "Bob"     || [2]
        "Charlie" || []
    }
}
