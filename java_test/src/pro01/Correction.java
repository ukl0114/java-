package pro01;



public class Correction { //학생정보수정
    public void correct() {
        System.out.print("정보를 변경하려는 학생의 학번을 입력해주세요.>>");
        String SearchNo = Driver.sc.next().trim(); //변경하기위해 찾는학번

        int searchN = 0;//변경하려는 학생 인덱스
        boolean sw=true; //스위치변수
        for (int i = 0; i < Driver.list.size(); i++) {
            if(Driver.list.get(i).getNo().equals(SearchNo)) {
                searchN = i;
                sw=false;
            }
        }if(sw) System.out.println("변경하려는 학생을 찾을 수 없습니다.");

        System.out.print("변경하려는 내용의 번호를 입력해주세요.>>");
        System.out.println("1.이름 2.학번 3.국어점수 4.영어점수 5.수학점수");

        int menuN = Driver.sc.nextInt();
        switch(menuN) {
            case 1 :
                System.out.print(">>");
                String name = Driver.sc.next().trim();
                Driver.list.get(searchN).setName(name);
                break;

            case 2 :
                System.out.print(">>");
                String no = Driver.sc.next().trim();
                Driver.list.get(searchN).setNo(no);
                break;

            case 3 :
                System.out.print(">>");
                int kor = Driver.sc.nextInt();
                Driver.list.get(searchN).setKor(kor);
                break;

            case 4 :
                System.out.print(">>");
                int eng = Driver.sc.nextInt();
                Driver.list.get(searchN).setEng(eng);
                break;

            case 5 :
                System.out.print(">>");
                int math = Driver.sc.nextInt();
                Driver.list.get(searchN).setMath(math);
                break;
        }
        System.out.println("변경이 완료되었습니다.");
    }
}
