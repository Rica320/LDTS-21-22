import com.aor.numbers.GenericListFilter
import com.aor.numbers.ListFilterer
import spock.lang.Specification

class ListFiltererTest extends Specification{
    List<Integer> list
    List<Integer> expected

    def setup() {
        list = Arrays.asList(-3,2,0,3)
        expected = Arrays.asList(-3,2,0,3)
    }

    def "testing the filter method with parameter list"() {
        given:
        def filter = Mock(GenericListFilter)
        filter.accept(_ as Integer) >> true
        ListFilterer filterer = new ListFilterer(filter)
        when:
        def result = filterer.filter(list)
        then:
        result == expected
    }
}
