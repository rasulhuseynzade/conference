import com.az.example.conference.mapper.SessionMapper
import com.az.example.conference.model.SessionViewDto
import com.az.example.conference.service.SessionService
import org.springframework.data.domain.PageRequest
import spock.lang.Specification

class SessionServiceSpec extends Specification{
    def "test getSessionList"() {
        given:
        def sessionRepository = Mock(SessionViewDto)
        def sessionMapper = Mock(SessionMapper)
        def sessionService = new SessionService(sessionRepository, sessionMapper)

        def pageable = PageRequest.of(0, 10)
        def sessionEntityList = [Mock()]
        sessionRepository.findAll(pageable) >> sessionEntityList
        sessionMapper.entityToDto(_) >> {Mock()}

        when:
        def result = sessionService.getSessionList(pageable)

        then:
        1 * sessionRepository.findAll(pageable)
        1 * sessionMapper.entityToDto(_)

        result.size() == sessionEntityList.size()
    }

    def "test createdSession"() {
        given:
        def sessionRepository = Mock(SessionViewDto)
        def sessionMapper = Mock(SessionMapper)
        def sessionService = new SessionService(sessionRepository, sessionMapper)

        def sessionViewDto = Mock(SessionViewDto)

        when:
        sessionService.createdSession(sessionViewDto)

        then:
        1 * sessionMapper.dtoToEntity(sessionViewDto)
        1 * sessionRepository.save(_)
    }

    def "test updateSession"() {
        given:
        def sessionRepository = Mock(SessionViewDto)
        def sessionMapper = Mock(SessionMapper)
        def sessionService = new SessionService(sessionRepository, sessionMapper)

        def sessionId = 1L
        def sessionViewDto = Mock(SessionViewDto)

        when:
        sessionService.updateSession(sessionId, sessionViewDto)

        then:
        1 * sessionMapper.dtoToEntity(sessionId, sessionViewDto)
        1 * sessionRepository.save(_)
    }

    def "test deleteSession"() {
        given:
        def sessionRepository = Mock(SessionViewDto)
        def sessionService
        sessionService = new SessionService(sessionRepository, new SessionService())

        def sessionId = 1L

        when:
        sessionService.deleteSession(sessionId)

        then:
        1 * sessionRepository.deleteById(sessionId)
    }
}

