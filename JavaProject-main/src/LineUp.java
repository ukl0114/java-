
import java.util.stream.Stream;

public class LineUp { //총점 내림차순으로 정렬
    public void lineUp() {
        System.out.println("총점이 높은 순으로 정렬됩니다.");
        Stream<Student> stream = Driver.list.stream();
        stream.sorted().forEach(System.out::println);
    }
}


