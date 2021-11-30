import com.aor.numbers.ListSorter
import spock.lang.Specification

class ListSorterTest extends Specification{

    List<Integer> list
    List<Integer> expected

    def setup() {
        list = Arrays.asList(3, 2, 6, 1, 4, 5, 7)
        expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7)
    }

    def "test sort"() {
        given:
        ListSorter sorter = new ListSorter()
        when:
        def result = sorter.sort(list)
        then:
        result == expected
    }

    def "test sort bug 8276"() {
        given:
        def sorter = new ListSorter()
        when:
        def result = sorter.sort(Arrays.asList(1,2,4,2))
        then:
        result == Arrays.asList(1,2,2,4)
    }
}
