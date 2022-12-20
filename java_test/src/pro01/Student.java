package pro01;

public class Student implements Comparable<Student>{

    private String name; //이름
    private String no;	//학번(중복불가)
    private int kor; //국어점수
    private int eng; //영어점수
    private int math; //수학점수
    private int sum; //국영수 합계
    private double avg; //국영수 평균


    public Student(String name, String no, int kor, int eng, int math) {
        this.name = name;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    //게터
    public String getName() {return name;}
    public String getNo() {return no;}
    public int getKor() {return kor;}
    public int getEng() {return eng;}
    public int getMath() {return math;}

    //세터
    public void setName(String name) {this.name = name;}
    public void setNo(String no) {this.no = no;}
    public void setKor(int kor) {this.kor = kor;}
    public void setEng(int eng) {this.eng = eng;}
    public void setMath(int math) {this.math = math;}

    public int stuSum() { //총점구하는 메서드
        return kor+eng+math;
    }

    public double stuAvg() { //점수 평균값구해서 소수점 둘째자리에서 반올림
        return Math.round((stuSum()/3.0)*10)/10.0;
    }

    //equals오버라이딩
    @Override
    public String toString() {
        return "[이름=" + name + ", 학번=" + no + ", 국어점수=" + kor  + "점"+ ", 영어점수=" + eng+ "점" + ", " +
                "수학점수=" + math + "점"+ ", 총점=" + stuSum() + "점" + ", 평균점수=" + stuAvg() + "점]";
    }

    //compareTo 구현 (총점 내림차순)
    public int compareTo(Student student) {
        return Integer.compare(student.stuSum(),this.stuSum()) ;
    }
}




