import com.aor.numbers.PositiveFilter
import spock.lang.Specification

class PositiveFilterTest extends Specification{

    PositiveFilter filter

    def setup() {
        filter = new PositiveFilter()
    }

    def "positive input"() {
        expect:
        filter.accept(Integer.MAX_VALUE)
    }

    def "negative input"() {
        expect:
        !filter.accept(Integer.MIN_VALUE)
    }

    def "neutral value"() {
        expect:
        !filter.accept(0)
    }

}
