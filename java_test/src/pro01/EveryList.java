package pro01;

import java.util.stream.Stream;

public class EveryList { //전체학생출력

    public void listAllPrintOut() {
        if(Driver.list.size()==0) System.out.println("저장된 정보가 없습니다.");

        Stream<Student> stream = Driver.list.stream();
        stream.forEach(System.out::println);
    }
}


