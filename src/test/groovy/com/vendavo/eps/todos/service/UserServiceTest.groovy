package com.vendavo.eps.todos.service

import com.vendavo.eps.todos.client.IExternalUserClient
import com.vendavo.eps.todos.domain.User
import spock.lang.Specification

class UserServiceTest extends Specification {

    private UserService service
    private IExternalUserClient client

    def setup() {
        client = Mock(IExternalUserClient)
        service = new UserService(client)
    }

    def "test getUsers"() {
        given:
        def users = [Stub(User) { getId() >> 1 }, Stub(User) { getId() >> 2 }, Stub(User) { getId() >> 3 }]

        when:
        def result = service.getUsers()

        then:
        result == users
        1 * client.getUsers() >> users
    }

    def "test getUser"() {
        given:
        def users = [Stub(User) { getId() >> 1 }, Stub(User) { getId() >> 2 }, Stub(User) { getId() >> 3 }]

        when:
        def result = service.getUser(userId)

        then:
        result != null
        result?.id == resultId
        1 * client.getUsers() >> users

        where:
        userId || resultId
        1L     || 1L
        2L     || 1L
        3L     || 1L
        4L     || 1L
    }
}
