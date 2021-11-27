import com.aor.numbers.DivisibleByFilter
import spock.lang.Specification

class DivisibleByFilterTest extends Specification{
    def filter
    def setup() {
        filter = new DivisibleByFilter(5)
    }
    def "test when it shouldn't be divisible"() {
        when:
        def result = filter.accept(3)
        then:
        !result
    }

    def "test when it should be divisible"() {
        when:
        def result = filter.accept(25)
        then:
        result
    }

    def "test if neutral is accepted"() {
        when:
        def result = filter.accept(0)
        then:
        result
    }
}
