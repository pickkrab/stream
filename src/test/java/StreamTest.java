import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StreamTest {
    private Stream<Workman> stream;
    private List<Workman> list;

    @Before
    public void setUp() throws Exception {
        stream = new Stream<>();
        list = new ArrayList<>();
        list.add(new Workman(null, 20, 0));
        list.add(new Workman("Sasha", 21, 1));
        list.add(new Workman("Matvey", 20, 4));
        list.add(new Workman("Dima", 22, 6));
        stream = Stream.of(list);
    }

    @Test
    public void FilterTest() throws Exception {
        assertEquals(stream.filter(s -> s.getName != null).toList().size(), list.size() - 1);
        assertEquals(stream.filter(s -> s.getAge() < 22).toList().size(), 3);
    }

    @Test
    public void testToMap() throws Exception {
        Map<String, Integer> map = stream.toMap(Workman::getName, Workman::getExperience);
    }

}
