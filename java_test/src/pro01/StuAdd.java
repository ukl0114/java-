package pro01;

public class StuAdd {//학생정보입력
    
    String name;
    String no;
    int kor;
    int eng;
    int math;

    public void add() {

        System.out.print("총 몇명의 정보를 입력하시겠습니까?>>");
        int inputN = Driver.sc.nextInt();
        boolean sw = true;
        for (int i = 0; i < inputN; i++) {
            System.out.print("이름입력>>");
            name = Driver.sc.next().trim();
            System.out.print("학번입력>>");
            no = Driver.sc.next().trim();
            System.out.print("국어점수 입력>>");
            int kor = Driver.sc.nextInt();
            System.out.print("영어점수 입력>>");
            int eng = Driver.sc.nextInt();
            System.out.print("수학점수 입력>>");
            int math = Driver.sc.nextInt();

            for(int j = 0; j < Driver.list.size(); j++) {
                if(Driver.list.get(j).getNo().equals(no)) {
                    System.out.println("[" + no + "]번 동일한 학번이 있습니다. 다시 입력해주세요.");
                    sw=false;
                }
            }
            if(sw) Driver.list.add(new Student(name, no, kor, eng, math));

        }System.out.println("총 입력된 학생수:(" + Driver.list.size() + "명)");
    }
}



