import com.aor.numbers.ListDeduplicator
import com.aor.numbers.ListSorter
import spock.lang.Specification

class ListDeduplicatorTest extends Specification {
    List<Integer> list
    List<Integer> expected

    def setup() {
        list = Arrays.asList(1,2,4,2,5)
        expected = Arrays.asList(1,2,4,5)
    }

    def "testing the deduplicate function with parameter list"() {
        given:
        def sorter = Mock(ListSorter)
        sorter.sort(_ as List<Integer>) >> Arrays.asList(1,2,4,5)
        def deduplicator = new ListDeduplicator(sorter)
        when:
        def result = deduplicator.deduplicate(list)
        then:
        result == expected
    }

    def "bug in deduplicate 8726"() {
        given:
        list = Arrays.asList(1,2,4,2)
        expected = Arrays.asList(1,2,4)
        def sorter = Mock(ListSorter)
        sorter.sort(_ as List<Integer>) >> Arrays.asList(1,2,2,4)
        def deduplicator = new ListDeduplicator(sorter)
        when:
        def result = deduplicator.deduplicate(list)
        then:
        result == expected
    }

}
