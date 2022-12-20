package pro01;


public class Delete { //학생정보 삭제

    public void delete() {
        System.out.println("메뉴를 선택해주세요");
        System.out.println("1.특정학생정보 삭제 2.전체삭제");
        int menuN = Driver.sc.nextInt();
        if(menuN==1) {//특정학생정보삭제
            System.out.println("삭제하려는 학생의 학번을 입력해주세요.");
            String stuNo = Driver.sc.next().trim();

            boolean sw=true;
            for (int i = 0; i < Driver.list.size(); i++) {
                if(Driver.list.get(i).getNo().equals(stuNo)) {
                    System.out.println(Driver.list.get(i).getName() + "학생의 정보를 삭제했습니다.");
                    Driver.list.remove(i);
                    sw=false;
                    break;
                }
            }if(sw) System.out.println("변경하려는 학생을 찾을 수 없습니다.");

        }else if(menuN==2) {//전체삭제
            Driver.list.clear();
            System.out.println("모든 학생들의 정보를 삭제했습니다.");
        }else System.out.println("다시 입력해주세요.");
    }
}



