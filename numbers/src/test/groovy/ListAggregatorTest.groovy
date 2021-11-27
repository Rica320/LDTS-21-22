import com.aor.numbers.ListAggregator
import com.aor.numbers.ListDeduplicator
import com.aor.numbers.ListSorter
import spock.lang.Specification

class ListAggregatorTest extends Specification {
    List<Integer> list;

    def setup() {
        list = Arrays.asList(1,2,4,2,5)
    }

    def "test the sum method when given list as input"(){
        given:
        def aggregator = new ListAggregator()
        when:
        def result = aggregator.sum(list)
        then:
        result == 14
    }

    def "test the max method for input list"() {
        given:
        def aggregator = new ListAggregator()
        when:
        def result = aggregator.max(list)
        then:
        result == 5
    }

   def "max bug 7263"(){
       given:
       list = Arrays.asList(-1,-4,-5)
       def aggregator = new ListAggregator()
       when:
       def result = aggregator.max(list)
       then:
       result == -1
   }

    def "the distinct method"() {
        given:
        def aggregator = new ListAggregator()
        def sorter = Mock(ListSorter)
        sorter.sort(_ as List<Integer>) >> Arrays.asList(1,2,2,4,5)
        when:
        def result = aggregator.distinct(list,new ListDeduplicator(sorter))
        then:
        result == 4
    }

    def "distinct bug 8726"() {
        given:
        list = Arrays.asList(1,2,4,2)
        def deduplicator = Mock(ListDeduplicator)
        deduplicator.deduplicate(_) >> Arrays.asList(1,2,4)
        def aggregator = new ListAggregator()
        when:
        def result = aggregator.distinct(list,deduplicator)
        then:
        result == 3
    }
}
