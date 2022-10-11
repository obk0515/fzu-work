package com.fzu;

import com.fzu.entity.Student;
import com.fzu.service.StudentService;
import com.fzu.utils.Rand;
import com.fzu.utils.RandByScore;
import com.fzu.utils.RollCall;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@SpringBootTest
class AlgorithmApplicationTests {

    @Autowired
    private StudentService studentService;
    @Autowired
    private RollCall rollCall;
    @Autowired
    private Rand rand;
    @Autowired
    private RandByScore randByScore;

    /**
     * 普通点名
     */
    @Test
    void call() {
        int cnt=0,valid=0;
        //获取缺勤人员
        Map<Integer, List<Integer>> absentMap1 = rand.function1();
        Map<Integer, List<Integer>> absentMap2 = rand.function2();
        for (int i=1;i<=20;i++){
            //获取点名名单
            List<Student> studentList = rollCall.getProgramme(i);
            List<String> studentName=new ArrayList<>();
            List<Integer> studentId=new ArrayList<>();
            for (Student student : studentList) {
                studentName.add(student.getName());
                studentId.add(student.getId());
            }
            //打印点名名单
//            System.out.print("第"+i+"天：");
//            System.out.println(studentName);
            //更新请求次数
            cnt+=studentList.size();
            //获取缺勤人员名单
            List<Integer> absentIdList=new ArrayList<>();
            for (Integer absentId : absentMap1.keySet()) {
                if (absentMap1.get(absentId).contains(i)){
                    absentIdList.add(absentId);
                }
            }
            absentIdList.addAll(absentMap2.get(i));
            //打印缺勤人员名单
//            for (Integer id : absentIdList) {
//                System.out.println(studentService.getById(id).getName());
//            }
            //获取被点到缺勤人员名单
            List<Integer> absentAndCallIdList=new ArrayList<>();
            for (Integer absentId : absentIdList) {
                if (studentId.contains(absentId)){
                    absentAndCallIdList.add(absentId);
                }
            }
            //更新有效点名次数
            valid+=absentAndCallIdList.size();
            //更新被点到缺勤次数
            rollCall.updateAbsent(absentAndCallIdList);
//            System.out.println(absentAndCallIdList);
            //获取点到有来同学名单
            studentId.removeAll(absentAndCallIdList);
            //更新连续出席次数
            studentService.updateConsecutiveAttendCntByIdList(studentId);
        }
        System.out.println("E="+1.0*valid/cnt);
        init();
    }

    /**
     * 根据绩点点名
     */
    @Test
    void callByScore() {
        int cnt=0,valid=0;
        //获取缺勤人员
        Map<Integer, List<Integer>> absentMap1 = randByScore.function1();
        Map<Integer, List<Integer>> absentMap2 = randByScore.function2();
        for (int i=1;i<=20;i++){
            //获取点名名单
            List<Student> studentList = rollCall.getProgrammeByScore(i);
            List<String> studentName=new ArrayList<>();
            List<Integer> studentId=new ArrayList<>();
            for (Student student : studentList) {
                studentName.add(student.getName());
                studentId.add(student.getId());
            }
            //打印点名名单
//            System.out.print("第"+i+"天：");
//            System.out.println(studentName);
            //更新请求次数
            cnt+=studentList.size();
            //获取缺勤人员名单
            List<Integer> absentIdList=new ArrayList<>();
            for (Integer absentId : absentMap1.keySet()) {
                if (absentMap1.get(absentId).contains(i)){
                    absentIdList.add(absentId);
                }
            }
            absentIdList.addAll(absentMap2.get(i));
            //打印缺勤人员名单
//            for (Integer id : absentIdList) {
//                System.out.println(studentService.getById(id).getName());
//            }
            //获取被点到缺勤人员名单
            List<Integer> absentAndCallIdList=new ArrayList<>();
            for (Integer absentId : absentIdList) {
                if (studentId.contains(absentId)){
                    absentAndCallIdList.add(absentId);
                }
            }
            //更新有效点名次数
            valid+=absentAndCallIdList.size();
            //更新被点到缺勤次数
            rollCall.updateAbsent(absentAndCallIdList);
//            System.out.println(absentAndCallIdList);
            //获取点到有来同学名单
            studentId.removeAll(absentAndCallIdList);
            //更新连续出席次数
            studentService.updateConsecutiveAttendCntByIdList(studentId);
        }
        System.out.println("E="+1.0*valid/cnt);
        init();
    }

    @Test
    void randCreate(){
        Rand rand=new Rand();
        System.out.println(rand.function1());
        System.out.println(rand.function2());
    }

    @Test
    void randByScoreCreate(){
        RandByScore randByScore=new RandByScore();
        System.out.println(randByScore.function1());
        System.out.println(randByScore.function2());
    }

    /**
     * 初始化学生表
     */
    @Test
    void init(){
        List<Student> list = studentService.list();
        for (Student student : list) {
            student.setValidCnt(0);
            student.setConsecutiveAttendCnt(0);
            studentService.updateById(student);
        }
    }

    /**
     * 调用100次普通点名
     */
    @Test
    void testE(){
        for (int i=0;i<100;i++){
            call();
        }
    }

    /**
     * 调用100次根据绩点点名
     */
    @Test
    void testE1(){
        for (int i=0;i<100;i++){
            callByScore();
        }
    }

}
