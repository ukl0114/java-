package pro01;


import java.util.stream.Stream;

public class Analysis {//분석(총학생수/국어,영어,수학점수 평균구하기)

    public void analysis() {
        System.out.println("입력된 총 학생수: " + Driver.list.size());//입력된 총 학생수 구하기

        //국어점수평균구하기
        double avgKor = Driver.list.stream().mapToInt(Student::getKor)
                .average()
                .getAsDouble();
        System.out.println("국어점수 평균" + Math.round(avgKor*100)/100.0);

        //영어점수 평균 구하기
        double avgEng = Driver.list.stream().mapToInt(Student::getEng)
                .average()
                .getAsDouble();
        System.out.println("영어점수 평균" + Math.round(avgEng*100)/100.0);


        //영어점수 평균 구하기
        double avgMath = Driver.list.stream().mapToInt(Student::getMath)
                .average()
                .getAsDouble();
        System.out.println("수학점수 평균" + Math.round(avgMath*100)/100.0);


    }

}



