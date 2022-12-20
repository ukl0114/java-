

public class StuCheck {//특정학생조회

    public void check() {
        System.out.print("찾으려는 학생의 학번을 입력해주세요.>>");
        String no = Driver.sc.next().trim();
        boolean sw=true;

        for (int i = 0; i < Driver.list.size(); i++) {
            if(Driver.list.get(i).getNo().equals(no)) {
                System.out.println(Driver.list.get(i).toString());
                sw=false;
                break;
            }
        }if(sw) System.out.println("찾으시는 학생이 없습니다.");

    }
}

