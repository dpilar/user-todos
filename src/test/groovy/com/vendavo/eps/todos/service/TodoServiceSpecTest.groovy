package com.vendavo.eps.todos.service

import com.vendavo.eps.todos.client.IExternalUserClient
import com.vendavo.eps.todos.domain.Todo
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
}
